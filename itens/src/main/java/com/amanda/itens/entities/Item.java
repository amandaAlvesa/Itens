package com.amanda.itens.entities;

import java.time.LocalDate;

import com.amanda.itens.Enums.Categorias;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String produto;
	private Integer quantidade;
	@Column(name = "data_comprada")
	private LocalDate dataComprada;
	@Column(name="data_vencimento")
	private LocalDate dataVencimento;
	private Categorias categoria;

}