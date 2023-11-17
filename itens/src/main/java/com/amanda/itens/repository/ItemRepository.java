package com.amanda.itens.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.amanda.itens.entities.Categorias;
import com.amanda.itens.entities.Item;
import com.amanda.itens.projection.CategoriaProjection;

import jakarta.transaction.Transactional;

@Transactional
public interface ItemRepository extends JpaRepository<Item, Long> {
//	@Modifying
//	@Query(nativeQuery = true, value = """
//			INSERT INTO tb_item(id, produto, quantidade, data_comprada, data_vencimento, categoria) VALUES (1,2,3,4,5,6)""")
//	List<CategoriaProjection> addItem(Long idItem, String produtoItem, Integer quantidadeItem, LocalDate dataCompradaItem, LocalDate dataVencimentoItem, Categorias categoriaItem);
}
