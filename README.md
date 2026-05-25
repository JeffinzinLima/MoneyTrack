# MoneyTrack

API REST desenvolvida em Spring Boot para controle financeiro pessoal.

O sistema permite cadastrar usuários, registrar transações financeiras e consultar relatórios como receitas, despesas e saldo total.

---

# Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Swagger/OpenAPI

---

# Estrutura do Projeto

- controller → endpoints da API
- service → regras de negócio
- repository → acesso ao banco
- model → entidades JPA
- dto → entrada e saída de dados

---

# Entidades

## Usuario
- id
- nome
- email
- senha

## Transacao
- id
- descricao
- valor
- tipo
- categoria

Relacionamento:
- Um usuário possui várias transações.

---

# Endpoints Principais

## Usuários
- POST /usuarios
- GET /usuarios
- PUT /usuarios/{id}
- DELETE /usuarios/{id}

## Transações
- POST /transacoes
- GET /transacoes
- PUT /transacoes/{id}
- DELETE /transacoes/{id}

## Relatórios
- GET /transacoes/receitas
- GET /transacoes/despesas
- GET /transacoes/saldo
- GET /transacoes/categoria/{categoria}
- GET /transacoes/ultimas

---

# Funcionalidades

- CRUD completo de usuários
- CRUD completo de transações
- Relacionamento JPA (1:N)
- DTOs para entrada e saída
- Validação de dados
- Queries nativas SQL
- Documentação Swagger

---

# ▶️ Como Executar

## Clonar o projeto
```bash
git clone URL_DO_REPOSITORIO
