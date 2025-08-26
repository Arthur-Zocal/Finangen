package com.finangen.domains.dtos;

import com.finangen.domains.ContaBancaria;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ContaBancariaDTO {
    private Long idConta;

    @NotNull(message = "O campo descricaoConta não pode ser vazio")
    @NotBlank(message = "O campo descricaoConta não pode ser vazio")
    private String descricaoConta;

    @NotNull(message = "O campo agenciaConta não pode ser vazio")
    @NotBlank(message = "O campo agenciaConta não pode ser vazio")
    private String agenciaConta;

    @NotNull(message = "O campo numeroConta não pode ser vazio")
    @NotBlank(message = "O campo numeroConta não pode ser vazio")
    private String numeroConta;

    @NotNull(message = "O campo limiteConta não pode ser vazio")
    @NotBlank(message = "O campo limiteConta não pode ser vazio")
    private String limiteConta;

    @NotNull(message = "O campo saldoConta não pode ser vazio")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal saldoConta;

    private int tipoConta;

    public ContaBancariaDTO() {}

    // --->>> PRECISA ARRUMAR O ContaBancaria PRIMEIRO  <<<---

    public ContaBancariaDTO(ContaBancaria contaBancaria) {
        this.idConta = idConta;
        this.descricaoConta = descricaoConta;
        this.agenciaConta = agenciaConta;
        this.numeroConta = numeroConta;
        this.limiteConta = limiteConta;
        this.saldoConta = saldoConta;
        this.tipoConta = tipoConta;
    }
    // --->>> PRECISA ARRUMAR O ContaBancaria PRIMEIRO  <<<---

}
