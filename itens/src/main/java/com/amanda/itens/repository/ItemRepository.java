package com.amanda.itens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amanda.itens.Enums.Categorias;
import com.amanda.itens.entities.Item;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	
	 List<Item> findByCategoria(Categorias categoria);
}
