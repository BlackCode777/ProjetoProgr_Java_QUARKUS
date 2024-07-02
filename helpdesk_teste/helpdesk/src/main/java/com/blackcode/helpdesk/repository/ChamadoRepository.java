package com.blackcode.helpdesk.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.blackcode.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

    // Método para paginação
//    Page<Chamado> findByTecnicoAberturaAndStatusAndPrioridade(
//            Integer tecnico,
//            Integer status,
//            Integer prioridade,
//            Pageable pageable);

}
