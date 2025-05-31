# 📦 Empacotamento - API

Este microserviço em Java com Spring Boot automatiza o empacotamento de pedidos, a API recebe uma lista de produtos com dimensões, escolhe as caixas ideais para embalar cada pedido e informa quais produtos foram colocados em quais caixas, otimizando o espaço utilizado

---

## ✅ Funcionalidades

- Recebe uma lista de pedidos com produtos e suas dimensões
- Empacota automaticamente os produtos nas caixas disponíveis
- Retorna quais produtos foram colocados em quais caixas
- Informa quando um produto não cabe em nenhuma caixa
- API documentada com Swagger
- Pronto para execução com Docker Compose

---

## 📦 Caixas disponíveis

| Caixa    | Altura (cm) | Largura (cm) | Comprimento (cm) |
|----------|-------------|--------------|------------------|
| Caixa 1  | 30          | 40           | 80               |
| Caixa 2  | 80          | 50           | 40               |
| Caixa 3  | 50          | 80           | 60               |

---

## 🔧 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Springdoc OpenAPI (Swagger)
- Docker & Docker Compose
- Maven

---

## 🚀 Como executar com Docker Compose

### 📁 1. Clone o repositório

```bash
git clone https://github.com/gabrielprog/Empacotamento.git
cd Empacotamento
```

### 🛠 2. Compile o projeto

```bash
./mvnw clean package -DskipTests
```

### 🐳 3. Execute com Docker Compose

```bash
docker compose up --build
```

A aplicação estará disponível em: http://localhost:8080

---

## 🔍 Documentação da API (Swagger)

Após a aplicação subir, acesse:

👉 http://localhost:8080/swagger-ui.html

---

## 📬 Endpoint principal

### `POST /api/empacotar`

### 📥 Exemplo de entrada

```json
{
  "pedidos": [
    {
      "pedido_id": 1,
      "produtos": [
        {
          "produto_id": "PS5",
          "dimensoes": {
            "altura": 40,
            "largura": 10,
            "comprimento": 25
          }
        },
        {
          "produto_id": "Volante",
          "dimensoes": {
            "altura": 40,
            "largura": 30,
            "comprimento": 30
          }
        }
      ]
    }
  ]
}
```

---

### 📤 Exemplo de saída

```json
{
  "pedidos": [
    {
      "pedido_id": 1,
      "caixas": [
        {
          "caixa_id": "Caixa 2",
          "produtos": ["PS5", "Volante"],
          "observacao": null
        }
      ]
    },
    {
      "pedido_id": 5,
      "caixas": [
        {
          "caixa_id": null,
          "produtos": ["Cadeira Gamer"],
          "observacao": "Produto não cabe em nenhuma caixa disponível."
        }
      ]
    }
  ]
}
```

---

## 🧪 Rodando os testes

Caso deseje rodar os testes unitários (se houver):

```bash
./mvnw test
```

---

## 🔒 Autenticação

Este projeto está preparado para futura inclusão de autenticação (por exemplo, com Spring Security + JWT). Por padrão não exige autenticação

---

## 📁 Estrutura esperada no projeto

```
src
├── main
│   ├── java/br/com/empacotamento/Empacotamento/
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── model/
│   │   └── service/
│   └── resources/
```

---

## 📝 Licença

Este projeto está licenciado sob a licença MIT, consulte o arquivo `LICENSE` para mais detalhes
