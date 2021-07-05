package com.ricardo.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ricardo.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

	@Query(value = "select l from Livro l where l.categoria.id = :idCat order by titulo")
	List<Livro> findAllByCategoria(@Param(value = "idCat") Integer idCat);

}
