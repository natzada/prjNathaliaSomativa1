package com.nathalia.cad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nathalia.cad.entities.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
