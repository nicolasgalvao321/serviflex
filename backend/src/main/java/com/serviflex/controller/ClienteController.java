package com.serviflex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviflex.model.Cliente;
import com.serviflex.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
    
    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        if (cliente.getPontos() == null) {
            cliente.setPontos(0);
        }
        
        // Sistema automático de regras de negócio para o TCC
        if (cliente.getPontos() >= 100) {
            cliente.setNivelFidelidade("GOLD");
        } else if (cliente.getPontos() >= 50) {
            cliente.setNivelFidelidade("SILVER");
        } else {
            cliente.setNivelFidelidade("BRONZE");
        }
        
        return repository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}