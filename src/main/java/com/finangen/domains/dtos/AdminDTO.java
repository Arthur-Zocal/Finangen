package com.finangen.domains.dtos;

import com.finangen.domains.Admin;
import com.finangen.domains.enums.TipoPessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AdminDTO {

    protected Long id;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode ser vazio")
    protected String nome;

    @NotNull(message = "O campo rg não pode ser nulo")
    @NotBlank(message = "O campo rg não pode ser vazio")
    protected String rg;

    @NotNull(message="O campo CPF não pode ser nulo!")
    @CPF
    protected String cpf;

    @NotNull(message = "O campo numCelular não pode ser vazio")
    @NotBlank(message = "O campo numCelular não pode ser vazio")
    protected String numCelular;

    @NotNull(message = "O campo email não pode ser vazio")
    @NotBlank(message = "O campo email não pode ser vazio")
    protected String email;

    @NotNull(message = "O campo senha não pode ser vazio")
    @NotBlank(message = "O campo senha não pode ser vazio")
    protected String senha;

    protected Set<Integer> tipoPessoa = new HashSet<>();

    public AdminDTO() { }

    public AdminDTO(Admin obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.rg = obj.getRg();
        this.cpf = obj.getCpf();
        this.numCelular = obj.getNumCelular();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.tipoPessoa = obj.getTipoPessoa().stream().map(TipoPessoa::getId).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<TipoPessoa> getTipoPessoa(){
        return tipoPessoa == null ? Collections.emptySet() :
                tipoPessoa.stream().map(TipoPessoa::toEnum).collect(Collectors.toSet());
    }

    public void addTipoPessoa(TipoPessoa tipoPessoa){ this.tipoPessoa.add(tipoPessoa.getId()); }
}
