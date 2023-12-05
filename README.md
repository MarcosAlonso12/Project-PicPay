# Project PicPay
Projeto desenvolvido para um atividade na discplina de Linguagem de Programação III

## Linguagem de programação utilizada
* Java

## Banco de dados utilizado
* PostgreSQL

## Documentação

### Tabelas
#### Tabela **users**
| id | name | email | password | amount | userType | identify  |
|----|------|-------|----------|--------|----------|-----------|

#### Tabela **transfers**
| id | payer_id | receiver_id | amount | amount |
|----|----------|-------------|--------|--------|

### Endpoints
### Acesso a informação de um usuário pelo **id**
```GET: {HOST}/users/id```
### Acesso a informação de todos os usuários
```GET: {HOST}/users```
### Criação de um usuário
OBS: Existem 2 tipos de usuários, podendo ser escolhido entre: "*COMMON*" e "*SHOPKEEPER*".  
```POST: {HOST}/users```
```
{
    "name": "user",
    "email": "user@example.com",
    "password": "user123",
    "amount": 1.0,
    "userType": "COMMON",
    "identify": "123.456.789-00"
}
```
### Criação de uma transação
```POST: {HOST}/transaction```
```
{
    "payerId": 1,
    "receiverId": 2,
    "amount": 1.0
}
```
### Alteração das informações de um usuário pelo id
```PUT: {HOST}/users/id```
```
{
    "name": "user",
    "email": "user@example.com",
    "password": "user123",
    "amount": 1.0,
    "userType": "COMMON",
    "identify": "123.456.789-00"
}
```
### Remoção de um usuário pelo id
```DELETE: {HOST}/users/id```
