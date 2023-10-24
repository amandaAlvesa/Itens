package com.amanda.itens.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amanda.itens.entities.Item;
import com.amanda.itens.entities.Categoria;
import com.amanda.itens.repository.ItemRepository;
import com.amanda.itens.repository.CategoriaRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	public Item adicionar(Item item) {
		return itemRepository.save(item);
	}
	
	public List<Item> retornar() {
		return itemRepository.findAll();
	}
	
	public Optional<Item> pegarPorId(Long id) {
		return itemRepository.findById(id);
	}
	
}