package com.amanda.itens.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amanda.itens.dto.CategoriaDto;
import com.amanda.itens.entities.Categoria;
import com.amanda.itens.projection.CategoriaProjection;
import com.amanda.itens.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriasController {

	@Autowired
	CategoriaService service;
	
	@PostMapping()
	ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria item){
		return ResponseEntity.status(HttpStatus.OK).body(service.adicionarCategoria(item));
	}
	
	@GetMapping
	List<Categoria> categorias() {
		return service.categorias();
	}
	
	@GetMapping("/{id}")
	Optional<Categoria> pegarCategoria(@PathVariable Long id){
		return service.pegarCategoria(id);
	}
	
	@DeleteMapping("/{id}")
	void remover(@PathVariable Long id) {
		service.remover(id);
	}
	
	@GetMapping("/{categoriaId}/itens")
	List<CategoriaProjection> listaCategoria(@PathVariable Long categoriaId){
		return service.listaCategoria(categoriaId);
	}
}
