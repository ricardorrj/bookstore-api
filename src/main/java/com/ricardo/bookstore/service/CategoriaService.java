package com.ricardo.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.bookstore.domain.Categoria;
import com.ricardo.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findByid(Integer id) {
		
		Optional<Categoria> cat = categoriaRepository.findById(id);
		
		return cat.orElse(null);	//orElse retorna null quando não encontrado dados obj
	}
}
