package com.serviflex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviflex.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}