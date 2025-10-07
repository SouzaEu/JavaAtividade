# Spring Boot RabbitMQ Demo

Projeto Spring Boot demonstrando integração com RabbitMQ para mensageria assíncrona.

## Pré-requisitos

- Java 17+
- Docker e Docker Compose
- cURL ou Postman para testes

## Como executar

### 1. Subir o RabbitMQ
```bash
docker compose up -d
```

### 2. Executar a aplicação
```bash
./gradlew bootRun
```

### 3. Testar a aplicação

**Enviar mensagem:**
```bash
curl -X POST http://localhost:8080/orders \
  -H "Content-Type: application/json" \
  -d '{
    "orderId": "order-001",
    "clientId": "client-123",
    "items": [
      {"productId":"prod-1", "quantity":2},
      {"productId":"prod-2", "quantity":1}
    ]
  }'
```

## Verificações

- **Logs da aplicação**: Deve mostrar "Published OrderCreatedMessage" e "Received OrderCreatedMessage"
- **RabbitMQ UI**: http://localhost:15672 (guest/guest)
- **Filas**: Verificar `order.queue` e `order.exchange`

## Estrutura do projeto

```
src/main/java/com/exemplo/
├── RabbitDemoApplication.java          # Classe principal
├── rabbitmq/config/RabbitConfig.java   # Configuração RabbitMQ
├── model/
│   ├── OrderCreatedMessage.java        # Record da mensagem
│   └── OrderItem.java                  # Record do item
├── service/OrderPublisher.java         # Publisher de mensagens
├── controller/OrderController.java     # REST Controller
└── consumer/OrderConsumer.java         # Consumer de mensagens
```

## Troubleshooting

Se houver erro de desserialização com records, substitua por classes POJO com getters/setters.
