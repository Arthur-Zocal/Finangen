package com.finangen.services;
import com.finangen.domains.Lancamento;
import com.finangen.domains.dtos.ContaBancariaDTO;
import com.finangen.domains.dtos.LancamentoDTO;
import com.finangen.repositories.LancamentoRepository;
import com.finangen.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<LancamentoDTO> findAll(){
        return lancamentoRepo.findAll().stream()
                .map(obj -> new LancamentoDTO(obj))
                .collect(Collectors.toList());
    }

    public Lancamento findByIdLancamento(Long idLancamento){
        Optional<Lancamento> obj = lancamentoRepo.findByIdLancamento(idLancamento);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado, ID: " + idLancamento));
    }

    public Lancamento create(LancamentoDTO objDto){
        objDto.setIdLancamento(null);
        Lancamento newObj = new Lancamento(objDto);
        return lancamentoRepo.save(newObj);
    }

    public Lancamento update(Long idLancamento, LancamentoDTO objDto){
        objDto.setIdLancamento(idLancamento);
        Lancamento oldObj = findByIdLancamento(idLancamento);
        oldObj = new Lancamento(objDto);
        return lancamentoRepo.save(oldObj);
    }

    public void delete(Long idLancamento){
        lancamentoRepo.deleteById(idLancamento);
    }

}
