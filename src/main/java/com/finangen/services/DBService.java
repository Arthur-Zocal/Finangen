package com.finangen.services;

import com.finangen.domains.*;
import com.finangen.domains.enums.*;
import com.finangen.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private BancoRepository bancoRepo;

    @Autowired
    private ContaBancariaRepository contaBancariaRepo;

    @Autowired
    private LancamentoRepository lancamentoRepo;

    @Autowired
    private PessoaRepository pessoaRepo;

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private PasswordEncoder encoder;

    public void initDB(){

        //  Banco
        Banco banco1 = new Banco(null,"Banco do Brasil", Status.ATIVO);
        Banco banco2 = new Banco(null,"Itau", Status.INATIVO);

        bancoRepo.save(banco1);
        bancoRepo.save(banco2);

        //  Conta Bancaria
        ContaBancaria contaBancaria1 = new ContaBancaria(null,"Conta Corrente","0678","53374-1","12",new BigDecimal("32000.00"), TipoConta.CONTACORRENTE);
        ContaBancaria contaBancaria2 = new ContaBancaria(null,"Conta Investimento","A","0678","53374-2",new BigDecimal("32000.00"), TipoConta.CONTAINVESTIMENTO);
        ContaBancaria contaBancaria3 = new ContaBancaria(null,"Cartão de Credito","A","0678","53374-3",new BigDecimal("32000.00"), TipoConta.CARTAOCREDITO);
        ContaBancaria contaBancaria4 = new ContaBancaria(null,"Conta Alimentação","A","0678","53374-4",new BigDecimal("32000.00"), TipoConta.ALIMENTACAO);
        ContaBancaria contaBancaria5 = new ContaBancaria(null,"Conta Poupança","A","0678","53374-5",new BigDecimal("32000.00"), TipoConta.CONTAPOUPANCA);

        contaBancariaRepo.save(contaBancaria1);
        contaBancariaRepo.save(contaBancaria2);
        contaBancariaRepo.save(contaBancaria3);
        contaBancariaRepo.save(contaBancaria4);
        contaBancariaRepo.save(contaBancaria5);

        //  Lancamento
        Lancamento lancamento1 = new Lancamento(null,"Compra de roupas",LocalDate.now(),LocalDate.now(),LocalDate.now(),new BigDecimal("320.00"), TipoLancamento.CREDITO, Situacao.ABERTO);
        Lancamento lancamento2 = new Lancamento(null,"Conta de agua",LocalDate.now(),LocalDate.now(),LocalDate.now(),new BigDecimal("320.00"), TipoLancamento.DEBITO, Situacao.BAIXADO);
        Lancamento lancamento3 = new Lancamento(null,"Compras do mes",LocalDate.now(),LocalDate.now(),LocalDate.now(),new BigDecimal("320.00"), TipoLancamento.CREDITO, Situacao.ATRASADO);

        lancamentoRepo.save(lancamento1);
        lancamentoRepo.save(lancamento2);
        lancamentoRepo.save(lancamento3);


        //  Admin
        Admin admin1 = new Admin(null,"Pedro Costa","00.000.000-1","000.000.000-1","(00)00000 0001","pedrocosta@gmail.com",encoder.encode("001"));
        Admin admin2 = new Admin(null,"Gabriel Barriga","00.000.000-2","000.000.000-2","(00)00000 0002","pedrobarriga@gmail.com",encoder.encode("002"));

        adminRepo.save(admin1);
        adminRepo.save(admin2);

        //  Usuario
        Usuario usuario1 = new Usuario(null,"João Mamão","00.000.000-3","000.000.000-3","(00)00000 0003","joaomamao@gmail.com",encoder.encode("003"));
        Usuario usuario2 = new Usuario(null,"Italo Parachoque","00.000.000-4","000.000.000-4","(00)00000 0004","italoparachoque@gmail.com",encoder.encode("004"));

        usuarioRepo.save(usuario1);
        usuarioRepo.save(usuario2);
    }

}
