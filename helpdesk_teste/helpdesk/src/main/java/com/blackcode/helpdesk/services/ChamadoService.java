package com.blackcode.helpdesk.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcode.helpdesk.DTO.ChamadoDTO;
import com.blackcode.helpdesk.domain.Chamado;
import com.blackcode.helpdesk.domain.Cliente;
import com.blackcode.helpdesk.domain.Tecnico;
import com.blackcode.helpdesk.domain.enums.Prioridade;
import com.blackcode.helpdesk.domain.enums.Status;
import com.blackcode.helpdesk.exceptions.ObjectNotFoundExceptionService;
import com.blackcode.helpdesk.repository.ChamadoRepository;

import jakarta.validation.Valid;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private ClienteService clienteService;

    // Método findById()
    public Chamado findById(Integer id) {
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExceptionService(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Chamado.class.getName()));
    }

    public List<Chamado> findAll() {
        return repository.findAll();
    }

    public Chamado create(@Valid ChamadoDTO objDTO) {
        return repository.save(newChamado(objDTO));
    }

    public Chamado update(Integer id, ChamadoDTO objDTO) {
        objDTO.setId(id);
        Chamado oldObj = findById(id);
        oldObj = newChamado(objDTO);
        return repository.save(oldObj);
    }

    private Chamado newChamado(ChamadoDTO obj) {
        Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
        Cliente cliente = clienteService.findById(obj.getCliente());

        Chamado chamado = new Chamado();
        if (obj.getId() != null) {
            chamado.setId(obj.getId());
        }

        if (obj.getStatus().equals(2)) {
            chamado.setDataFechamento(LocalDate.now());
        }

        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
        chamado.setStatus(Status.toEnum(obj.getStatus()));
        chamado.setTitulo(obj.getTitulo());
        chamado.setObservacoes(obj.getObservacoes());
        return chamado;
    }

    // Método para paginação
    // public List<Chamado> findAllPage(Integer page, Integer size) {
    // return repository.findAllPage(page, size);
    // }

}
