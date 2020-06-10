package com.estudando.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudando.cursomc.domain.Categoria;
import com.estudando.cursomc.domain.Pedido;
import com.estudando.cursomc.repositories.PedidoRepository;
import com.estudando.cursomc.services.exceptions.ObjectNotFoundException;



@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Id " + id + " não encontrado, tipo: " + Categoria.class.getName()));
	}
	
}
