package com.serviflex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "agendamentos")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String data;
    private String hora;
    private String servico;
    
    // Novos campos essenciais para o estilo "Booksy" (Quem está agendando)
    private String nomeCliente;
    private String telefoneCliente;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }
    public String getServico() { return servico; }
    public void setServico(String servico) { this.servico = servico; }
    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public String getTelefoneCliente() { return telefoneCliente; }
    public void setTelefoneCliente(String telefoneCliente) { this.telefoneCliente = telefoneCliente; }
    public Empresa getEmpresa() { return empresa; }
    public void setEmpresa(Empresa empresa) { this.empresa = empresa; }
}