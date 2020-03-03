package com.gft.show.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.show.model.Evento;
import com.gft.show.repository.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository casaRe;
	
	public List<Evento> listar(){
		return casaRe.findAll();
	}
	
	public Evento salvar(Evento casas) {
		casas.setCodigo(null);
		return casaRe.save(casas);
		
	}
	
	public Evento buscar(Long codigo, RedirectAttributes attributes) {
		Evento casas = casaRe.findById(codigo).get();
		
		if(casas == null) {
			attributes.addFlashAttribute("mensagem", "Evento nao encontrado");
		}
		return casas;
	}
	
	public void deletar(Long codigo) {
		casaRe.deleteById(codigo);
	}
	
	public void atualizar(Evento casas) {
		buscar(casas.getCodigo(), null);
		casaRe.save(casas);
		
	}
}










