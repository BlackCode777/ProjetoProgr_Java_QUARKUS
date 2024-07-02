package com.blackcode.helpdesk.services;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.blackcode.helpdesk.DTO.ClienteDTO;
import com.blackcode.helpdesk.domain.Cliente;
import com.blackcode.helpdesk.domain.Pessoa;
import com.blackcode.helpdesk.exceptions.ObjectNotFoundExceptionService;
import com.blackcode.helpdesk.repository.ClienteRepository;
import com.blackcode.helpdesk.repository.PessoaRepository;

import jakarta.validation.Valid;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    // @Autowired
    // private BCryptPasswordEncoder encoder;

    // Retorna uma lista de técnicos
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    // Retorna um técnico por id
    public Cliente findById(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundExceptionService(
                        "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    // Cria um novo técnico no banco de dados
    public Cliente create(ClienteDTO objDTO) {
        objDTO.setId(null);
        // Encriptar a senha
        objDTO.setSenha(objDTO.getSenha()); // encoder.encode(objDTO.getSenha())
        // Método para validar o email e cpf do técnico antes de salvar no banco
        validacaoPorCpfEmail(objDTO);
        Cliente newObj = new Cliente(objDTO);
        return repository.save(newObj);
    }

    // Atualiza um técnico no banco de dados
    public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
        objDTO.setId(id);
        Cliente oldObj = findById(id);
        validacaoPorCpfEmail(objDTO);
        oldObj = new Cliente(objDTO);
        return repository.save(oldObj);
    }

    // Método para deletar um técnico por id
    public void delete(Integer id) {
        Cliente obj = findById(id);
        if (obj.getChamados().size() > 0) {
            throw new DataIntegrityViolationException("Cliente possui ordens de serviço, não pode ser deletado!");
        }
        repository.deleteById(id);
    }

    private void validacaoPorCpfEmail(ClienteDTO objDTO) {
        String cpf = objDTO.getCpf().replaceAll("\\D", ""); // Remove pontos e traços

        // Verifica se o CPF tem 11 caracteres
        if (cpf.length() != 11) {
            throw new DataIntegrityViolationException("CPF deve conter 11 dígitos.");
        }

        // Verifica se o CPF contém apenas números
        if (!Pattern.matches("\\d{11}", cpf)) {
            throw new DataIntegrityViolationException("CPF deve conter apenas números.");
        }

        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
        if (obj.isPresent() && !obj.get().getId().equals(objDTO.getId())) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema! Id: " + obj.get().getId());
        }

        obj = pessoaRepository.findByEmail(objDTO.getEmail());
        if (obj.isPresent() && !obj.get().getId().equals(objDTO.getId())) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema! Id: " + obj.get().getId());
        }
    }

}
