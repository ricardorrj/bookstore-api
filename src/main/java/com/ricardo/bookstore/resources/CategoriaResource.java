package com.ricardo.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.bookstore.domain.Categoria;
import com.ricardo.bookstore.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;

	@GetMapping(value = "{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id){
		
		Categoria cat = service.findByid(id);
		
		return ResponseEntity.ok().body(cat);
	}
	
}
