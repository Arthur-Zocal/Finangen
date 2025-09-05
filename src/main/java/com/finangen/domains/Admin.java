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

    @ManyToOne
    @JoinColumn(name="admin")
    private Admin admin;

    public Admin(Long id, String nome, String rg, String cpf, String numCelular, String email, String senha) {
        super(id, nome, rg, cpf, numCelular, email, senha);
        addTipoPessoa(TipoPessoa.ADMIN);
    }

    public Admin(AdminDTO obj){

        this.id = obj.getId();
        this.nome = obj.getNome();
        this.rg = obj.getRg();
        this.cpf = obj.getCpf();
        this.numCelular = obj.getNumCelular();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.tipoPessoa = obj.getTipoPessoa().stream()
                .map(x -> x.getId()).collect(Collectors.toSet());
        addTipoPessoa(TipoPessoa.ADMIN);
    }

    public Admin(){
        super();
        addTipoPessoa(TipoPessoa.ADMIN);
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
