package br.com.docket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import br.com.docket.models.Cartorio;
import br.com.docket.services.CartorioService;

@Controller
@RequestMapping("cartorio")
public class CartorioController {

	@Autowired
	private CartorioService cartorioService;	

	@PostMapping("/salvar")
	public String salvar(Cartorio cartorio) {
		cartorioService.salvarCartorio(cartorio);
		return "redirect:/";
	}

	@GetMapping("/editar/{id}")
	public RedirectView editar(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("/");
		redirectAttributes.addFlashAttribute(cartorioService.buscaPorId(id));
		return redirectView;
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id) {
		cartorioService.excluir(id);
		return "redirect:/";
	}
}
