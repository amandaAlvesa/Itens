package com.amanda.itens.projection;

import java.time.LocalDate;


public interface CategoriaProjection {
	Long getId();
	String getProduto();
	Integer getQuantidade();
	LocalDate getDataComprada();
	LocalDate getDataVencimento();
	String getCategoria();
}
