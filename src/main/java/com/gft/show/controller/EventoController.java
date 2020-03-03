package com.gft.show.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.show.model.CasaShow;
import com.gft.show.model.Evento;
import com.gft.show.model.StatusEvento;
import com.gft.show.repository.CasaShowRepository;
import com.gft.show.repository.EventoRepository;


@Controller
public class EventoController {
	
	@Autowired
	private EventoRepository events;
	
	@Autowired
	private CasaShowRepository cshow;
	
	
	@RequestMapping(value="/eventos")
	public ModelAndView casas() {
		ModelAndView mv = new ModelAndView("CadastroEvento");
		mv.addObject(new Evento());
		List<Evento> todosEventos = events.findAll();
		mv.addObject("events", todosEventos);
		mv.addObject(new CasaShow());
		List<CasaShow> todasCasas = cshow.findAll();
		mv.addObject("cshow", todasCasas);
		
		
		return mv;
	}
	
	
	
	@RequestMapping(value="/eventos", method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Evento evento, Errors errors) {
		ModelAndView mv = new ModelAndView("CadastroEvento");
		
		if(errors.hasErrors()) {
			List<Evento> todosEventos = events.findAll();
			mv.addObject("events", todosEventos);
			List<CasaShow> todasCasas = cshow.findAll();
			mv.addObject("cshow", todasCasas);
			return mv;
		}
		evento.setQtdingresso(evento.getCapacidade());
		
		events.save(evento);
		
		mv.addObject("mensagem", "Evento Cadastrada com sucesso");
		mv.addObject(new Evento());
		List<Evento> todosEventos = events.findAll();
		mv.addObject("events", todosEventos);
		mv.addObject(new CasaShow());
		List<CasaShow> todasCasas = cshow.findAll();
		mv.addObject("cshow", todasCasas);
		
		
		
	

		//Salvar no banco de dados
		
		return mv;
	}
	
	@RequestMapping(value="/eventos/{codigo}", method = RequestMethod.POST)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		
	
		events.deleteById(codigo);

		
		
		return "redirect:/eventos";
	}
	
	
	@RequestMapping(value="/eventos/{codigo}")
	public ModelAndView edicao(@PathVariable ("codigo") Evento evento) {
		
		ModelAndView mv = new ModelAndView("CadastroEvento");
		
		mv.addObject(evento);
		List<CasaShow> todasCasas = cshow.findAll();
		mv.addObject("cshow", todasCasas);
		
		return mv;
	}
	
	
	@ModelAttribute("todosStatusEvento")
	public List<StatusEvento> todosStatusTitulo(){
		return Arrays.asList(StatusEvento.values());
	}

	


	

}

