package com.finangen.services;
import com.finangen.domains.ContaBancaria;
import com.finangen.domains.dtos.ContaBancariaDTO;
import com.finangen.repositories.ContaBancariaRepository;

import com.finangen.services.exceptions.DataIntegrityViolationException;
import com.finangen.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepo;

    public List<ContaBancariaDTO> findAll(){
        return contaBancariaRepo.findAll().stream()
                .map(obj -> new ContaBancariaDTO(obj))
                .collect(Collectors.toList());
    }

    public ContaBancaria findById(Long id){
        Optional<ContaBancaria> obj =  contaBancariaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado, ID:" + id));
    }

    public ContaBancaria create(ContaBancariaDTO objDto){
        objDto.setIdConta(null);
        ContaBancaria newObj = new ContaBancaria(objDto);
        return contaBancariaRepo.save(newObj);
    }

    public ContaBancaria update(Long id, ContaBancariaDTO objDto){
        objDto.setIdConta(id);
        ContaBancaria oldObj = findById(id);
        oldObj = new ContaBancaria(objDto);
        return contaBancariaRepo.save(oldObj);
    }


    /*public void delete(Long id) {
        ContaBancaria obj = findById(id);
        if (obj.getContaBancarias().size()>0) {
            throw new DataIntegrityViolationException("Conta Bancaria não pode ser deletada pois possui cadastrados ativos");
        }
        contaBancariaRepo.deleteById(id);
    }
*/

}
