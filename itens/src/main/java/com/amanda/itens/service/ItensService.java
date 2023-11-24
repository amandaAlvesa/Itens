package com.amanda.itens.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amanda.itens.entities.Categorias;
import com.amanda.itens.entities.Item;
import com.amanda.itens.repository.ItemRepository;

@Service
public class ItensService {

	@Autowired
	private ItemRepository repository;

	public List<Item> retornarItens() {
		return repository.findAll();
	}

	public List<Item> pegarCategoria(Categorias categorias) {
		
		qtdCategoria();
		
		return repository.findByCategoria(categorias);
	}

	public void qtdCategoria() {
		int limpeza = 0, alimentoPerecivel = 0, alimentoNaoPerecivel = 0;

		for(int i=0; i < retornarItens().size(); i++){
			if (retornarItens().get(i).getCategoria() == Categorias.ALIMENTO_NAO_PERECIVEL) {
				alimentoNaoPerecivel++;
			} else if (retornarItens().get(i).getCategoria() == Categorias.ALIMENTO_PERECIVEL) {
				alimentoPerecivel++;
			} else if (retornarItens().get(i).getCategoria() == Categorias.LIMPEZA) {
				limpeza++;
			}
		}

		System.out.println("Alimento Perecivel: " + alimentoPerecivel);
		System.out.println("Alimento Não Perecivel: " + alimentoNaoPerecivel);
		System.out.println("Limpeza: " + limpeza);
	}

}
