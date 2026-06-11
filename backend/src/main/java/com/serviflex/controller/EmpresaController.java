package com.serviflex.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviflex.model.Empresa;
import com.serviflex.repository.EmpresaRepository;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "*")
public class EmpresaController {

    private final EmpresaRepository repository;

    // Injeção via construtor recomendada pelo Spring e VS Code
    public EmpresaController(EmpresaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Empresa> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Empresa salvar(@RequestBody Empresa empresa) {
        return repository.save(empresa);
    }
}