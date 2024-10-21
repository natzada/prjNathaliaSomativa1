package com.nathalia.cad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nathalia.cad.entities.Pet;
import com.nathalia.cad.services.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {
	
	private final PetService petService;
	
	@Autowired
	public PetController (PetService petService) {
		this.petService = petService;
	}
	
	@PostMapping
	public Pet criarPet(@RequestBody Pet pet) {
		return petService.cadastrarPet(pet);
	}
	
	@GetMapping
	public List<Pet> consultarPets(){
		return petService.consultarPets();
	}
	
	@GetMapping("/{id}")
	public Pet consultarPetById(@PathVariable Long id) {
		return petService.consultarPetById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deletarPetById(@PathVariable Long id) {
		petService.deletarPetById(id);
	}
	
	@PutMapping("/{id}")
	public Pet atualizarPet(@PathVariable Long id, @RequestBody Pet pet) {
		return petService.atualizarPet(id, pet);
	}

}
