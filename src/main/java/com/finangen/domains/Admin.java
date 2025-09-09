package com.finangen.domains;

import com.finangen.domains.dtos.AdminDTO;
import com.finangen.domains.enums.Status;
import com.finangen.domains.enums.TipoPessoa;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends Pessoa{

    public Admin(Long id, String nome, String rg, String cpf, String numCelular, String email, String senha, Status status) {
        super(id, nome, rg, cpf, numCelular, email, senha, status);
        addTipoPessoa(TipoPessoa.ADMIN);
    }

    public Admin(AdminDTO dto){

        this.id = dto.getId();
        this.nome = dto.getNome();
        this.rg = dto.getRg();
        this.cpf = dto.getCpf();
        this.numCelular = dto.getNumCelular();
        this.email = dto.getEmail();
        this.senha = dto.getSenha();
        this.status = Status.toEnum(dto.getStatus());
        this.tipoPessoa = dto.getTipoPessoa().stream()
                .map(x -> x.getId()).collect(Collectors.toSet());
        addTipoPessoa(TipoPessoa.ADMIN);
    }

    public Admin(){
        super();
        addTipoPessoa(TipoPessoa.ADMIN);
    }
}
