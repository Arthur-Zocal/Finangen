package com.finangen.services;

import com.finangen.domains.Banco;
import com.finangen.domains.dtos.BancoDTO;
import com.finangen.repositories.BancoRepository;

import com.finangen.services.exceptions.DataIntegrityViolationException;
import com.finangen.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BancoService {

    private BancoRepository bancoRepo;

    public List<BancoDTO> findAll(){
        return bancoRepo.findAll().stream()
                .map(obj -> new BancoDTO(obj))
                .collect(Collectors.toList());
    }

    public Banco findById(Long id){
        Optional<Banco> obj = bancoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado, ID:"+id));
    }

    public Banco findByRazaoSocial(String razaoSocial) {
        Optional<Banco> obj = bancoRepo.findByRazaoSocial(razaoSocial);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado, Razão Social:" + razaoSocial));
    }

    public Banco create(BancoDTO objDto){
        objDto.setIdBanco(null);
        ValidaBanco(objDto);
        Banco newObj = new Banco(objDto);
        return bancoRepo.save(newObj);
    }

    public Banco update(Long id, BancoDTO objDto){
        objDto.setIdBanco(id);
        Banco oldObj = findById(id);
        ValidaBanco(objDto);
        oldObj = new Banco(objDto);
        return bancoRepo.save(oldObj);
    }

    public void delete(Long id) {
        Banco obj = findById(id);
        if (obj.getContaBancarias().size() > 0) {
            throw new DataIntegrityViolationException("Banco não pode ser deletado pois possui cadastrados ativos");
        }
        bancoRepo.deleteById(id);
    }


    public void ValidaBanco(BancoDTO dto){
        Optional<Banco> obj = bancoRepo.findByRazaoSocial((dto.getRazaoSocial()));
        if (obj.isPresent() && obj.get().getIdBanco() != dto.getIdBanco()){
            throw  new DataIntegrityViolationException("Razão Socical já cadastrada");
        }
    }

}
