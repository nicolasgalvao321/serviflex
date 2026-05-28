package com.serviflex.controller;

import com.serviflex.model.Agendamento;
import com.serviflex.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
@CrossOrigin(origins = "*")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository repository;

    @GetMapping
    public List<Agendamento> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Agendamento salvar(@RequestBody Agendamento agendamento) {
        return repository.save(agendamento);
    }
}