package com.serviflex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviflex.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}