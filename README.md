# Sobre o projeto
O projeto é uma aplicação web focado na construção de uma arquitetura back end que é responsável por gerenciar os componentes de pedidos nas compras do cliente
# Entidades do projeto
![image](https://user-images.githubusercontent.com/108245169/218842431-c6df8625-9894-47f2-bfe4-6d28f72a41ac.png)
# Tecnologias utilizadas
* Java
* Spring Boot
* JPA / Hibernate
* Maven
* H2 Database
* Postman
# Arquitetura
Há três principais camadas de arquitetura:
* Resources
* Services
* Repositories
# Executar o projeto
Pré-requisitos:
* Java 17
* Postman
```bash
git clone https://github.com/GutscheWilly/web-services-spring-boot.git

./mvnw spring-boot:run
```
# Usando o Postman
É possível realizar as operações de GET, POST, DELETE e UPDATE para cada um dos paths:
* http://localhost:8080/users
* http://localhost:8080/orders
* http://localhost:8080/products
* http://localhost:8080/categories

* Para as operações de GET, DELETE ou UPDATE pode-se adicionar ao final de cada path o id desejado: /{id}
# H2 Database
Para consultar as tabelas do banco de dados H2 acesse:
* http://localhost:8080/h2-console
* Obs: modifique a JDBC URL para jdbc:h2:mem:testdb
# Autor
Willy Thiago Gutsche
