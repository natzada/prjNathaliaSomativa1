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

import com.nathalia.cad.entities.Agendamento;
import com.nathalia.cad.services.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

	private final AgendamentoService agendamentoService;
	
	@Autowired
	public AgendamentoController (AgendamentoService agendamentoService) {
		this.agendamentoService = agendamentoService;
	}
	
	@PostMapping
	public Agendamento criarAgendamento(@RequestBody Agendamento agendamento) {
		return agendamentoService.cadastrarAgendamento(agendamento);
	}
	
	@GetMapping
	public List<Agendamento> consultarAgendamentos(){
		return agendamentoService.consultarAgendamentos();
	}
	
	@GetMapping("/{id}")
	public Agendamento consultarAgendamentoById(@PathVariable Long id) {
		return agendamentoService.consultarAgendamentoById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deletarAgendamentoById (@PathVariable Long id) {
		agendamentoService.deletarAgendamentoById(id);
	}
	
	@PutMapping
	public Agendamento atualizarAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamento) {
		return agendamentoService.atualizarAgendamento(id, agendamento);
	}
}
