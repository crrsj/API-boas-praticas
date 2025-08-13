API de Produtos
Esta é uma API RESTful para gerenciamento de produtos, desenvolvida com Spring Boot. A aplicação foi construída com foco em boas práticas de desenvolvimento, segurança e manutenibilidade.

🛠️ Tecnologias e Padrões de Projeto
A API utiliza um conjunto moderno de tecnologias e segue padrões de projeto consolidados para garantir um código robusto e de alta qualidade:

Padrão MVC: A arquitetura segue o padrão Model-View-Controller, com camadas de Controller (para a API), Service (para a lógica de negócio) e Repository (para o acesso a dados), garantindo a separação de responsabilidades.

Boas Práticas de Código:

Data Transfer Objects (DTOs): Utilizados para transferir dados entre as camadas da aplicação, desacoplando as entidades do banco de dados das requisições e respostas da API.

Validação de Dados: Os DTOs são validados com anotações de Jakarta Validation (@Valid, @NotBlank, etc.), garantindo a integridade dos dados desde a entrada na aplicação.

Tratamento de Exceções: A API utiliza um sistema centralizado de tratamento de exceções (@RestControllerAdvice) para retornar respostas de erro consistentes e claras.

Persistência de Dados:

Spring Data JPA: Simplifica o acesso a dados, permitindo a criação de repositórios robustos com o mínimo de código.

PostgreSQL com Docker: O banco de dados PostgreSQL é gerenciado via Docker, o que facilita o ambiente de desenvolvimento e garante que todos os desenvolvedores usem a mesma configuração de banco de dados.

Mapeamento de Objetos:

ModelMapper: Uma biblioteca que simplifica o mapeamento entre DTOs e entidades, reduzindo a quantidade de código boilerplate.

Segurança e Autenticação:

Spring Security: Framework de segurança padrão do ecossistema Spring para autenticação e autorização.

JWT (JSON Web Tokens): Implementado para criar um sistema de autenticação stateless (sem sessão), ideal para APIs REST.

Documentação e Testes:

Swagger/OpenAPI 3: A API possui documentação automática e interativa com Swagger UI, disponível no endpoint /swagger-ui.html. Isso facilita a exploração e o teste de todos os endpoints.
