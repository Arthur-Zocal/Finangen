package com.finangen.services;
import com.finangen.domains.ContaBancaria;
import com.finangen.domains.Lancamento;
import com.finangen.domains.dtos.ContaBancariaDTO;
import com.finangen.domains.dtos.LancamentoDTO;
import com.finangen.domains.enums.TipoLancamento;
import com.finangen.repositories.ContaBancariaRepository;
import com.finangen.repositories.LancamentoRepository;
import com.finangen.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LancamentoService {
    /*

  PRECISA FAZER OS TREM PARA CREDITO(entrou na conta) DEBITO(saiu da conta)
    E MAIS ALGUNS NEGOCIOS QUE NAO SEI
*/
    @Autowired
    private LancamentoRepository lancamentoRepo;

    @Autowired
    private ContaBancariaRepository contaBancariaRepo;


    public List<LancamentoDTO> findAll(){
        return lancamentoRepo.findAll().stream()
                .map(obj -> new LancamentoDTO(obj))
                        .collect(Collectors.toList());
    }

    public Lancamento findById(Long id){
        Optional<Lancamento> obj = lancamentoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado, ID: " + id));
    }

    public Lancamento create(LancamentoDTO objDto){
        objDto.setIdLancamento(null);
        Lancamento newObj = new Lancamento(objDto);
        return lancamentoRepo.save(newObj);
    }

    public Lancamento update(Long id, LancamentoDTO objDto){
        objDto.setIdLancamento(id);
        Lancamento oldObj = findById(id);
        oldObj = new Lancamento(objDto);
        return lancamentoRepo.save(oldObj);
    }

    public void delete(Long id){
        lancamentoRepo.deleteById(id);
    }

    @Autowired
    public LancamentoService(ContaBancariaRepository contaBancariaRepository,
                             LancamentoRepository lancamentoRepository) {
        this.contaBancariaRepo = contaBancariaRepository;
        this.lancamentoRepo = lancamentoRepository;
    }

    public Lancamento creditar(Long contaId, BigDecimal valor, String descricao) {
        ContaBancaria conta = contaBancariaRepo.findById(contaId)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        conta.setSaldoConta(conta.getSaldoConta().add(valor));

        Lancamento lancamento = new Lancamento();
        lancamento.setContaBancaria(conta);
        lancamento.setValorLancamento(valor);
        lancamento.setTipoLancamento(TipoLancamento.CREDITO);
        lancamento.setDescricao(descricao);
        lancamento.setDataLancamento(LocalDate.from(LocalDateTime.now()));

        contaBancariaRepo.save(conta);
        return lancamentoRepo.save(lancamento);
    }

    public Lancamento debitar(Long contaId, BigDecimal valor, String descricao) {
        ContaBancaria conta = contaBancariaRepo.findById(contaId)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        if (conta.getSaldoConta().compareTo(valor) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        conta.setSaldoConta(conta.getSaldoConta().subtract(valor));

        Lancamento lancamento = new Lancamento();
        lancamento.setContaBancaria(conta);
        lancamento.setValorLancamento(valor);
        lancamento.setTipoLancamento(TipoLancamento.DEBITO);
        lancamento.setDescricao(descricao);
        lancamento.setDataLancamento(LocalDate.from(LocalDateTime.now()));

        contaBancariaRepo.save(conta);
        return lancamentoRepo.save(lancamento);
}


}
