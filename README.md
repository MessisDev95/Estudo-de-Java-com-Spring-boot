# Olá 😁

## 💻 Introdução ao projeto

Este é um projeto de aprendizado utilizando a linguagem **Java** e o ecossistema **Spring Boot**.

O objetivo principal é **educacional**, com foco no desenvolvimento de habilidades em **back-end**, construção de APIs REST e uso de frameworks modernos.

A aplicação consiste em uma **API de gerenciamento de usuários e tarefas**, onde:

* Um usuário pode criar tarefas
* Cada tarefa está associada a um usuário

Este projeto foi desenvolvido com base em um curso da Rocketseat.

🔗 Link do curso:
https://app.rocketseat.com.br/journey/java-com-spring-boot-curso-introdutorio/overview

---

## 📝 Features

* ✅ Criação de usuários (nome, username e senha)
* ✅ Criação de tarefas com:

  * título
  * descrição
  * prioridade
  * data de criação
  * data de finalização
  * usuário relacionado
* ✅ Listagem de tarefas por usuário
* ✅ Atualização de tarefas
* ✅ Persistência em banco de dados

---
## 📷 Screens



---

## 👨‍💻 Tecnologias / Stack

### 🧠 Linguagem

* **Java**
  Linguagem orientada a objetos amplamente utilizada no desenvolvimento back-end, conhecida por sua robustez e segurança.

---

### ⚙️ Framework

* **Spring Boot**
  Framework que facilita a criação, configuração e execução de aplicações Java e APIs REST.

---

### 🗄️ Banco de Dados

* **H2 Database**
  Banco de dados relacional em memória, ideal para desenvolvimento e testes.

---

## 🔧 Instalação

### 📥 Clonar o repositório

```bash
git clone https://github.com/MessisDev95/Estudo-de-Java-com-Spring-boot.git
```

### ☕ Instalar Java 21 (JDK)

https://www.oracle.com/java/technologies/downloads/#java21

### 📦 Maven

https://maven.apache.org/download.cgi

### 🧪 Postman

https://www.postman.com/downloads/

---

## ⚙️ Como usar

### ▶️ 1. Executar o projeto

Execute a classe principal:

```
TodolistApplication.java
```

---

### 🌐 2. Testar a API (Postman)

#### 👤 Criar usuário

**POST** `http://localhost:8080/users/`

```json
{
  "name": "Marcos",
  "username": "marcos",
  "password": "5555"
}
```

---

#### 📝 Criar tarefa

**POST** `http://localhost:8080/tasks/`

> 🔐 Utilize autenticação com usuário e senha cadastrados

```json
{
  "description": "Teste de criação de tarefa",
  "title": "Requisição 1",
  "priority": "Média",
  "createdAt": "2026-10-22T23:30:00",
  "endedAt": "2026-12-22T23:30:00",
  "userId": ""
}
```

---

#### 📋 Listar tarefas

**GET** `http://localhost:8080/tasks/`

---

#### ✏️ Atualizar tarefa

**PUT** `http://localhost:8080/tasks/{id}`

```json
{
  "description": "",
  "title": "",
  "priority": "",
  "createdAt": "",
  "endedAt": ""
}
```

---

#### 🗄️ Acessar banco H2

Acesse:

```
http://localhost:8080/h2-console/
```

Utilize as credenciais definidas em `application.properties`.

---

## 📁 Estrutura do Projeto

```
src/
 └── main/
     ├── java/
     │    └── 95/Dev/Messis/todolist/
     │         ├── controller   # Endpoints da API
     │         ├── errors       # Tratamento de exceções
     │         ├── filter       # Filtros (autenticação, etc.)
     │         ├── task         # Entidades e lógica de tarefas
     │         ├── user         # Entidades e lógica de usuários
     │         └── utils        # Classes utilitárias
     └── resources/
          ├── application.properties
          ├── static
          └── templates
```

---

## 📄 Licença

Projeto com finalidade educacional.

---

## 👨‍💻 Autor

Desenvolvido por **Messis_Dev95** inspirado em projeto de https://github.com/Rocketseat
