package com.finangen.domains;

import com.finangen.domains.enums.Status;

public class Banco {

    private Long idBanco;

    private String razaoSocial;

    private Status status;

    public Banco() {}

    public Banco(Long idBanco, String razaoSocial, Status status) {
        this.idBanco = idBanco;
        this.razaoSocial = razaoSocial;
        this.status = status;
    }

    public Long getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Long idBanco) {
        this.idBanco = idBanco;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
