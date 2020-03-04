package com.gft.show.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.show.model.CasaShow;
import com.gft.show.model.Evento;
import com.gft.show.model.Historico;
import com.gft.show.repository.CasaShowRepository;
import com.gft.show.repository.EventoRepository;
import com.gft.show.repository.HistoricoRepository;

@Controller
public class HomeController {
	@Autowired
	private EventoRepository events;
	
	
	@Autowired
	private CasaShowRepository cshow;
	
	@Autowired
	private HistoricoRepository histRe;

	 
	@RequestMapping(value="/")
	public ModelAndView casas(Authentication authenti) {
		ModelAndView mv = new ModelAndView("Home");
		List<Evento> todosEventos = events.findAll();
		mv.addObject("events", todosEventos);
		List<CasaShow> todasCasas = cshow.findAll();
		mv.addObject("cshow", todasCasas);
		
		return mv;
	}
	
	@RequestMapping(value="/comprar/{codigo}", method = RequestMethod.POST)
	public ModelAndView comprar(@PathVariable Long codigo, RedirectAttributes attributess, int desc) {
			System.out.println(codigo);	
			ModelAndView mv = new ModelAndView("redirect:/");
		
			
			Evento Eventos = events.findById(codigo).get();
			
			if (Eventos.getQtdingresso() > 0 && Eventos.getQtdingresso()-desc >= 0) {
			

					Eventos.setQtdingresso(Eventos.getQtdingresso() - desc);
			mv.addObject(Eventos.getQtdingresso());
			events.save(Eventos);
			System.out.println("Vou descontar");
			Historico hist = new Historico(Eventos.getCodigo(),Eventos.getNomeEvento(), desc, Eventos.getValor());
			histRe.save(hist);
			
			}
			else {
				attributess.addFlashAttribute("mensagem", "A quantidade que voce solicitou nao esta disponivel");
			}
			mv.addObject("events", Eventos);
			events.save(Eventos);
			System.out.println(Eventos.getNomeEvento());
			return mv;
		
	}

	@RequestMapping(value="/comprar/{codigo}", method = RequestMethod.GET)
	public ModelAndView venda(@PathVariable Long codigo) {
		ModelAndView mv = new ModelAndView("TelaVenda");
		mv.addObject(new Evento());
		Evento Eventos = events.findById(codigo).get();
		mv.addObject("events", Eventos);
		return mv;
	}

}
