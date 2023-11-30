package com.amanda.itens.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amanda.itens.Enums.Categorias;
import com.amanda.itens.Enums.DataVencimento;
import com.amanda.itens.Enums.Ordenação;
import com.amanda.itens.entities.Item;
import com.amanda.itens.repository.ItemRepository;

@Service
public class ItensService {

	@Autowired
	private ItemRepository repository;

	public List<Item> retornarItens() {
		return repository.findAll();
	}

	public List<Item> pegarCategoria(Categorias categorias) {
		int limpeza = 0, alimentoPerecivel = 0, alimentoNaoPerecivel = 0;

		for (int a = 0; a < retornarItens().size(); a++) {
			if (retornarItens().get(a).getCategoria() == Categorias.ALIMENTO_NAO_PERECIVEL) {
				alimentoNaoPerecivel++;
			} else if (retornarItens().get(a).getCategoria() == Categorias.ALIMENTO_PERECIVEL) {
				alimentoPerecivel++;
			} else if (retornarItens().get(a).getCategoria() == Categorias.LIMPEZA) {
				limpeza++;
			}
		}

		System.out.println("Alimento Perecivel: " + alimentoPerecivel);
		System.out.println("Alimento Não Perecivel: " + alimentoNaoPerecivel);
		System.out.println("Limpeza: " + limpeza);

		return repository.findByCategoria(categorias);
	}

	public List<Item> datasVencimento(DataVencimento data) {

		List<Item> datasCertas = new ArrayList<Item>();
		datasCertas.add(retornarItens().get(1));

		for (int b = 0; b < retornarItens().size(); b++) {
			if (data == DataVencimento.SEMANA) {
				boolean retornarSemana = retornarItens().get(b).getDataVencimento()
						.isBefore(LocalDate.now().plusDays(7));

				if (retornarSemana) {
					datasCertas.add(retornarItens().get(b));
				}
			} else if (data == DataVencimento.METADE_MES) {
				boolean retornarMetade = retornarItens().get(b).getDataVencimento()
						.isBefore(LocalDate.now().plusDays(15));

				if (retornarMetade) {
					datasCertas.add(retornarItens().get(b));
				}
			} else if (data == DataVencimento.MES) {
				boolean retornarMes = retornarItens().get(b).getDataVencimento().isBefore(LocalDate.now().plusDays(30));

				if (retornarMes) {
					datasCertas.add(retornarItens().get(b));
				}
			} else {
				System.out.println(retornarItens().get(b).getProduto());
				System.out.println("Vencimento nao deu certo");
				break;
			}
		}
		datasCertas.remove(0);
		System.out.println(datasCertas.size());
		return datasCertas;
	}

	public List<Item> ProdutosVencidos() {
		List<Item> vencidos = new ArrayList<Item>();
		vencidos.add(retornarItens().get(0));

		for (int c = 0; c < retornarItens().size(); c++) {
			if (retornarItens().get(c).getDataVencimento().isBefore(LocalDate.now())) {
				vencidos.add(retornarItens().get(c));
			}
		}
		vencidos.remove(0);
		System.out.println(vencidos.size());
		return vencidos;
	}

	public List<Item> historico() {
		int aoContrario = (retornarItens().size() - 1);
		List<Item> listaAoContrario = new ArrayList<Item>();
		listaAoContrario.add(retornarItens().get(0));

		for (int d = aoContrario; d >= 0; d--) {
			listaAoContrario.add(retornarItens().get(d));
		}
		listaAoContrario.remove(0);
		System.out.println(
				"Lista: " + retornarItens().size() + "\n Lista ao Contrario (historico): " + listaAoContrario.size());
		return listaAoContrario;
	}

	public List<Item> Ordem(Ordenação ordemEscolhida) {
		List<Item> ordem = new ArrayList<Item>();
		ordem.add(retornarItens().get(0));
		ordem.remove(0);

		for (int e = 0; e < retornarItens().size(); e++) {
			ordem.add(retornarItens().get(e));
		}

		if (ordemEscolhida == Ordenação.PRODUTO) {
			ordem.sort((p1, p2) -> {
				String p = p1.getProduto();
				return p.compareTo(p2.getProduto());
			});
		} else if(ordemEscolhida == Ordenação.COMPRADO) {
			ordem.sort((c1, c2) -> {
				LocalDate c = c1.getDataComprada();
				return c.compareTo(c2.getDataComprada());
			});
		} else if(ordemEscolhida == Ordenação.VENCIMENTO) {
			ordem.sort((v1, v2) -> {
				LocalDate v = v1.getDataVencimento();
				return v.compareTo(v2.getDataVencimento());
			});
		} else if(ordemEscolhida == Ordenação.QUANTIDADE) {
			ordem.sort((q1, q2) -> {
				Integer q = q1.getQuantidade();
				return q.compareTo(q2.getQuantidade());
			});
		}

		return ordem;
	}

}



















