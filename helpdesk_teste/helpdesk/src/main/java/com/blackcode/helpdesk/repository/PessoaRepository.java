package com.blackcode.helpdesk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blackcode.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    // Método para buscar uma pessoa por CPF
    Optional<Pessoa> findByCpf(String cpf);

    // Método para buscar uma pessoa por email
    Optional<Pessoa> findByEmail(String email);

}
