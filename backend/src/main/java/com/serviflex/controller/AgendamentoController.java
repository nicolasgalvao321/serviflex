package com.serviflex.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviflex.model.Agendamento;
import com.serviflex.repository.AgendamentoRepository;

@RestController
@RequestMapping("/api/agendamentos")
@CrossOrigin(origins = "*")
public class AgendamentoController {

    private final AgendamentoRepository repository;

    // O Spring Boot injeta automaticamente pelo construtor (é isso que o VS Code queria!)
    public AgendamentoController(AgendamentoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Agendamento> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Agendamento salvar(@RequestBody Agendamento agendamento) {
        return repository.save(agendamento);
    }
}