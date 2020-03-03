package com.gft.show.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HistoricoController {

	



	@RequestMapping(method = RequestMethod.GET, path = "/historico")
	public ModelAndView LifeStyle() {
		ModelAndView mv = new ModelAndView("Historico");
		return mv;
	}
	
	


	
}
