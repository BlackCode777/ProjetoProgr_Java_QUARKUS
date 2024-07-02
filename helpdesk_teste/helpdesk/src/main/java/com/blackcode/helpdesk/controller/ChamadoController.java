package com.blackcode.helpdesk.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.blackcode.helpdesk.DTO.ChamadoDTO;
import com.blackcode.helpdesk.domain.Chamado;
import com.blackcode.helpdesk.services.ChamadoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService service;

    // Método PUT
    @PutMapping("/{id}")
    public ResponseEntity<ChamadoDTO> putdate(@PathVariable Integer id, @RequestBody ChamadoDTO objDTO) {
        Chamado newObj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new ChamadoDTO(newObj));
    }

    // Método post
    @PostMapping
    public ResponseEntity<ChamadoDTO> create(@Valid @RequestBody ChamadoDTO objDTO) {
        Chamado obj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    // Método findAll()
    @GetMapping
    public ResponseEntity<List<ChamadoDTO>> findAll() {
        List<Chamado> list = service.findAll();
        List<ChamadoDTO> listDTO = list.stream().map(obj -> new ChamadoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    // Método findById()
    @GetMapping(value = "/{id}")
    public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id) {
        Chamado obj = service.findById(id);
        return ResponseEntity.ok().body(new ChamadoDTO(obj));
    }

    // // Método para paginação
    // @GetMapping(value = "/page")
    // public ResponseEntity<Page<ChamadoDTO>> findPage(
    // @RequestParam(value = "page", defaultValue = "0") Integer page,
    // @RequestParam(value = "linesPerPage", defaultValue = "6") Integer
    // linesPerPage,
    // @RequestParam(value = "orderBy", defaultValue = "dataAbertura") String
    // orderBy,
    // @RequestParam(value = "direction", defaultValue = "DESC") String direction) {
    // Page<Chamado> list = service.findPage(page, linesPerPage, orderBy,
    // direction);
    // Page<ChamadoDTO> listDTO = list.map(obj -> new ChamadoDTO(obj));
    // return ResponseEntity.ok().body(listDTO);
    // }

}
