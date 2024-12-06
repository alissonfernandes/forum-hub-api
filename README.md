# FórumHub
O FórumHub é o ambiente onde replica o processo no nível back end no qual participantes de uma plataforma de cursos  podem tirar suas dúvidas sobre os cursos em que estão participando.

![Badge em Desenvolviment](http://img.shields.io/static/v1?label=STATUS&message=Em%20Desenvolvimento&color=yellow&style=for-the-badge)
![Badge em Desenvolviment](http://img.shields.io/static/v1?label=&message=java&color=red&style=for-the-badge)
![Badge em Desenvolviment](http://img.shields.io/static/v1?label=&message=Spring&color=green&style=for-the-badge)
![Badge em Desenvolviment](http://img.shields.io/static/v1?label=&message=MySQL%208&color=blue&style=for-the-badge)
## ? Funcionalidades
 * ``Criar novo tópico:`` permite o usuário publicar um novo tópico enviando um `body request`
 * ``Mostrar todos os tópicos criados:`` permite listar todos os tópicos já publicados de forma paginada 
 * ``Mostrar topico específico:`` permite detalhar um tópico em específico através de um ID específico
 * ``Atualizar tópico:`` permite atualizar um tópico por meio de um ID e um `body request`
 * ``Eliminar tópico:`` permite eliminar de forma física um tópico através de um ID específico

## ? Tecnologias utilizadas
 * Java 21
 * JDK: Azul Zulu Community version 21.0.4
 * MySQL 8
 * Framework Spring 3.3.5

## ? Dependências
 * Lombok
 * Spring Web
 * Spring Boot DevTools
 * Spring Data JPA
 * Flyway Migration
 * MySQL Driver
 * Validation
 * Spring Security

## ?? Configuração
Altere o arquivo de configuração do projeto `application.properties` de sua preferência:
```properties
spring.application.name=forumhub
spring.datasource.url=jdbc:mysql://localhost/alura_forumhub
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

jwt.secret=${JWT_SECRET:123456}
jwt.expiration=2
```





