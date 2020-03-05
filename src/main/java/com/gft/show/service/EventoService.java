package com.gft.show.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.show.model.CasaShow;
import com.gft.show.model.Evento;
import com.gft.show.repository.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository eventoRe;
	
	public List<Evento> listar(){
		return eventoRe.findAll();
	}
	
	public List<Evento> listarAsc(){
		System.out.println("Listei em ordem Asc");
		return eventoRe.findAll(Sort.by(Sort.Direction.ASC, "nomeEvento"));
	}
	
	public List<Evento> listarDesc(){
		System.out.println("Listei em ordem Asc");
		return eventoRe.findAll(Sort.by(Sort.Direction.DESC, "nomeEvento"));
	}
	
	public List<Evento> listarCapAsc(){
		System.out.println("Listei em ordem Asc");
		return eventoRe.findAll(Sort.by(Sort.Direction.ASC, "capacidade"));
	}
	
	public List<Evento> listarCapDesc(){
		System.out.println("Listei em ordem Asc");
		return eventoRe.findAll(Sort.by(Sort.Direction.DESC, "capacidade"));
	}
	
	public List<Evento> listarDataAsc(){
		System.out.println("Listei em ordem Asc");
		return eventoRe.findAll(Sort.by(Sort.Direction.ASC, "dataEvento"));
	}
	
	public List<Evento> listarDataDesc(){
		System.out.println("Listei em ordem Asc");
		return eventoRe.findAll(Sort.by(Sort.Direction.DESC, "dataEvento"));
	}
	
	public List<Evento> listarValAsc(){
		System.out.println("Listei em ordem Asc");
		return eventoRe.findAll(Sort.by(Sort.Direction.ASC, "valor"));
	}
	
	public List<Evento> listarValDesc(){
		System.out.println("Listei em ordem Asc");
		return eventoRe.findAll(Sort.by(Sort.Direction.DESC, "valor"));
	}
	
	public Evento salvar(Evento casas) {
		casas.setCodigo(null);
		return eventoRe.save(casas);
	}
	
	public Evento buscar(Long codigo, RedirectAttributes attributes) {
		Evento casas = eventoRe.findById(codigo).get();
		
		if(casas == null) {
			attributes.addFlashAttribute("mensagem", "Evento nao encontrado");
		}
		return casas;
	}
	
	public void deletar(Long codigo) {
		eventoRe.deleteById(codigo);
	}
	
	public void atualizar(Evento casas) {
		buscar(casas.getCodigo(), null);
		eventoRe.save(casas);
		
	}
}










