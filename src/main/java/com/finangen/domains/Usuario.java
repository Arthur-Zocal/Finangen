package com.finangen.domains;

import com.finangen.domains.dtos.UsuarioDTO;
import com.finangen.domains.enums.Status;
import com.finangen.domains.enums.TipoPessoa;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Set;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue("USUARIO")
public class Usuario extends Pessoa{

    public Usuario(Long id, String nome, String rg, String cpf, String numCelular, String email, String senha, Status status) {
        super(id, nome, rg, cpf, numCelular, email, senha, status);
        addTipoPessoa(TipoPessoa.USUARIO);
    }

    public Usuario(UsuarioDTO dto){

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
        addTipoPessoa(TipoPessoa.USUARIO);

    }

    public Usuario(){
        super();
        addTipoPessoa(TipoPessoa.USUARIO);
    }
}
