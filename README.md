# F�rumHub
O F�rumHub � o ambiente onde replica o processo no n�vel back end no qual participantes de uma plataforma de cursos  podem tirar suas d�vidas sobre os cursos em que est�o participando.

![Badge em Desenvolviment](http://img.shields.io/static/v1?label=STATUS&message=Em%20Desenvolvimento&color=yellow&style=for-the-badge)
![Badge em Desenvolviment](http://img.shields.io/static/v1?label=&message=java&color=red&style=for-the-badge)
![Badge em Desenvolviment](http://img.shields.io/static/v1?label=&message=Spring&color=green&style=for-the-badge)
![Badge em Desenvolviment](http://img.shields.io/static/v1?label=&message=MySQL%208&color=blue&style=for-the-badge)
## ? Funcionalidades
 * ``Criar novo t�pico:`` permite o usu�rio publicar um novo t�pico enviando um `body request`
 * ``Mostrar todos os t�picos criados:`` permite listar todos os t�picos j� publicados de forma paginada 
 * ``Mostrar topico espec�fico:`` permite detalhar um t�pico em espec�fico atrav�s de um ID espec�fico
 * ``Atualizar t�pico:`` permite atualizar um t�pico por meio de um ID e um `body request`
 * ``Eliminar t�pico:`` permite eliminar de forma f�sica um t�pico atrav�s de um ID espec�fico

## ? Tecnologias utilizadas
 * Java 21
 * JDK: Azul Zulu Community version 21.0.4
 * MySQL 8
 * Framework Spring 3.3.5

## ? Depend�ncias
 * Lombok
 * Spring Web
 * Spring Boot DevTools
 * Spring Data JPA
 * Flyway Migration
 * MySQL Driver
 * Validation
 * Spring Security

## ?? Configura��o
Altere o arquivo de configura��o do projeto `application.properties` de sua prefer�ncia:
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





