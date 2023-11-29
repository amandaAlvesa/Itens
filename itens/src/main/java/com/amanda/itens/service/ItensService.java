package com.amanda.itens.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amanda.itens.Enums.Categorias;
import com.amanda.itens.Enums.DataVencimento;
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

		qtdCategoria();

		return repository.findByCategoria(categorias);
	}
	
	public void qtdCategoria() {
		int limpeza = 0, alimentoPerecivel = 0, alimentoNaoPerecivel = 0;

		for (int i = 0; i < retornarItens().size(); i++) {
			if (retornarItens().get(i).getCategoria() == Categorias.ALIMENTO_NAO_PERECIVEL) {
				alimentoNaoPerecivel++;
			} else if (retornarItens().get(i).getCategoria() == Categorias.ALIMENTO_PERECIVEL) {
				alimentoPerecivel++;
			} else if (retornarItens().get(i).getCategoria() == Categorias.LIMPEZA) {
				limpeza++;
			}
		}

		System.out.println("Alimento Perecivel: " + alimentoPerecivel);
		System.out.println("Alimento Não Perecivel: " + alimentoNaoPerecivel);
		System.out.println("Limpeza: " + limpeza);
	}
	
	
	
	
	public List<Item> datasVencimento(DataVencimento data) {
		
		List<Item> datasCertas = new ArrayList<Item>();
		datasCertas.add(retornarItens().get(1));
		
		for (int i = 0; i < retornarItens().size(); i++) {
				if(data == DataVencimento.SEMANA) {
					boolean retornarSemana = retornarItens().get(i).getDataVencimento()
							.isBefore(LocalDate.now().plusDays(7));
					
					if (retornarSemana) {
						datasCertas.add(retornarItens().get(i));
					}} else if(data == DataVencimento.METADE_MES) {
					boolean retornarMetade = retornarItens().get(i).getDataVencimento()
							.isBefore(LocalDate.now().plusDays(15));
					
					if (retornarMetade) {
						datasCertas.add(retornarItens().get(i));
					}} else if(data == DataVencimento.MES) {
					boolean retornarMes = retornarItens().get(i).getDataVencimento()
							.isBefore(LocalDate.now().plusDays(30));
		
					if (retornarMes) {
						datasCertas.add(retornarItens().get(i));
					}} else {
					System.out.println(retornarItens().get(i).getProduto());
					System.out.println("Vencimento nao deu certo");
					break;
				}}
		datasCertas.remove(0);
		System.out.println(datasCertas.size());
			return datasCertas;
	}
	
	public List<Item> ProdutosVencidos(){
		List<Item> vencidos = new ArrayList<Item>();
		vencidos.add(retornarItens().get(0));
		
		for(int x = 0; x < retornarItens().size(); x++) {
			if(retornarItens().get(x).getDataVencimento().isBefore(LocalDate.now())) {
				vencidos.add(retornarItens().get(x));
			}
		}
		vencidos.remove(0);
		System.out.println(vencidos.size());
		return vencidos;
	}
}

