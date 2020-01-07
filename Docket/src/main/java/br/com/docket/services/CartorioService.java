package br.com.docket.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.docket.models.Cartorio;
import br.com.docket.repositories.CartorioRepository;

@Service
public class CartorioService {

	@Autowired
	CartorioRepository cartorioRepository;
	
	public List<Cartorio> listaDeCartorios() {
		return cartorioRepository.findAll();
	}

	public Cartorio salvarCartorio(Cartorio cartorio) {
		return cartorioRepository.save(cartorio);
	}

	public Cartorio buscaPorId(Long id) {
		Optional<Cartorio> optional = cartorioRepository.findById(id);
		return optional.get();
	}

	public void excluir(Long id) {
		cartorioRepository.delete(buscaPorId(id));
	}
}
