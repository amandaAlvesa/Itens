package com.amanda.itens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.amanda.itens.controllers.ItemController;
import com.amanda.itens.entities.Item;

@SpringBootApplication
public class RegistroDeItensApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroDeItensApplication.class, args);
	}

}
