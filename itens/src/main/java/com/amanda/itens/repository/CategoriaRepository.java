package com.amanda.itens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amanda.itens.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
