package com.amanda.itens.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Item> add(@RequestBody Item item) {
		return ResponseEntity.status(HttpStatus.OK).body(service.adicionar(item));
	}
	
}
