package com.amanda.itens.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amanda.itens.Enums.Categorias;
import com.amanda.itens.entities.Item;
import com.amanda.itens.repository.ItemRepository;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	public Optional<Item> item(Long id) {
		return pegarPorId(id);
	}
	
	public void adicionar(Item item) {
		 itemRepository.save(item);
	} 
	
	
	public Optional<Item> pegarPorId(Long id) {
		return itemRepository.findById(id);
	}
	
	public void remover(Long id) {
		itemRepository.deleteById(id);
	}
}
