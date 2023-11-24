package com.amanda.itens.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amanda.itens.entities.Item;
import com.amanda.itens.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	@PostMapping()
	public Item add(@RequestBody Item item) {
		service.adicionar(item);
		return item;
	} 
	
	@GetMapping("/{id}")
	Optional<Item> retornoDeId(@PathVariable Long id) {
		return service.pegarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	void deletar(@PathVariable Long id) {
		service.remover(id);
	}

}
