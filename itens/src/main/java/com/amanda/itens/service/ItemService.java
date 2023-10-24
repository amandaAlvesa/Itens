package com.amanda.itens.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<Item> retornar() {
		return repository.findAll();
	}
	
	public Optional<Item> pegarPorId(Long id) {
		return repository.findById(id);
	}
	
}
