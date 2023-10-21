package com.amanda.itens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amanda.itens.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
