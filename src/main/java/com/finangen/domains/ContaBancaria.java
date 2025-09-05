package com.finangen.domains;

import com.finangen.domains.dtos.ContaBancariaDTO;
import com.finangen.domains.enums.TipoConta;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "contaBancaria")
public class ContaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contabancaria")
    private Long idConta;

    @NotNull
    @NotBlank
    private String descricaoConta;

    @NotNull
    @NotBlank
    private String agenciaConta;

    @NotNull
    @NotBlank
    private String numeroConta;

    @NotNull
    @NotBlank
    private String limiteConta;

    @NotNull
    @Digits(integer = 15, fraction = 2)
    private BigDecimal saldoConta;

    // private List<TipoConta> tipoConta = new ArrayList<>();
    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "tipoConta")
    private TipoConta tipoConta;

    public ContaBancaria() {
    }

    public ContaBancaria(Long idConta, String descricaoConta, String agenciaConta, String numeroConta, String limiteConta, BigDecimal saldoConta, TipoConta tipoConta) {
        this.idConta = idConta;
        this.descricaoConta = descricaoConta;
        this.agenciaConta = agenciaConta;
        this.numeroConta = numeroConta;
        this.limiteConta = limiteConta;
        this.saldoConta = saldoConta;
        this.tipoConta = tipoConta;
    }

    public ContaBancaria(ContaBancariaDTO dto) {
        this.idConta = dto.getIdConta();
        this.descricaoConta = dto.getDescricaoConta();
        this.agenciaConta = dto.getAgenciaConta();
        this.numeroConta = dto.getNumeroConta();
        this.limiteConta = dto.getLimiteConta();
        this.saldoConta = dto.getSaldoConta();
        this.tipoConta = TipoConta.toEnum(dto.getTipoConta());
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public @NotNull @NotBlank String getDescricaoConta() {
        return descricaoConta;
    }

    public void setDescricaoConta(@NotNull @NotBlank String descricaoConta) {
        this.descricaoConta = descricaoConta;
    }

    public @NotNull @NotBlank String getAgenciaConta() {
        return agenciaConta;
    }

    public void setAgenciaConta(@NotNull @NotBlank String agenciaConta) {
        this.agenciaConta = agenciaConta;
    }

    public @NotNull @NotBlank String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(@NotNull @NotBlank String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public @NotNull @NotBlank String getLimiteConta() {
        return limiteConta;
    }

    public void setLimiteConta(@NotNull @NotBlank String limiteConta) {
        this.limiteConta = limiteConta;
    }

    public @NotNull @Digits(integer = 15, fraction = 2) BigDecimal getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(@NotNull @Digits(integer = 15, fraction = 2) BigDecimal saldoConta) {
        this.saldoConta = saldoConta;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaBancaria that = (ContaBancaria) o;
        return Objects.equals(idConta, that.idConta) && Objects.equals(numeroConta, that.numeroConta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConta, numeroConta);
    }
}
