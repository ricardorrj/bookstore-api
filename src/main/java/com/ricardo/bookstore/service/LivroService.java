package com.ricardo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.bookstore.domain.Categoria;
import com.ricardo.bookstore.domain.Livro;
import com.ricardo.bookstore.repositories.LivroRepository;
import com.ricardo.bookstore.service.exception.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById(Integer id) {
		
		Optional<Livro> obj = livroRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto Não encontrado! Id: " + id + " Tipo: " + Livro.class.getName()));
	}
	
	
	public List<Livro> findAll(Integer idCat){
		
		categoriaService.findByid(idCat);
		
		List<Livro> list = livroRepository.findAllByCategoria(idCat);
		return list;
	}
	
	
	public Livro create(Integer idCat, Livro obj) {
		obj.setId(null);
		
		Categoria cat = categoriaService.findByid(idCat);
		obj.setCategoria(cat);
		obj = livroRepository.save(obj);
		return obj;
	}
	
	
	public Livro update(Integer id, Livro obj) {
		
		Livro newLivro = findById(id);
		update(newLivro, obj);
		
		return livroRepository.save(newLivro);
	}


	private void update(Livro newLivro, Livro obj) {
		newLivro.setTitulo(obj.getTitulo());
		newLivro.setNomeAutor(obj.getNomeAutor());
		newLivro.setTexto(obj.getTexto());
	}
	
	
	public void delete(Integer id) {
		livroRepository.findById(id);
		livroRepository.deleteById(id);
	}
}
