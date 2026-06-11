package com.serviflex.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serviflex.ai.MensagemIAService;
import com.serviflex.model.Cliente;
import com.serviflex.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteRepository repository;
    private final MensagemIAService mensagemIAService;

    public ClienteController(
            ClienteRepository repository,
            MensagemIAService mensagemIAService) {

        this.repository = repository;
        this.mensagemIAService = mensagemIAService;
    }

    @GetMapping
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/{id}/mensagem-ia")
    public String gerarMensagem(
            @PathVariable Long id,
            @RequestParam String tipo) {

        Cliente cliente = repository.findById(id)
                .orElse(null);

        return mensagemIAService.gerarMensagem(cliente, tipo);
    }
}
