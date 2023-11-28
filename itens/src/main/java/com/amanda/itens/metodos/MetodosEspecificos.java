package com.amanda.itens.metodos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.amanda.itens.Enums.Categorias;
import com.amanda.itens.Enums.DataVencimento;
import com.amanda.itens.entities.Item;
import com.amanda.itens.service.ItensService;

public class MetodosEspecificos {

	@Autowired
	private ItensService service;

	public void qtdCategoria() {
		int limpeza = 0, alimentoPerecivel = 0, alimentoNaoPerecivel = 0;

		for (int i = 0; i < service.retornarItens().size(); i++) {
			if (service.retornarItens().get(i).getCategoria() == Categorias.ALIMENTO_NAO_PERECIVEL) {
				alimentoNaoPerecivel++;
			} else if (service.retornarItens().get(i).getCategoria() == Categorias.ALIMENTO_PERECIVEL) {
				alimentoPerecivel++;
			} else if (service.retornarItens().get(i).getCategoria() == Categorias.LIMPEZA) {
				limpeza++;
			}
		}

		System.out.println("Alimento Perecivel: " + alimentoPerecivel);
		System.out.println("Alimento Não Perecivel: " + alimentoNaoPerecivel);
		System.out.println("Limpeza: " + limpeza);
	}

	public boolean datasVencimento(DataVencimento data) {
		List<Item> datasCertas = new ArrayList<Item>();

//		for (int i = 0; i < service.retornarItens().size(); i++) {
			// int dias = 0;
			// boolean retornar =
			// service.retornarItens().get(i).getDataVencimento().isBefore(LocalDate.now().plusDays(dias));

//			switch (data) {
//			case SEMANA:
//				// dias = 7;
//				boolean retornar = service.retornarItens().get(i).getDataVencimento()
//						.isBefore(LocalDate.now().plusDays(7));
//
//				if (retornar) {
//					System.out.println(service.retornarItens().get(i));
//					datasCertas.add(service.retornarItens().get(i));
//				}
//			case METADE_MES:
//				// dias=15;
//				boolean retornarMetade = service.retornarItens().get(i).getDataVencimento()
//						.isBefore(LocalDate.now().plusDays(15));
//				if (retornarMetade) {
//					System.out.println(service.retornarItens().get(i));
//					datasCertas.add(service.retornarItens().get(i));
//				}
//			case MES:
//				// dias=30;
//				boolean retornarMes = service.retornarItens().get(i).getDataVencimento()
//						.isBefore(LocalDate.now().plusDays(30));
//
//				if (retornarMes) {
//					System.out.println(service.retornarItens().get(i));
//					datasCertas.add(service.retornarItens().get(i));
//				}
//			default:
//				System.out.println("Vencimento nao deu certo");
//				break;
//			}
//		}

		for (int i = 0; i < service.retornarItens().size(); i++) {

			if (data == DataVencimento.SEMANA) {
				boolean retornar = service.retornarItens().get(i).getDataVencimento()
						.isBefore(LocalDate.now().plusDays(7));
				if (retornar) {
					System.out.println(service.retornarItens().get(i));
					datasCertas.add(service.retornarItens().get(i));
				}
			} else if (data == DataVencimento.METADE_MES) {
				boolean retornarMetade = service.retornarItens().get(i).getDataVencimento()
						.isBefore(LocalDate.now().plusDays(15));
				if (retornarMetade) {
					System.out.println(service.retornarItens().get(i));
					datasCertas.add(service.retornarItens().get(i));
				}
			} else if (data == DataVencimento.MES) {
				boolean retornarMes = service.retornarItens().get(i).getDataVencimento()
						.isBefore(LocalDate.now().plusDays(30));
				if (retornarMes) {
					System.out.println(service.retornarItens().get(i));
					datasCertas.add(service.retornarItens().get(i));
				}
			} else {
				System.out.println("Vencimento nao deu certo");
			}
		}
		boolean meu = service.retornarItens().isEmpty();
		return meu;
	}

}
