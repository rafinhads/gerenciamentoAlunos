# Sistema de Gerenciamento de Alunos

## Sobre o Projeto:

Este projeto é uma aplicação web desenvolvida em Java utilizando o framework Spring Boot, seguindo o padrão MVC. O sistema permite realizar operações de CRUD (Criar, Ler, Atualizar e Deletar) para gerenciar informações de alunos, com persistência de dados em um banco de dados MySQL.

## Funcionalidades

- Cadastro de novos alunos
- Listagem de alunos cadastrados
- Edição de informações dos alunos
- Remoção de alunos do sistema
- Tela de login e cadastro de usuários
- Criptografia de dados dos usuários
- Validação de regras de negócio com JavaScript
 
## Tecnologias Utilizadas

- Java
- Spring Boot
- JPA / Hibernate
- Maven
- HTML/CSS/JS
- Bootstrap
- MySQL
- Thymeleaf

## Estrutura do Projeto

O projeto segue a arquitetura MVC (Model-View-Controller), com as seguintes camadas:

- Model: Contém as entidades JPA que representam as tabelas do banco de dados.
- Repository: Interfaces que estendem JpaRepository para acesso aos dados.
- Service: Contém a lógica de negócio da aplicação.
- Controller: Gerencia as requisições HTTP e interage com a camada de serviço.
- View: Templates HTML utilizando Thymeleaf para renderização das páginas.


## Instalação

O projeto é gerenciado pelo Maven, então para usa-lo basta importa-lo para uma IDE.

## Configurações do banco de dados
Você pode criar um banco de dados MySQL com o nome o nome de sua preferência, porém é necessario adequar o projeto de acordo com as suas configurações. Para isso abra o arquivo application.properties, localizado em src/main/resources/application.properties e altere os seguintes comandos ao arquivo:

```
- spring.datasource.url = jdbc:mysql://localhost:3306/nome-do-seu-banco-de-dados?useTimezone=true&serverTimezone=UTC
- spring.datasource.username = root
- spring.datasource.password = 12345678
```
 

## Execução
Execute o projeto através do IDE, abra um navegador de sua preferência e digite: http://localhost:8080
