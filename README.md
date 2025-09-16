# AuthAPI

API de autenticação simples com **Spring Boot**.  
Permite criar usuários (registro) e realizar login.

## Tecnologias
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database (em memória, futuramente pode trocar para MySQL/PostgreSQL)
- Maven

## Como rodar
1. Clone o repositório:
```bash
git clone https://github.com/nuneszxd/authapi.git
```
2. Abra na sua IDE Java


3. Rode a classe princial:
AuthapiApplication.java

4. A API estará disponível em:
```bash
http://localhost:8080
```

## Endpoints
- POST /api/auth/register
- RequestBody (JSON):
```bash
{
  "name": "Matheus",
  "email": "teste@teste.com",
  "password": "123456"
}
```

- Response: JSON do usuário criado, incluindo id, name, email.

## Login
- POST /api/auth/login
- RequestBody (JSON):
```bash
{
  "email": "teste@teste.com",
  "password": "123456"
}
```

- Response:
```bash
    "Login realizado com sucesso!"
```

- Erros possíveis:
- 404 NOT FOUND → usuário não encontrado
- 401 UNAUTHORIZED → senha incorreta

## Contato

- Matheus Nunes
- Email: matheusnuneszx@gmail.com
- GitHub: https://github.com/nuneszxd
