# Sobre o projeto
O projeto é uma aplicação web focada na construção de uma arquitetura back-end que é responsável por gerenciar os componentes dos pedidos de um cliente no processo de compra de produtos

# Entidades do projeto
<p>
  <img src="https://user-images.githubusercontent.com/108245169/219289355-ef45b596-16b1-4ac9-b167-32b53f094e47.png" img>
</p>

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
// Clonar repositório
git clone https://github.com/GutscheWilly/web-services-spring-boot.git

// Executar a aplicação
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
