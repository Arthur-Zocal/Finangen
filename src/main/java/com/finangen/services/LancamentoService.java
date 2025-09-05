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

    @Autowired
    private LancamentoRepository lancamentoRepo;

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

}
