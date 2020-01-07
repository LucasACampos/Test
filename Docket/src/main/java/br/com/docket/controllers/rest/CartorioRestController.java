package br.com.docket.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.docket.models.Cartorio;
import br.com.docket.services.CartorioService;

@RestController
@RequestMapping("cartorios")
public class CartorioRestController {

	@Autowired
	private CartorioService homeService;
	
	@GetMapping
	public List<Cartorio> listaDeCartorios(){
		return homeService.listaDeCartorios();
	}
}
