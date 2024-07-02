package com.blackcode.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blackcode.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{

}
