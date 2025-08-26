package com.finangen.domains;

import com.finangen.domains.dtos.ContaBancariaDTO;
import com.finangen.domains.enums.TipoConta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ContaBancaria {

    private Long idConta;

    private String descricaoConta;

    private String agenciaConta;

    private String numeroConta;

    private String limiteConta;

    private BigDecimal saldoConta;

    private List<TipoConta> tipoConta = new ArrayList<>();



    public ContaBancaria(){
    }

    public ContaBancaria(Long idConta, String descricaoConta, String agenciaConta, String numeroConta, String limiteConta, BigDecimal saldoConta, TipoConta tipoConta) {
        this.idConta = idConta;
        this.descricaoConta = descricaoConta;
        this.agenciaConta = agenciaConta;
        this.numeroConta = numeroConta;
        this.limiteConta = limiteConta;
        this.saldoConta = saldoConta;
        this.tipoConta = TipoConta.toEnum(dto.getTipoConta());
    }


}
