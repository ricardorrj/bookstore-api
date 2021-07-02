package com.ricardo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.bookstore.domain.Categoria;
import com.ricardo.bookstore.dtos.CategoriaDTO;
import com.ricardo.bookstore.repositories.CategoriaRepository;
import com.ricardo.bookstore.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria findByid(Integer id) {

		Optional<Categoria> cat = categoriaRepository.findById(id);

		return cat.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto Não encontrado! Id: " + id + " Tipo: " + Categoria.class.getName()));
	}
	
	
	public List<Categoria> findAll(){	
		List<Categoria> categorias = categoriaRepository.findAll();	
		return categorias;
	}
	
	
	public Categoria create(Categoria obj) {
		obj.setId(null); 
		Categoria categoria = categoriaRepository.save(obj);
		
		return categoria;
	}
	

	public Categoria update(Integer id, CategoriaDTO objDTO) {
		
		Categoria cat = findByid(id);
		cat.setNome(objDTO.getNome());
		cat.setDescricao(objDTO.getDescricao());
		
		return categoriaRepository.save(cat);
	}
	
	
	public void delete(Integer id) {
		findByid(id);
		categoriaRepository.deleteById(id);
	}
	
	
}
