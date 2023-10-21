package com.amanda.itens.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amanda.itens.entities.Item;
import com.amanda.itens.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository repository;
	
	public Item adicionar(Item item) {
		return repository.save(item);
	}
}
