package com.serviflex.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

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

    /* ================= LISTAR TODOS ================= */

    @GetMapping
    public List<Cliente> listar() {
        return repository.findAll();
    }

    /* ================= BUSCAR POR ID ================= */

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {

        Optional<Cliente> cliente = repository.findById(id);

        return cliente.orElse(null);
    }

    /* ================= SALVAR ================= */

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {

        if (cliente.getNivelFidelidade() == null) {
            cliente.setNivelFidelidade("BRONZE");
        }

        return repository.save(cliente);
    }

    /* ================= DELETAR ================= */

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    /* ================= IA ================= */

    @GetMapping("/{id}/mensagem-ia")
    public String gerarMensagemIA(
            @PathVariable Long id,
            @RequestParam(defaultValue = "fidelidade") String tipo) {

        Optional<Cliente> cliente = repository.findById(id);

        if (cliente.isEmpty()) {
            return "Cliente não encontrado.";
        }

        return mensagemIAService.gerarMensagem(cliente.get(), tipo);
    }
}
