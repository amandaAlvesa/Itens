package com.amanda.itens.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amanda.itens.entities.Belonging;
import com.amanda.itens.entities.Categoria;
import com.amanda.itens.entities.Item;
import com.amanda.itens.repository.CategoriaRepository;
import com.amanda.itens.repository.ItemRepository;

import jakarta.persistence.ManyToOne;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	public void adicionar(Item item) {
		 new Belonging(item, new Categoria(item.getCategoria()));
		 itemRepository.save(item);
	} 
	
	public List<Item> retornar() {
		return itemRepository.findAll();
	}
	
	public Optional<Item> pegarPorId(Long id) {
		return itemRepository.findById(id);
	}
	
	public void remover(Long id) {
		itemRepository.deleteById(id);
	}
}
