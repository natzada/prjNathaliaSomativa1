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

import com.nathalia.cad.entities.Cliente;
import com.nathalia.cad.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteControllers {
	
	private final ClienteService clienteService;
	
	@Autowired
	public ClienteControllers (ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PostMapping
	public Cliente criarCliente(@RequestBody Cliente cliente) {
		return clienteService.cadastrarCliente(cliente);
	}
	
	@GetMapping
	public List<Cliente> consultarClientes(){
		return clienteService.consultarClientes();
	}
	
	@GetMapping("/{id}")
	public Cliente consultarClienteById(@PathVariable Long id) {
		return clienteService.consultarClienteById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deletarCliente(@PathVariable Long id) {
		clienteService.deletarClienteById(id);
	}
	
	@PutMapping("/{id}")
	public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		return clienteService.atualizarCliente(id, cliente);
	}
}
