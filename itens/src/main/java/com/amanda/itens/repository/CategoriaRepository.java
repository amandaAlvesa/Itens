package com.amanda.itens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.amanda.itens.entities.Categoria;
import com.amanda.itens.projection.CategoriaProjection;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	@Query(nativeQuery = true, value = """ 
			SELECT tb_item.id, tb_item.produto, tb_item.quantidade, tb_item.data_comprada AS dataComprada, tb_item.data_vencimento AS dataVencimento
			FROM tb_item
			INNER JOIN tb_belonging ON tb_item.id = tb_belonging.item_id
			WHERE tb_belonging.categoria_id = :categoriaId
			ORDER BY tb_item.produto
				""")
	List<CategoriaProjection> searchByList(Long categoriaId);
};
