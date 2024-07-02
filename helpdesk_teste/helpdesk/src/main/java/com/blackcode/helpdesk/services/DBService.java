package com.blackcode.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcode.helpdesk.domain.Chamado;
import com.blackcode.helpdesk.domain.Cliente;
import com.blackcode.helpdesk.domain.Tecnico;
import com.blackcode.helpdesk.domain.enums.Perfil;
import com.blackcode.helpdesk.domain.enums.Prioridade;
import com.blackcode.helpdesk.domain.enums.Status;
import com.blackcode.helpdesk.repository.ChamadoRepository;
import com.blackcode.helpdesk.repository.ClienteRepository;
import com.blackcode.helpdesk.repository.TecnicoRepository;

@Service // helpdeskDB
public class DBService {

	// Injeção de dependência
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	// @Autowired
	// private BCryptPasswordEncoder encoder;

	public void instanciaDB() {

		// Tecnico [ id, nome, cpf, email, senha ]
		Tecnico t1 = new Tecnico(null, "Lucas Morais", "12345678900", "Lucas@Lucas.com", "123"); // encoder.encode("123")
		t1.addPerfil(Perfil.ADMIN);
		tecnicoRepository.saveAll(Arrays.asList(t1));

		Cliente c1 = new Cliente(null, "Carlos Morais", "12345678220", "Carlos@Carlos.com", "123"); // encoder.encode("123")
		clienteRepository.saveAll(Arrays.asList(c1));

		Chamado ch1 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", t1, c1);
		chamadoRepository.saveAll(Arrays.asList(ch1));

	}

}
