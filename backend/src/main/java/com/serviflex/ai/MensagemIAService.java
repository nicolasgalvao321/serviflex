package com.serviflex.ai;

import org.springframework.stereotype.Service;

import com.serviflex.model.Cliente; 

@Service
public class MensagemIAService {
    
    public String gerarMensagem(Cliente cliente, String tipo) {
        // Proteção caso o objeto venha nulo
        if (cliente == null) {
            return "Olá! Temos uma oportunidade especial para você hoje no Serviflex.";
        }

        // Proteção caso o nome esteja em branco
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            return "Olá! Temos uma oportunidade especial para você hoje no Serviflex.";
        }

        // Pega apenas o primeiro nome
        String nomeCompleto = cliente.getNome().trim();
        String nome = nomeCompleto.contains(" ") ? nomeCompleto.split(" ")[0] : nomeCompleto;
        
        // Se for tipo inativo (IA Retenção)
        if ("inativo".equalsIgnoreCase(tipo)) {
            return "Olá " + nome + "! Sentimos sua falta. Já faz " + cliente.getDiasDesdeUltimaVisita() + " dias que não nos visita. Que tal um desconto de 20% para voltar?";
        }
        
        // Se for qualquer outro tipo (IA Fidelidade)
        String nivel = (cliente.getNivelFidelidade() != null) ? cliente.getNivelFidelidade() : "Bronze";
        return "Olá " + nome + "! Temos uma promoção especial para você que é nível " + nivel + ". Aproveite hoje mesmo!";
    }
}
