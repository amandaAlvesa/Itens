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

Preparando a Interface Grafica Neste Repositorio: https://github.com/amandaAlvesa/ItemFront

/////// mais ou menos 2 meses depois

o Back-end está funcionando perfeitamente aos testes no insomnia, quando passo para o Front-end os resultados são perdidos pela minha falta de conhecimento com React. Imagens de como ficou o Front e o que está acontecendo em cada página:
![Tela Inicial](https://github.com/amandaAlvesa/Itens/assets/108950028/8054191d-cfd5-4ffe-bc9e-580584623e1a)
Nesta primeira página o codigo está rodando certo
```java
<div className='card-unico'>
            <Link to={`/editar/${itemData.id}`} >
              <Card 
                imagem={itemData.imagem}
                produto={itemData.produto} 
                quantidade={itemData.quantidade} 
                dataVencimento={itemData.dataVencimento} 
                key={itemData.id}/>  
            </Link>
          </div>
```
----------------------------------------

![Adicionar Novo Item](https://github.com/amandaAlvesa/Itens/assets/108950028/c88f3627-36b9-4607-b9c4-8852d81648a9)
Adicionar novo item tambem está funcionando corretamente
![Novo Item Adicionado](https://github.com/amandaAlvesa/Itens/assets/108950028/14d7f4fe-be3e-4bdd-8f2e-7f470634014f)

---------------------------------------
![Edição](https://github.com/amandaAlvesa/Itens/assets/108950028/9de18db5-3858-475e-bc7d-e0c4b724f6ca)
Ao entrar no item aparece esta tela e é possivel completar corretamente cada informação, mas ao clicar FEITO ele apenas carrega a página e permanece onde está

```java
const submit = async () => {
      const itemDataEditarPronto: ItemDataEditar = {
        produto,
        quantidade,
        categoria,
        dataComprada,
        dataVencimento
      }
      await axios.put(`http://localhost:1002/item/modificar/${id}`,itemDataEditarPronto);
      navigate("/")
  }

|
|
V

 <button onClick={submit}  className="btn-secondary">Feito</button>
```
Tendo mudado apenas a categoria e clicado em Feito e depois Cancelar volta diretamente a tela de inicio
![Alterção](https://github.com/amandaAlvesa/Itens/assets/108950028/7403c171-bef8-40dc-a54f-b80873e0ebb3)
A alteração é feita, mas duplica e as vezes triplica o item

