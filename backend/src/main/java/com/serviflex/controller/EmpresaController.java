package com.serviflex.controller;

import com.serviflex.model.Empresa;
import com.serviflex.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "*")
public class EmpresaController {

    @Autowired
    private EmpresaRepository repository;

    @GetMapping
    public List<Empresa> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Empresa salvar(@RequestBody Empresa empresa) {
        return repository.save(empresa);
    }
}