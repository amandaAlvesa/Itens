package com.amanda.itens.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amanda.itens.Enums.Categorias;
import com.amanda.itens.Enums.DataVencimento;
import com.amanda.itens.entities.Item;
import com.amanda.itens.metodos.MetodosEspecificos;
import com.amanda.itens.repository.ItemRepository;

@Service
public class ItensService {

	@Autowired
	private ItemRepository repository;
	
	private MetodosEspecificos especificos;

	public List<Item> retornarItens() {
		return repository.findAll();
	}

	public List<Item> pegarCategoria(Categorias categorias) {

		especificos.qtdCategoria();

		return repository.findByCategoria(categorias);
	}
	
	public List<Item>qtdVencimento(DataVencimento data){
		especificos.datasVencimento(data);
		return retornarItens();
	}
}
