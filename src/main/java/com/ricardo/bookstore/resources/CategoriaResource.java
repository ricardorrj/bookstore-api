package com.ricardo.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ricardo.bookstore.domain.Categoria;
import com.ricardo.bookstore.dtos.CategoriaDTO;
import com.ricardo.bookstore.service.CategoriaService;

@CrossOrigin("*")
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

	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		
		List<Categoria>	list = service.findAll();
		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok(listDTO);
	}
	
	
	@PostMapping
	public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria obj){
		obj = service.create(obj);
		
		//Retorna o ID da categoria criada, Caminho para acesso
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getId()).toUri();  
		 
		return ResponseEntity.created(uri).build();
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @Valid @RequestBody CategoriaDTO objDTO){
		Categoria newCat = service.update(id, objDTO);
		
		return ResponseEntity.ok().body(new CategoriaDTO(newCat));
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build(); //Não retorna nenhum conteudo! 
	}
}





