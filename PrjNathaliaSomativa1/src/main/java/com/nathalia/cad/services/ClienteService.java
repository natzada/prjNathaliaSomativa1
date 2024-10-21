package com.nathalia.cad.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nathalia.cad.entities.Cliente;
import com.nathalia.cad.repositories.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	@Autowired 
	public ClienteService (ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente cadastrarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente consultarClienteById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	public List<Cliente> consultarClientes(){
		return clienteRepository.findAll();
	}
	
	public void deletarClienteById(Long id) {
		clienteRepository.deleteById(id);
	}
	
	public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
		Optional<Cliente> clienteOpcional = clienteRepository.findById(id);
		if(clienteOpcional.isPresent()) {
			Cliente clienteExistente = clienteOpcional.get();
			clienteExistente.setName(clienteAtualizado.getName());
			clienteExistente.setPetName(clienteAtualizado.getPetName());
			clienteExistente.setAddress(clienteAtualizado.getAddress());
			clienteExistente.setPhone(clienteAtualizado.getPhone());
			return 	clienteRepository.save(clienteExistente);
		} else {
			return null;
		}
	}
}
