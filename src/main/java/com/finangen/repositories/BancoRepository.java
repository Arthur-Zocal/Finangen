package com.finangen.repositories;

import com.finangen.domains.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BancoRepository extends JpaRepository<Banco,Long> {
    Optional<Banco> findById(Long idBanco);
    Optional<Banco> findRazaoSocial(String razaoSocial);
}