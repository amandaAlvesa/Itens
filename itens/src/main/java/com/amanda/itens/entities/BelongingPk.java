package com.amanda.itens.entities;

import java.util.Objects;
import java.util.Optional;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
//
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@Embeddable
public class BelongingPk {
//
//	@ManyToOne
//	@JoinColumn(name = "item_id")
//	private Item item;
//	
//	@ManyToOne
//	@JoinColumn(name = "categoria_id")
//	private Optional<Categoria> categoria;
//
//	public void setCategoria(Optional<Categoria> categoria) {
//		this.categoria = categoria;
//	}
//	
//	public void setItem(Item item) {
//		this.item = item;
//	}
//	
//	@Override
//	public int hashCode() {
//		return Objects.hash(categoria, item);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		BelongingPk other = (BelongingPk) obj;
//		return Objects.equals(categoria, other.categoria) && Objects.equals(item, other.item);
//	}

}
