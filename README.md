# Desafio programação - para vaga desenvolvedor

## Stack utilizada

- Java 11
- Maven
- Postgresql (heroku)
- Spring Boot
    - Spring Data JPA
- Lombok
- React
## Como executar o projeto

### API Via Docker

Pela linha de commando, navegue até o diretório ```api``` e execute nesta ordem:

```mvn clean package```

```docker build --tag=api:latest .```

```docker-compose up```
###

### Front end
Pela linha de commando, navegue até o diretório ```web``` e execute:

```npm start```


