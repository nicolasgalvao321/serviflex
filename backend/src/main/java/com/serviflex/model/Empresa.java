package com.serviflex.model;

import jakarta.persistence.*;

@Entity
@Table(name = "empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nomeEmpresa;
    private String cnpj;
    private String plano;

    // Getters e Setters manuais para evitar falhas do Lombok no compilador
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomeEmpresa() { return nomeEmpresa; }
    public void setNomeEmpresa(String nomeEmpresa) { this.nomeEmpresa = nomeEmpresa; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getPlano() { return plano; }
    public void setPlano(String plano) { this.plano = plano; }
}