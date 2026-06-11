package com.serviflex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviflex.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}