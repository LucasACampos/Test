package br.com.docket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.docket.models.Cartorio;
import br.com.docket.services.CartorioService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private CartorioService cartorioService;
	
	@GetMapping
	public ModelAndView home(Cartorio cartorio) {

		List<Cartorio> cartorios = cartorioService.listaDeCartorios();

		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("cartorio", cartorio);
		modelAndView.addObject("listaDeCartorios", cartorios);
		return modelAndView;
	}
}
