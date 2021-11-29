## Desafio Interest Rates IBM

> Projeto com o objetivo de ler, salvar e apresentar o acúmulo de dados da taxa SELIC disponibilizadas pelo Banco Central.

Através dos dados de Taxa SELIC disponibilizados pelo Banco Central, esse projeto é formulado com o desígnio de gerar 
uma API que tenha a capacidade de ler, salvar e apresentar esses dados acumulados, também de forma anual ao cliente.
Assim como disponibilizar o acesso à ferramentas de buscas e afins desses dados.

As **Dependências de Desenvolvimento**, assim como os detalhes do **Ambiente de Desenvolvimento** e sua ordem de execução são explicitados abaixo.

---

## 🧰 Dependências de Desenvolvimento

- [JDK17](https://www.java.com/pt-BR/)
- [IntelliJ](https://www.jetbrains.com/pt-br/idea/)
- [H2](https://www.h2database.com/html/main.html)
- [Maven](https://maven.apache.org/what-is-maven.html)
- [SpringBoot](https://spring.io/projects/spring-boot)
- [Swagger](https://swagger.io/)
- [Postman](https://www.postman.com/)

## ⚙️Ambiente de Desenvolvimento

<!--ts-->
* Após clonar o projeto que consta nesse repositório, rode o seguinte comando no terminal da IDE:

``
mvn clean install
``

* Na IDE, rode a classe principal **SelicApplication** no diretório:

``
br.com.ibm.training.javatraining
``

* Após acessar o banco de dados "H2 database" pelo URL:

``
http://localhost:8082/
``

* Utilize as seguintes configurações:


    * Driver Class: org.h2.Driver

    * JDBC URL: jdbc:h2:mem:app

    * User Name: sa

    * Password:


* Após o acesso ao banco de dados, pode-se testar a aplicação pelo Postman utilizando a URL abaixo como base para os possíveis comandos:

``
http://localhost:8082/v1/taxaselic/
``

* Através da URL abaixo, pode-se acessar a documentação contendo os endpoints no **Swagger**:

``
http://localhost:8082/swagger-ui.html#/selic-controller``

---

✔️ Developed by Pedro El-Khouri `pedroelkhouri@ibm.com`

