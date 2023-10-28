package com.amanda.itens.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amanda.itens.dto.CategoriaDto;
import com.amanda.itens.entities.Categoria;
import com.amanda.itens.repository.CategoriaRepository;
import com.amanda.itens.repository.ItemRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repository;
	
	@Autowired
	ItemRepository itemRepository;

	public Categoria adicionarCategoria(Categoria result) {
		return repository.save(result);
	}

	public List<CategoriaDto> categorias(){
		List<Categoria> categoria = repository.findAll();
		List<CategoriaDto> result = categoria.stream().map(c -> new CategoriaDto(c.getCategoria(), c.getQuantidadeNaCategoria())).toList();
		return result;
	}
	
	public Optional<Categoria> pegarCategoria(Long id) {
		return repository.findById(id);
	}
	
	
//	public List<Categoria> adicionarNaCategoria(Categoria categoria, Long item){
//		repository.existsById(categoria);
//		itemRepository.existsById(item);
//		
//		
//	}
//
//	public ResponseEntity<ResponseModelo> salvar(ProdutoList produto){
//		produtoListRepository.save(produto);
//		rm.setMensagem("Produto Criado");
//		return new ResponseEntity<>(rm, HttpStatus.CREATED);
//	}
	
	
	public void remover(Long id) {
		repository.deleteById(id);
	}
}
