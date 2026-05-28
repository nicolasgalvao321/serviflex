package com.serviflex.ai;

import org.springframework.stereotype.Service;

import com.serviflex.model.Cliente;

@Service
public class MensagemIAService {
    public String gerarMensagem(Cliente cliente, String tipo) {
        // Proteção caso o nome venha nulo para não quebrar a aplicação
        if (cliente.getNome() == null) {
            return "Olá! Temos uma oportunidade especial para você hoje no Serviflex.";
        }

        String nome = cliente.getNome().split(" ")[0]; // Pega o primeiro nome
        
        if ("inativo".equals(tipo)) {
            return "Olá " + nome + "! Sentimos sua falta. Já faz " + cliente.getDiasDesdeUltimaVisita() + " dias que não nos visita. Que tal um desconto de 20% para voltar?";
        }
        
        return "Olá " + nome + "! Temos uma promoção especial para você que é nível " + cliente.getNivelFidelidade() + ". Aproveite hoje mesmo!";
    }
}