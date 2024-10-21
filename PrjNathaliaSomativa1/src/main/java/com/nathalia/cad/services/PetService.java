package com.nathalia.cad.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nathalia.cad.entities.Pet;
import com.nathalia.cad.repositories.PetRepository;

@Service
public class PetService {
	
	private final PetRepository petRepository;
	
	@Autowired
	public PetService (PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	
	public Pet cadastrarPet(Pet pet) {
		return petRepository.save(pet);
	}
	
	public Pet consultarPetById(Long id) {
		return petRepository.findById(id).orElse(null);
	}
	
	public List<Pet> consultarPets(){
		return petRepository.findAll();
	}
	
	public void deletarPetById(Long id) {
		petRepository.deleteById(id);
	}
	
	public Pet atualizarPet(Long id, Pet petAtualizado) {
		Optional<Pet> petOpcional = petRepository.findById(id);
		if(petOpcional.isPresent()) {
			Pet petExistente = petOpcional.get();
			petExistente.setName(petAtualizado.getName());
			petExistente.setAge(petAtualizado.getAge());
			petExistente.setRaca(petAtualizado.getRaca());
			petExistente.setCustomer(petAtualizado.getCustomer());
			return 	petRepository.save(petExistente);
		} else {
			return null;
		}
	}
}
