# Itens
Para não esquecer os produtos que tem em casa e nem perder com validade vencida

Tecnologias: Java, Spring Boot, Postgre e Insomnia

Inicializar com dependencias no Spring Initializer
Criar Packages como: Entities, criando tambem Service, Repository, Controller e Enums.

Package Enum - Como os produtos da casa podem ser tanto comida quanto de limpeza criei o Enum Categoria, DataDeVencimento para selecionar em quanto tempo certo produto vence e Ordenação 
   para ordenar os produtos de acordo com:produto, quantida, comprado ou vencimento.

Package Entities - Somente uma classe Item, onde está as caracteristicas que cada produto deve ter.

Package Repository - No momento apenas instaciei o findByCategoria.

Package Service - Para melhor manutenção criei ItemService, para retorno de apenas um dado, e ItensService, para retorno de Lists. No ItensService escrevi varias funcionalidades para     
    manipular os Produtos da maneira que achar melhor, seja em uma pesquisa rapida, RetornarItens(), ou datasVencimento(DataVencimento "Semana") para retornar itens que vencem em 7 dias.

Package Controller - Assim como o Service dividi Item e Itens, alterando também o @RequestMapping, instanciado de seu devido Service.

