package com.finangen.domains;

import com.finangen.domains.dtos.UsuarioDTO;
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

    @ManyToOne
    @JoinColumn(name="usuario")
    private Usuario usuario;

    public Usuario(Long id, String nome, String rg, String cpf, String numCelular, String email, String senha) {
        super(id, nome, rg, cpf, numCelular, email, senha);
        addTipoPessoa(TipoPessoa.USUARIO);
    }

    public Usuario(UsuarioDTO obj){

        this.id = obj.getId();
        this.nome = obj.getNome();
        this.rg = obj.getRg();
        this.cpf = obj.getCpf();
        this.numCelular = obj.getNumCelular();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.tipoPessoa = obj.getTipoPessoa().stream()
                .map(x -> x.getId()).collect(Collectors.toSet());
        addTipoPessoa(TipoPessoa.USUARIO);

    }

    public Usuario(){
        super();
        addTipoPessoa(TipoPessoa.USUARIO);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
