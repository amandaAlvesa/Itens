package com.amanda.itens.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amanda.itens.entities.Categorias;
import com.amanda.itens.entities.Item;
import com.amanda.itens.service.ItensService;

@RestController
@RequestMapping("/itens")
public class ItensController {
	
	@Autowired
	private ItensService listService;

	@GetMapping()
	public List<Item> retornarItens(){
		return listService.retornarItens();
	}
	
	@GetMapping("/categoria")
	List<Item> categoriaEspecifica(@RequestBody Categorias categoria){
		return listService.pegarCategoria(categoria);
	}

	
}
