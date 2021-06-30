package com.ricardo.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ricardo.bookstore.domain.Categoria;
import com.ricardo.bookstore.domain.Livro;
import com.ricardo.bookstore.repositories.CategoriaRepository;
import com.ricardo.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository catRepository;

	@Autowired
	private LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat = new Categoria(null, "Curso Java", "TI");
		Livro livro = new Livro(null, "Titulo Livro", "Autor", "Texto teste", cat);
		
		cat.getLivros().addAll(Arrays.asList(livro));
		
		this.catRepository.saveAll(Arrays.asList(cat));
		this.livroRepository.saveAll(Arrays.asList(livro));
	}
	
}
