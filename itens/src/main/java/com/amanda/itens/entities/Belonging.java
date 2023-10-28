package com.amanda.itens.entities;

import java.util.Optional;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
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
	
	public Belonging(Item item, Optional<Categoria> categoria) {
		id.setCategoria(categoria);
		id.setItem(item);
	}
}
