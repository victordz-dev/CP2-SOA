# 📦 Checkpoint 2 - Order Management API

Este projeto é uma API REST desenvolvida para o gerenciamento de pedidos, focada em demonstrar boas práticas de arquitetura, segurança de credenciais e persistência de dados.

## 🚀 Tecnologias Utilizadas

- Java 25

- Spring Boot

- Spring Data JPA

- MySQL

- Maven
## ⚙️ Configuração do Banco de Dados

O projeto utiliza a estratégia de **Externalized Configuration** do Spring. Isso permite que as credenciais sensíveis fiquem isoladas do código-fonte.
1. Requisitos
   - MySQL Server rodando localmente (ou via Docker).
   - Um banco de dados criado com o nome: db_cp2
```sql
CREATE DATABASE db_cp2;
```
2. Configuração Local

    Para desenvolvimento, criamos um arquivo que não é enviado ao GitHub (protegido via `.gitignore`).
Crie o arquivo `application-local.properties` em `src/main/resources` com o seguinte conteúdo, substituindo as variaveis `${variavel}` pelas suas configurações do banco:

```properties
#retire essa linha caso altere o arquivo application.properties
spring.profiles.active=local
spring.application.name=checkpoint2
server.port=${SERVER_PORT}

spring.datasource.url=jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}

spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver

spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## 🛠️ Como Executar

1. **Ativar o Perfil:** Certifique-se de que a linha `spring.profiles.active=local` está presente no seu application.properties principal.

2. **Rodar via Maven:**
    ```bash
    ./mvnw spring-boot:run
    ```
3. **Acessar a API:** A base URL será http://localhost:8085/orders.

## 📍 Endpoints Principais

| Método | EndPoint | Descrição |
| :-------| :--------| :---------|
| **GET** |`/orders` | Lista todos os pedidos |
| **GET** |`/orders/{id}` | Lista o pedido com base no ID |
| **POST** |`/orders` | Cria um novo pedido |
| **PUT** |`/orders/{id}` | Atualiza um pedido existente |
| **DELETE** |`/orders/{id}` | Deleta um pedido existente |

## 🧪 Testes de API (Insomnia)

Para facilitar a correção e o teste das rotas, disponibilizamos uma Collection do Insomnia na raiz do repositório.
- Arquivo: `Insomnia_2026-04-22.yaml`
- **Como usar:** Basta baixar o arquivo e importá-lo no seu Insomnia ou Postman para ter acesso a todas as requisições configuradas.

## 👨‍💻 Integrantes

| Nome | RM |
| :----------------- | :----- |
| Guilherme Oliveira | 558797 |
| Matheus Dantas     | 558804 |
| Rafael Panhoca     | 555014 |
| Silas Alves        | 555020 |
| Victor Rodriguez   | 559094 |