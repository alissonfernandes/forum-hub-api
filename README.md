# FórumHub
O FórumHub é o ambiente onde replica o processo no nível back end no qual participantes de uma plataforma de cursos podem tirar suas dúvidas sobre assuntos dos cursos no qual estão participando.

![Badge em Desenvolviment](http://img.shields.io/static/v1?label=STATUS&message=Em%20Desenvolvimento&color=yellow&style=for-the-badge)
![Badge em Desenvolviment](http://img.shields.io/static/v1?label=&message=java&color=red&style=for-the-badge)
![Badge em Desenvolviment](http://img.shields.io/static/v1?label=&message=Spring&color=green&style=for-the-badge)
![Badge em Desenvolviment](http://img.shields.io/static/v1?label=&message=MySQL%208&color=blue&style=for-the-badge)
## ✨ Funcionalidades
 * ``Criar novo tópico:`` permite o usuário publicar um novo tópico enviando um `body request`
 * ``Mostrar todos os tópicos criados:`` permite listar todos os tópicos já publicados de forma paginada 
 * ``Mostrar topico específico:`` permite detalhar um tópico em específico através de um ID específico
 * ``Atualizar tópico:`` permite atualizar um tópico por meio de um ID e um `body request`
 * ``Eliminar tópico:`` permite eliminar de forma física um tópico através de um ID específico

## 🚀 Tecnologias utilizadas
 * Java 21
 * JDK: Azul Zulu Community version 21.0.4
 * MySQL 8
 * Framework Spring 3.4.0

## 📋 Dependências
 * Lombok
 * Spring Web
 * Spring Boot DevTools
 * Spring Data JPA
 * Flyway Migration
 * MySQL Driver
 * Validation
 * Spring Security

## ⚙️ Configuração
Altere o arquivo de configuração do projeto `application.properties` de sua preferência para testes:
```properties
spring.application.name=forumhub
spring.datasource.url=jdbc:mysql://${HOST:localhost}/${DATABASE:alura_forumhub}
spring.datasource.username=${USERNAME:root}
spring.datasource.password=${PASSWORD:123456}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

jwt.secret=${JWT_SECRET:123456}
jwt.expiration=2
```
Ou crie variáveis de ambiente para não expor dados sensíveis de segurança da sua aplicação em produção

|Variável de embiente| Descrição| Valor default
|--- |--- |--- |
|HOST|Endereço IP do banco de dados MySQL| localhost
|DATABASE|Nome do banco de dados|alura_forumhub
|USERNAME|Nome de usuário do banco de dados| root
|PASSWORD|Senha do banco de dados|123456
|JWT_SECRET|Senha para geração de token JWT|123456

## 📁 Estrutura de pacotes
A estrutura  de pacotes empregada neste projeto foi o **``Package by Feature``**(pacotes por funcionalidades). Esse tipo de estrutura sugere que você deve organizar seu código com base nos recursos individuais da aplicação que você implementa.
```src/
├── main/
│   └── java/
│       └── br/com/forumhub/        
│             └── controller/
│             └── domain/
│                   └── topic
│                   └── user
│             └── infra/
│                   └── security
│                          └── authentication
│                          └── token
│                   └── exception
├── test/
│   └── java/
│       └── br/com/forumhub/
│                  └── 
│  
```` 
## Documentação
 * 📖 Swagger UI available at:/api/v1/swagger-ui/index.html
 * 🔍 OpenAPI docs at:/api/v1/v3/api-docs

### Features para ser implementadas
 * Testes de integridade e unidade
 * Endpoints que permita listar, adicionar, modificar, recuperar e delatar usuários
 * Endpoints que permita listar, modificar, recuperar e deletar respostas
 * Documentação Swagger




