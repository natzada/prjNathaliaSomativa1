package com.nathalia.cad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nathalia.cad.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
