package com.finangen.services;


import com.finangen.domains.Admin;
import com.finangen.domains.dtos.AdminDTO;
import com.finangen.repositories.AdminRepository;

import com.finangen.services.exceptions.DataIntegrityViolationException;
import com.finangen.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdminService {
    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private PasswordEncoder encoder;

    public  List<AdminDTO> findAll(){
        return adminRepo.findAll().stream()
                .map(obj ->new AdminDTO(obj)).collect(Collectors.toList());
    }

    public Admin findById(Long id){
        Optional<Admin> obj = adminRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID:"+ id));
    }

    public Admin findByCpf(String cpf){
        Optional<Admin> obj = adminRepo.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! CPF:"+ cpf));
    }

    public Admin findByEmail(String email){
        Optional<Admin> obj = adminRepo.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! EMAIL:"+ email));
    }

    public Admin create (AdminDTO objDto){
        objDto.setId(null);
        objDto.setSenha(encoder.encode(objDto.getSenha()));
        ValidaPorCPFeEmail(objDto);
        Admin newObj = new Admin(objDto);
        return adminRepo.save(newObj);
    }

    /*
    public PessoaJuridica create (PessoaJuridicaDTO objDto){
        objDto.setId(null);
        objDto.setSenha(encoder.encode(objDto.getSenha()));
        ValidaPorEmail(objDto);
        PessoaJuridica newObj = new PessoaJuridica(objDto);
        return pessoaJuridicaRepo.save(newObj);
    }

    public PessoaJuridica update(Long id, PessoaJuridicaDTO objDto){
        objDto.setId(id);
        PessoaJuridica oldObj = findById(id);
        ValidaPorEmail(objDto);
        oldObj = new PessoaJuridica(objDto);
        return pessoaJuridicaRepo.save(oldObj);
    }

    public void delete(Long id){
        PessoaJuridica obj = findById(id);
        if(obj.getOrdemServico().size()>0){
            throw new DataIntegrityViolationException("Esta pessoa jurídica não pode ser deletada pois possui ordens de serviço pendentes!");
        }
        pessoaJuridicaRepo.deleteById(id);
    }

    private void ValidaPorEmail(PessoaJuridicaDTO objDto){
        Optional<PessoaJuridica> obj = pessoaJuridicaRepo.findByEmail(objDto.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("Email já cadastrado no sistema");
        }

    }*/

    private void ValidaPorCPFeEmail(AdminDTO objDto) {
        Optional<Admin> obj = adminRepo.findByCpf(objDto.getCpf());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
        }

        obj = adminRepo.findByEmail(objDto.getEmail());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("Email já cadastrado no sistema");
        }
    }
}
