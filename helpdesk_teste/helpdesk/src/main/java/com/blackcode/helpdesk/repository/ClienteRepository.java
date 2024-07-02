package com.blackcode.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blackcode.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
