package com.gft.show.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.show.model.CasaShow;
import com.gft.show.repository.CasaShowRepository;

@Controller
public class CasaShowController {
	
	@Autowired
	private CasaShowRepository cshow;
	

	
	
	@RequestMapping(value="/casas")
	public ModelAndView casas() {
		ModelAndView mv = new ModelAndView("CadastroCasa");
		mv.addObject(new CasaShow());
		List<CasaShow> todasCasas = cshow.findAll();
		mv.addObject("cshow", todasCasas);
		
		
		
		return mv;
	}
	
	
	@RequestMapping(value="/casas", method = RequestMethod.POST)
	public ModelAndView salvar(@Validated CasaShow casas, Errors errors) {
		ModelAndView mv = new ModelAndView("CadastroCasa");
		
		if(errors.hasErrors()) {
			List<CasaShow> todasCasas = cshow.findAll();
			mv.addObject("cshow", todasCasas);
			return mv;
		}
		
		cshow.save(casas);
		
		mv.addObject("mensagem", "Casa Cadastrada com sucesso");
		mv.addObject(new CasaShow());
		List<CasaShow> todasCasas = cshow.findAll();
		mv.addObject("cshow", todasCasas);
		
	

		//Salvar no banco de dados
		
		return mv;
	}
	
	@RequestMapping(value="/casas/{codigo}", method = RequestMethod.POST)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		
	
		cshow.deleteById(codigo);

		
		
		return "redirect:/casas";
	}
	
	
	
	
	@RequestMapping(value="/casas/{codigo}")
	public ModelAndView edicao(@PathVariable ("codigo") CasaShow cshow) {
		
		ModelAndView mv = new ModelAndView("CadastroCasa");
		
		mv.addObject(cshow);
		
		
		return mv;
	}


	
	
	
	
	/*public void excluir(Long codigo) {
		// TODO Auto-generated method stub
		cshow.deleteById(codigo);
	}
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") CasaShow casashow) {

		ModelAndView mv = new ModelAndView("CadastroCasa");
		mv.addObject(casashow);
		return mv;
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.POST)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		this.excluir(codigo);
		
		attributes.addFlashAttribute("mensagem", "Produto excluido com sucesso");
		return "redirect:/titulo";
	}*/
	/*
	package com.gft.show.controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.core.Authentication;
	import org.springframework.stereotype.Controller;
	import org.springframework.validation.Errors;
	import org.springframework.validation.annotation.Validated;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.ModelAndView;
	import org.springframework.web.servlet.mvc.support.RedirectAttributes;

	import com.gft.show.model.CasaShow;
	import com.gft.show.repository.CasaShowRepository;
	import com.gft.show.service.CasaShowService;

	@Controller
	public class CasaShowController {
		
		@Autowired
		private CasaShowRepository cshow;
		
		@Autowired
		private CasaShowService casaSe;
		

		
		
		@GetMapping("/casas")
		public ModelAndView listar() {
			
			ModelAndView mv = new ModelAndView("CadastroCasa");
			mv.addObject(new CasaShow());
			mv.addObject("cshow", casaSe.listar());
			
			return mv;
		}
		
		
		@PostMapping("/casas")
		public ModelAndView salvar(@Validated CasaShow casas, Errors errors) {
			ModelAndView mv = new ModelAndView("CadastroCasa");
			
			if(errors.hasErrors()) {
				
				mv.addObject("cshow", casaSe.listar());
				return mv;
			}
			
			casaSe.salvar(casas);
			//Salvar no banco de dados
			
			mv.addObject("mensagem", "Casa Cadastrada com sucesso");
			mv.addObject(new CasaShow());
			mv.addObject("cshow", casaSe.listar());
			
			
			return mv;
		}
		
		@PostMapping("/casas/{codigo}")
		public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
			
		
			casaSe.deletar(codigo);

			
			
			return "redirect:/casas";
		}
		
		
		
		
		@GetMapping("/casas/{codigo}")
		public ModelAndView edicao(@PathVariable ("codigo") CasaShow cshow) {
			
			ModelAndView mv = new ModelAndView("CadastroCasa");
			
			mv.addObject(cshow);
			mv.addObject(casaSe.atualizar(cshow));
			return mv;
		}
*/

}
