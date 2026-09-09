# PantryFit

> Sistema para gestão de refeições, controle nutricional e gerenciamento de estoque do pantry.

[![Java](https://img.shields.io/badge/Java-17%2B-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15%2B-blue.svg)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/Docker-Enabled-blue.svg)](https://www.docker.com/)

---

## 1.1 Objetivo do sistema

O PantryFit tem como objetivo principal integrar a gestão de refeições com o controle de estoque do pantry em um ambiente doméstico ou de uso pessoal. O sistema permite que os usuários cadastrem alimentos disponíveis, acompanhem os níveis de estoque, registrem o consumo e calculem informações nutricionais associadas às refeições.

A meta central é reduzir a fragmentação entre dois processos que normalmente são tratados separadamente: a gestão do inventário da cozinha e o acompanhamento da alimentação. Dessa forma, o usuário consegue manter uma visão mais completa do que está disponível em casa, do que é consumido e como isso afeta sua dieta e suas necessidades nutricionais.

Além disso, o sistema funciona como uma solução acadêmica e de portfólio, permitindo a aplicação de conceitos de engenharia de software, arquitetura de sistemas, persistência em banco de dados, desenvolvimento em Java com Spring Boot e boas práticas de desenvolvimento e testes.

---

## 1.2 Escopo do desenvolvimento do sistema e stakeholders

### Escopo do sistema

O sistema será responsável por:

- cadastrar e manter itens do pantry;
- registrar entradas e saídas de produtos;
- acompanhar o nível de estoque dos alimentos;
- registrar refeições e seus ingredientes/receitas;
- associar cada refeição aos itens utilizados;
- calcular calorias e macronutrientes;
- atualizar automaticamente o estoque com base no consumo;
- disponibilizar dados para consulta e histórico.

### Fora do escopo inicial

No início do desenvolvimento, o sistema não inclui:

- autenticação e autorização de usuários;
- múltiplos perfis de usuário com diferentes permissões;
- uma interface gráfica completa;
- integração com APIs externas de nutrição;
- suporte para produção em nuvem;
- análise avançada de consumo e dashboards complexos.

### Stakeholders

As principais pessoas envolvidas no desenvolvimento e uso do sistema incluem:

- Usuário final: pessoa que registra alimentos, controla o inventário e acompanha as refeições;
- Desenvolvedor/engenheiro de software: responsável pela implementação, manutenção e evolução do sistema;
- Tutor/professor ou orientador: acompanha o desenvolvimento acadêmico e a aplicação dos conceitos de engenharia de software;
- Futuros interessados: nutricionista, gestor de alimentação ou equipe de apoio à saúde, caso o sistema seja expandido.

---

# Parte II: Visão geral do sistema

## 2.1 Visão e objetivos do sistema

O PantryFit é uma aplicação que combina o gerenciamento de itens domésticos com o acompanhamento nutricional. A visão do sistema é permitir que o usuário tenha uma visão integrada entre a cozinha e a alimentação, reduzindo erros manuais, melhorando o controle do estoque e simplificando o registro de refeições.

### Objetivos gerais

- controlar os itens alimentares disponíveis em estoque;
- registrar refeições e ingredientes usados;
- manter histórico de consumo;
- calcular informações nutricionais por refeição e por período;
- manter consistência entre a alimentação e o inventário.

### Objetivos específicos

- registrar itens alimentares com categoria e unidade de medida;
- controlar quantidades disponíveis;
- registrar entradas e ajustes de estoque;
- associar ingredientes às refeições;
- calcular calorias, proteínas, carboidratos e gorduras;
- atualizar automaticamente o estoque ao registrar o consumo.

---

## 2.2 Contexto e limites do sistema

O sistema está inserido em um contexto doméstico e pessoal, em que o usuário precisa controlar alimentos, refeições e hábitos nutricionais sem depender de processos fragmentados e administrados manualmente.

O PantryFit atua como uma ferramenta de apoio para organizar a cozinha e o consumo alimentar. Ele desempenha um papel central em manter o controle do que existe em estoque e do que é usado ao longo do dia.

### Limites do sistema

- o sistema é voltado para um ambiente de uso individual ou doméstico;
- a solução inicial prioriza backend e lógica de negócio;
- persistência e regras de negócio são priorizadas em relação à interface visual;
- a aplicação depende de um banco de dados estruturado e de regras de integridade para garantir consistência;
- a solução não inclui, em sua etapa inicial, integração com marketplaces, compras automáticas ou autenticação avançada.

---

## 2.3 Estrutura geral do sistema

A arquitetura do sistema será organizada em camadas para facilitar manutenção, escalabilidade e testabilidade.

```text
src/
├── main/
│   ├── java/
│   │   ├── controller/     # Endpoints e APIs REST
│   │   ├── service/        # Regras de negócio
│   │   ├── repository/     # Acesso a dados
│   │   ├── model/          # Entidades do domínio
│   │   ├── dto/            # Objetos de transferência de dados
│   │   └── exception/      # Tratamento de erros
│   │
│   └── resources/
│       ├── application.properties
│       └── static/         # Arquivos estáticos
│
└── test/
    └── java/
        └── ...              # Testes unitários e de integração
```

### Componentes principais

- Gestão de itens do pantry;
- Gestão de estoque;
- Gestão de refeições;
- Cálculo nutricional;
- Integração entre estoque e consumo;
- Persistência de dados em banco relacional;
- API para comunicação com clientes e futuros frontends.

---

## 2.4 Características do usuário

Os usuários esperados do sistema são pessoas interessadas em organizar sua alimentação e controlar o que têm em casa. O perfil principal é uma pessoa que deseja manter registros simples, porém consistentes, sobre alimentos, consumo e nutrição.

### Perfil do usuário

- usuário doméstico ou pessoa que prepara refeições em casa;
- interesse em controlar compras e estoque;
- desejo de acompanhar calorias e macronutrientes;
- uso frequente de tecnologia e hábitos digitais;
- necessidade de organização e clareza na gestão de alimentos.

### Nível de experiência

- o sistema deve ser intuitivo e fácil de usar;
- a interface deve minimizar a necessidade de treinamento aprofundado;
- a operação principal deve ser simples, rápida e prática;
- os dados devem ser exibidos de forma clara para facilitar a análise do consumo.

---

# Parte III: Requisitos do sistema

## 3.1 Por subsistema/componente

### 3.1.1 Subsistema de gestão de alimentos

O subsistema de alimentos é responsável por registrar os itens disponíveis no sistema, suas categorias, quantidades e unidades de medida. Ele deve permitir o cadastro de produtos básicos, consulta de itens existentes e manutenção de informações essenciais para o controle do estoque.

### 3.1.2 Subsistema de estoque

O subsistema de estoque deve controlar entradas, saídas e ajustes de quantidade. Esse módulo deve garantir que o saldo disponível seja atualizado conforme a operação realizada e que o histórico de movimentação seja preservado.

### 3.1.3 Subsistema de refeições

Este módulo deve permitir o registro de refeições, a associação de ingredientes e quantidades consumidas e a manutenção de um histórico de registros. Também deve permitir identificar a alimentação em diferentes momentos do dia, como café da manhã, almoço, jantar ou lanche.

### 3.1.4 Subsistema nutricional

O módulo nutricional deve calcular o valor energético e os macronutrientes de cada refeição, além de facilitar a consulta de dados por período. O cálculo deve considerar os valores nutricionais dos ingredientes e a quantidade utilizada.

### 3.1.5 Subsistema de integração

A integração entre o inventário e as refeições deve garantir que o consumo de ingredientes reduza o estoque correspondente, mantendo consistência entre o que foi consumido e o que permanece disponível.

---

## 3.2 Requisitos funcionais, requisitos de qualidade e restrições

### Requisitos funcionais

- RF01: o sistema deve permitir o cadastro de alimentos;
- RF02: o sistema deve registrar a unidade de medida e a categoria do alimento;
- RF03: o sistema deve controlar a quantidade disponível em estoque;
- RF04: o sistema deve permitir operações de entrada e saída de produtos;
- RF05: o sistema deve registrar refeições com data e tipo de refeição;
- RF06: o sistema deve associar ingredientes e quantidades às refeições;
- RF07: o sistema deve calcular as calorias da refeição;
- RF08: o sistema deve calcular os macronutrientes da refeição;
- RF09: o sistema deve atualizar automaticamente o estoque quando uma refeição é registrada;
- RF10: o sistema deve fornecer um histórico de refeições e movimentações de estoque;
- RF11: o sistema deve permitir consultas de dados por período e categoria;
- RF12: o sistema deve garantir consistência entre os dados de estoque e consumo.

### Requisitos de qualidade

- QR01: a aplicação deve ser fácil de manter e evoluir;
- QR02: o código deve seguir boas práticas de organização e arquitetura;
- QR03: o sistema deve manter a integridade dos dados em operações críticas;
- QR04: a aplicação deve responder rapidamente nas operações mais comuns;
- QR05: o sistema deve ser testável por meio de testes automatizados;
- QR06: a solução deve ser compatível com ambientes de desenvolvimento e teste via Docker.

### Restrições

- R01: o sistema será implementado em Java com Spring Boot;
- R02: o banco de dados principal será PostgreSQL;
- R03: o projeto deve seguir uma organização em camadas do backend;
- R04: o ambiente de execução pode ser configurado com Docker e Docker Compose;
- R05: a solução inicial prioriza as camadas de aplicação e persistência, sem foco em frontend complexo;
- R06: a aplicação deve respeitar regras de integridade para evitar inconsistências em estoque e consumo.

---

## 3.3 Interfaces

### Interfaces de usuário

A solução inicial pode ser acessada por meio de endpoints HTTP, com futuras interfaces web ou mobile sendo adicionadas conforme o projeto evolui. A interface de uso deve facilitar o registro de alimentos, refeições e consultas de histórico.

### Interfaces de sistema

- API REST para cadastro e consulta de alimentos;
- API REST para registro de refeições e registros de consumo;
- Comunicação com banco de dados relacional;
- Integração interna entre módulos de estoque e nutrição;
- Possível integração futura com frontend e serviços externos.

### Interfaces de comunicação

O sistema deve usar padrões de comunicação simples e consistentes, com JSON como formato principal de troca de dados entre cliente e servidor. A arquitetura do backend deve separar a camada de apresentação da lógica de negócio e da persistência.

---

## Referências

- Spring Boot Documentation. Disponível em: https://spring.io/projects/spring-boot
- Java Documentation. Disponível em: https://docs.oracle.com/en/java/
- PostgreSQL Documentation. Disponível em: https://www.postgresql.org/docs/
- Docker Documentation. Disponível em: https://docs.docker.com/
- Material de apoio em Engenharia de Software e arquitetura de sistemas.

## Documentação do projeto

- Índice da documentação: [docs/README.md](docs/README.md)
- README principal em inglês: [README.md](README.md)
- README principal em português: [README.pt-BR.md](README.pt-BR.md)
- Documentação em inglês: [docs/en/README.md](docs/en/README.md)
- Documentação em português: [docs/pt-BR/README.md](docs/pt-BR/README.md)
- Glossário em inglês: [GLOSSARY.md](GLOSSARY.md)
- Glossário em português: [docs/pt-BR/GLOSSARIO.md](docs/pt-BR/GLOSSARIO.md)

---

## Resumo

O PantryFit é uma solução de software focada na gestão integrada de alimentos, estoque e nutrição. O projeto busca combinar práticas domésticas de organização com análise de alimentação, promovendo um melhor controle do que existe em casa e do que é consumido ao longo do dia. A estrutura, os requisitos e a visão geral do sistema foram organizados conforme o modelo exigido para documentação de arquitetura e requisitos.
