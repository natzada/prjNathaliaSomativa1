package com.nathalia.cad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nathalia.cad.entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

}
