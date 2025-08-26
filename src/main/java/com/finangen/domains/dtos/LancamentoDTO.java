package com.finangen.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.finangen.domains.Lancamento;
import com.finangen.domains.enums.Situacao;
import com.finangen.domains.enums.TipoLancamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LancamentoDTO {

    private Long idLancamento;

    @NotNull(message = "O campo descricao não pode ser nulo!")
    @NotBlank(message = "O campo descricao não pode ser vazio!")
    private String descricao;

    @NotNull(message = "O campo dataLancamento não pode ser nulo!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataLancamento = LocalDate.now();

    @NotNull(message = "O campo dataVencimento não pode ser nulo!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVencimento = LocalDate.now();

    @NotNull(message = "O campo dataBaixa não pode ser nulo!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataBaixa = LocalDate.now();

    @NotNull(message = "O campo valorLancamento não pode ser nulo!")
    @Digits(integer=15, fraction=2)
    private BigDecimal valorLancamento;

    private int tipoLancamento;
    private int situacao;

    public LancamentoDTO() {}

    public LancamentoDTO(Lancamento lancamento) {
        this.idLancamento = lancamento.getIdLancamento();
        this.descricao = lancamento.getDescricao();
        this.dataLancamento = lancamento.getDataLancamento();
        this.dataVencimento = lancamento.getDataVencimento();
        this.dataBaixa = lancamento.getDataBaixa();
        this.valorLancamento = lancamento.getValorLancamento();
        this.tipoLancamento = lancamento.getTipoLancamento().getId();
        this.situacao = lancamento.getSituacao().getId();
    }

    public Long getIdLancamento() {
        return idLancamento;
    }

    public void setIdLancamento(Long idLancamento) {
        this.idLancamento = idLancamento;
    }

    public @NotNull(message = "O campo descricao não pode ser nulo!") @NotBlank(message = "O campo descricao não pode ser vazio!") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descricao não pode ser nulo!") @NotBlank(message = "O campo descricao não pode ser vazio!") String descricao) {
        this.descricao = descricao;
    }

    public @NotNull(message = "O campo dataLancamento não pode ser nulo!") LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(@NotNull(message = "O campo dataLancamento não pode ser nulo!") LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public @NotNull(message = "O campo dataVencimento não pode ser nulo!") LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(@NotNull(message = "O campo dataVencimento não pode ser nulo!") LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public @NotNull(message = "O campo dataBaixa não pode ser nulo!") LocalDate getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(@NotNull(message = "O campo dataBaixa não pode ser nulo!") LocalDate dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public @NotNull(message = "O campo valorLancamento não pode ser nulo!") @Digits(integer = 15, fraction = 2) BigDecimal getValorLancamento() {
        return valorLancamento;
    }

    public void setValorLancamento(@NotNull(message = "O campo valorLancamento não pode ser nulo!") @Digits(integer = 15, fraction = 2) BigDecimal valorLancamento) {
        this.valorLancamento = valorLancamento;
    }

    public int getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(int tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
}
