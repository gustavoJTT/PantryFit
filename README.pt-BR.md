# PantryFit

> Sistema para gestão de refeições, controle nutricional e gerenciamento de estoque do pantry.

[![Java](https://img.shields.io/badge/Java-21%2B-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-green.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15%2B-blue.svg)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/Docker-Enabled-blue.svg)](https://www.docker.com/)

O PantryFit é um sistema desenvolvido para integrar o gerenciamento do estoque do pantry com o registro de refeições e a análise nutricional.

## Objetivo do projeto

O projeto conecta os alimentos disponíveis em casa ao que é consumido ao longo do dia. A proposta é apoiar o cadastro de alimentos, o controle de estoque, o registro de refeições e o acompanhamento nutricional em um único sistema.

O PantryFit também é um projeto acadêmico e de portfólio, com foco em engenharia de software, Java, Spring Boot, PostgreSQL, arquitetura em camadas, Docker e testes automatizados.

## Principais funcionalidades

- Cadastro e categorização de alimentos;
- Controle do estoque do pantry;
- Registro de entradas, saídas e ajustes de inventário;
- Registro de refeições com ingredientes e quantidades;
- Cálculo de calorias e macronutrientes;
- Atualização automática do estoque com base no consumo;
- Histórico de refeições e movimentações do estoque.

## Tecnologias

- Java 21 ou superior;
- Spring Boot 4.1.1;
- Maven;
- PostgreSQL;
- Docker e Docker Compose.

## Documentação

- [Índice da documentação](docs/README.md)
- [Documento de visão do sistema](docs/pt-BR/VISAO.md)
- [System vision document](docs/en/VISION.md)
- [Glossário em português](docs/pt-BR/GLOSSARIO.md)
- [Glossary in English](docs/en/GLOSSARY.md)
- [README do projeto em inglês](README.md)

## Status atual

O projeto está nos estágios iniciais de desenvolvimento. A documentação, a estrutura do backend, as regras de negócio e a camada de persistência estão sendo organizadas progressivamente.

## Como executar

Requisitos:

- Java 21 ou superior;
- Maven ou o Maven Wrapper;
- Docker e Docker Compose.

Execute a aplicação localmente com:

```bash
./mvnw spring-boot:run
```

## Licença

A licença do projeto ainda não foi definida.
