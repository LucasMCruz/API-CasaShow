package com.gft.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.show.model.Usuario;
import com.gft.show.repository.UserRepository;



@Controller
public class EntrarController {
	
	
	@Autowired
	UserRepository users;
	
	
	@RequestMapping("/registrar")
	public ModelAndView view() {
		ModelAndView mv = new ModelAndView("cadastro");
		
		return mv;
		
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/entrar")
	public String login() {
		return "entrar";
	}

	
	@RequestMapping(value="/registrar", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Validated Usuario usuario) {
		
		ModelAndView mv = new ModelAndView("cadastro");
		mv.addObject(new Usuario());
		/*if(usuario.getUsername() != null) {
			Usuario a = users.findById(username).get();
			if(a != null) {
				mv.addObject("mensagem", "Usuario ja existente");
				return mv;
			}		
		}*/
		if(users.existsById(usuario.getUsername())) {
			mv.addObject("mensagem", "Usuario ja existente");
			return mv;
		}
		mv.addObject("mensagem", "Cadastrado com sucesso, ENTRE NA TELA DE LOGIN");
		users.save(usuario);
		return mv;

		
	}


}

