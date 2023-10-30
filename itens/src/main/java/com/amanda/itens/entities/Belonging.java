package com.amanda.itens.entities;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of="id")
@Entity
@Table(name="tb_belonging")
public class Belonging {

	@EmbeddedId
	private BelongingPk id = new BelongingPk();
	
	public Belonging(Item item, Categoria categoria) {
		id.setCategoria(categoria);
		id.setItem(item);
	}
	
}	

