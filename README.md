MoneyTrack

API REST desenvolvida com Spring Boot para gerenciamento financeiro pessoal. O sistema permite cadastrar usuários, registrar transações financeiras e consultar informações analíticas sobre receitas, despesas e saldo.

Sobre o Projeto

O MoneyTrack foi desenvolvido com o objetivo de facilitar o controle financeiro de usuários por meio de uma API REST estruturada em camadas, seguindo boas práticas de desenvolvimento de software.

A aplicação permite:

- Gerenciamento de usuários;
- Controle de receitas e despesas;
- Organização de transações por categoria;
- Consultas financeiras personalizadas;
- Validação de dados de entrada;
- Documentação automática via Swagger.

Arquitetura

O projeto segue uma arquitetura em camadas:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Banco de Dados
```

Camadas

Controller
Responsável por receber as requisições HTTP e retornar as respostas da API.

Service
Contém as regras de negócio da aplicação.

Repository
Responsável pela comunicação com o banco de dados utilizando Spring Data JPA.

Model
Representa as entidades persistidas no banco.

DTO
Objetos utilizados para entrada e saída de dados da API.

Modelo de Dados

Usuario

| Campo | Tipo |
|---------|---------|
| id | Long |
| nome | String |
| email | String |
| senha | String |

Transacao

| Campo | Tipo |
|---------|---------|
| id | Long |
| descricao | String |
| valor | Double |
| tipo | String |
| categoria | String |


Relacionamento

Um usuário pode possuir várias transações.

```text
Usuario (1)
      |
      |
      └─────── (N) Transacao
```

Relacionamento implementado utilizando JPA (`OneToMany` e `ManyToOne`).

Funcionalidades

Gestão de Usuários

- Criar usuário
- Listar usuários
- Atualizar usuário
- Excluir usuário

Gestão de Transações

- Criar transação
- Listar transações
- Atualizar transação
- Excluir transação

Relatórios Financeiros

- Consultar receitas
- Consultar despesas
- Consultar saldo total
- Buscar por categoria
- Visualizar últimas transações

DTOs

TransacaoRequestDTO

Utilizado para receber os dados enviados pelo cliente.

TransacaoResponseDTO

Utilizado para retornar os dados da transação ao cliente.

Validações

O projeto utiliza Bean Validation para garantir integridade dos dados.

Principais anotações utilizadas:

- `@NotBlank`
- `@NotNull`
- `@Positive`
- `@Valid`

Usuários

| Método | Endpoint |
|----------|----------|
| POST | /usuarios |
| GET | /usuarios |
| PUT | /usuarios/{id} |
| DELETE | /usuarios/{id} |

Transações

| Método | Endpoint |
|----------|----------|
| POST | /transacoes |
| GET | /transacoes |
| PUT | /transacoes/{id} |
| DELETE | /transacoes/{id} |

Consultas Financeiras

| Método | Endpoint |
|----------|----------|
| GET | /transacoes/receitas |
| GET | /transacoes/despesas |
| GET | /transacoes/saldo |
| GET | /transacoes/categoria/{categoria} |
| GET | /transacoes/ultimas |

A API pode ser testada utilizando:

- Swagger UI
- Postman

Tecnologias Utilizadas
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- Banco de Dados Relacional
- Swagger/OpenAPI

O projeto possui:

- Diagrama de Casos de Uso
- Diagrama de Classes

Demonstrar a construção de uma API REST utilizando Spring Boot, aplicando conceitos de:

- Arquitetura em camadas
- Persistência de dados
- Relacionamentos JPA
- DTOs
- Validações
- Consultas personalizadas
- Documentação de APIs
