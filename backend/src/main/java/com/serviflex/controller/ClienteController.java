package com.serviflex.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; // Substitua pelo nome correto do seu Repository se for diferente
import org.springframework.http.ResponseEntity;
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
@CrossOrigin(origins = "*") // Permite que o seu HTML/JavaScript local converse com o Java
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MensagemIAService mensagemIAService;

    // Endpoint obrigatório para a IA funcionar que conecta o app.js ao MensagemIAService
    @GetMapping("/{id}/mensagem-ia")
    public ResponseEntity<String> obterMensagemIA(@PathVariable Long id, @RequestParam String tipo) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        
        if (clienteOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        // Chama o serviço cognitivo que você criou
        String mensagemGerada = mensagemIAService.gerarMensagem(clienteOpt.get(), tipo);
        
        // Retorna o texto puro para o JavaScript capturar
        return ResponseEntity.ok(mensagemGerada);
    }

    // --- Outros métodos padrão do seu CRUD (exemplos para garantir que não quebrem) ---
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        // Define o nível de fidelidade automaticamente baseado nos pontos se necessário
        if (cliente.getPoints() >= 100) cliente.setNivelFidelidade("GOLD");
        else if (cliente.getPoints() >= 50) cliente.setNivelFidelidade("SILVER");
        else cliente.setNivelFidelidade("BRONZE");
        
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
