package com.serviflex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String telefone;
    private String email;
    private Integer points = 0; // Se no teu banco antigo for 'pontos', mude para pontos
    private Integer pontos = 0; 
    private String nivelFidelidade = "BRONZE";
    private Integer diasDesdeUltimaVisita = 0;

    // Campos exatos para o agendamento estilo Booksy
    private String dataAgendamento;
    private String horaAgendamento;
    private String servicoAgendamento;

    // ================= GETTERS E SETTERS MANUAIS =================
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getPontos() { return pontos; }
    public void setPontos(Integer pontos) { this.pontos = pontos; }

    public Integer getPoints() { return points; }
    public void setPoints(Integer points) { this.points = points; }

    public String getNivelFidelidade() { return nivelFidelidade; }
    public void setNivelFidelidade(String nivelFidelidade) { this.nivelFidelidade = nivelFidelidade; }

    public Integer getDiasDesdeUltimaVisita() { return diasDesdeUltimaVisita; }
    public void setDiasDesdeUltimaVisita(Integer diasDesdeUltimaVisita) { this.diasDesdeUltimaVisita = diasDesdeUltimaVisita; }

    public String getDataAgendamento() { return dataAgendamento; }
    public void setDataAgendamento(String dataAgendamento) { this.dataAgendamento = dataAgendamento; }

    public String getHoraAgendamento() { return horaAgendamento; }
    public void setHoraAgendamento(String horaAgendamento) { this.horaAgendamento = horaAgendamento; }

    public String getServicoAgendamento() { return servicoAgendamento; }
    public void setServicoAgendamento(String servicoAgendamento) { this.servicoAgendamento = servicoAgendamento; }
}