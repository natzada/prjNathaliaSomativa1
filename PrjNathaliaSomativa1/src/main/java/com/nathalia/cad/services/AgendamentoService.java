package com.nathalia.cad.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nathalia.cad.entities.Agendamento;
import com.nathalia.cad.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {

	private final AgendamentoRepository agendamentoRepository;
	
	@Autowired
	public AgendamentoService(AgendamentoRepository agendamentoRepository) {
		this.agendamentoRepository = agendamentoRepository;
	}
	
	public Agendamento cadastrarAgendamento(Agendamento agendamento) {
		return agendamentoRepository.save(agendamento);
	}
	
	public Agendamento consultarAgendamentoById(Long id) {
		return agendamentoRepository.findById(id).orElse(null);
	}
	
	public List<Agendamento> consultarAgendamentos(){
		return agendamentoRepository.findAll();
	}
	
	public void deletarAgendamentoById(Long id) {
		agendamentoRepository.deleteById(id);
	}
	
	public Agendamento atualizarAgendamento(Long id, Agendamento agendamentoAtualizado) {
		Optional<Agendamento> agendamentoOpcional = agendamentoRepository.findById(id);
		if(agendamentoOpcional.isPresent()) {
			Agendamento agendamentoExistente = agendamentoOpcional.get();
			agendamentoExistente.setDate(agendamentoAtualizado.getDate());
			agendamentoExistente.setHour(agendamentoAtualizado.getHour());
			agendamentoExistente.setQuantity(agendamentoAtualizado.getQuantity());
			return 	agendamentoRepository.save(agendamentoExistente);
		} else {
			return null;
		}
	}
}
