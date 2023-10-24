package com.amanda.itens.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amanda.itens.dto.CategoriaDto;
import com.amanda.itens.entities.Categoria;
import com.amanda.itens.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repository;

	public Categoria adicionarCategoria(Categoria result) {
		return repository.save(result);
	}

	public List<CategoriaDto> categorias(){
		List<Categoria> categoria = repository.findAll();
		List<CategoriaDto> result = categoria.stream().map(c -> new CategoriaDto(c.getCategoria(), c.getQuantidadeNaCategoria())).toList();
		return result;
	}
	
}
