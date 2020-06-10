package com.estudando.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudando.cursomc.domain.Cliente;
import com.estudando.cursomc.repositories.ClienteRepository;
import com.estudando.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer cod) {
		Optional<Cliente> obj = repo.findById(cod);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente cod: " + cod + " não encontrado"));
	}
	
}
