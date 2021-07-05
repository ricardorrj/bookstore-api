package com.ricardo.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.bookstore.domain.Categoria;
import com.ricardo.bookstore.domain.Livro;
import com.ricardo.bookstore.repositories.CategoriaRepository;
import com.ricardo.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository catRepository;

	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDataBase() {
		Categoria cat = new Categoria(null, "Curso Java", "TI-01");
		Categoria cat2 = new Categoria(null, "Programação POO", "TI-01");
		Categoria cat3 = new Categoria(null, "Desenvolvimento Web", "TI-01");
		
		Livro livro = new Livro(null, "Titulo Livro", "Autor", "Texto teste", cat);
		Livro livro2 = new Livro(null, "Titulo Livro2", "Autor2", "Texto teste2", cat);
		Livro livro3 = new Livro(null, "Titulo Livro3", "Autor3", "Texto teste3", cat2);
		Livro livro4 = new Livro(null, "Titulo Livro4", "Autor4", "Texto teste4", cat3);
		
		cat.getLivros().addAll(Arrays.asList(livro));
		
		this.catRepository.saveAll(Arrays.asList(cat, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(livro, livro2, livro3, livro4));
	}
}
