# PantryFit System Vision Document

> System for meal management, nutritional tracking, and pantry inventory management.

## 1.1 Objective of the system

PantryFit has as its main objective to integrate meal management with pantry inventory control in a domestic or personal use environment. The system allows users to register available foods, monitor stock levels, record consumption, and calculate nutritional information associated with meals.

The central goal is to reduce the fragmentation between two processes that are often treated separately: kitchen inventory management and dietary monitoring. In this way, the user can maintain a more complete view of what is available at home, what is consumed, and how it affects their diet and nutritional needs.

In addition, the system serves as an academic and portfolio solution, allowing the application of concepts in software engineering, system architecture, database persistence, Java development with Spring Boot, and good development and testing practices.

## 1.2 Scope of System Development and Stakeholders

### System scope

The system will be responsible for:

- registering and maintaining pantry items;
- recording product entries and withdrawals;
- tracking the stock level of food items;
- registering meals and their ingredients/recipes;
- associating each meal with the items used;
- calculating calories and macronutrients;
- automatically updating stock based on consumption;
- providing data for consultation and history.

### Out of scope initially

At the beginning of development, the system does not include:

- user authentication and authorization;
- multiple user profiles with different permissions;
- a complete graphical interface;
- integration with external nutrition APIs;
- cloud production support;
- advanced consumption analysis and complex dashboards.

### Stakeholders

The main people involved in the development and use of the system include:

- End user: a person who registers food, controls inventory, and tracks meals;
- Developer/software engineer: responsible for implementation, maintenance, and evolution of the system;
- Tutor/teacher or advisor: monitors the academic development and application of software engineering concepts;
- Future interested parties: nutritionist, food manager, or health support team, if the system is expanded.

# Part II: Overview of the system

## 2.1 Vision and Objectives of the System

PantryFit is an application that combines domestic item management with nutritional tracking. The system's vision is to allow the user to have an integrated view between the kitchen and food intake, reducing manual errors, improving inventory control, and simplifying meal registration.

### General objectives

- control food items available in stock;
- register meals and ingredients used;
- maintain consumption history;
- calculate nutritional information by meal and by period;
- maintain consistency between food intake and inventory.

### Specific objectives

- register food items with category and unit of measure;
- control available quantities;
- record stock entries and adjustments;
- associate ingredients with meals;
- calculate calories, proteins, carbohydrates, and fats;
- automatically update stock when consumption is recorded.

## 2.2 Context and limits of the system

The system is inserted in a domestic and personal context, where the user needs to control food, meals, and nutritional habits without relying on fragmented and manually managed processes.

PantryFit acts as a support tool for organizing the kitchen and food consumption. It plays a central role in keeping track of what exists in stock and what is used throughout the day.

### System limits

- the system is aimed at an individual or domestic use environment;
- the initial solution prioritizes backend and business logic;
- persistence and business rules are prioritized over the visual interface;
- the application depends on a structured database and integrity rules to ensure consistency;
- the solution does not include, at the initial stage, integration with marketplaces, automatic shopping, or advanced authentication.

## 2.3 General structure of the system

The system architecture will be organized into layers to facilitate maintenance, scalability, and testability.

```text
src/
├── main/
│   ├── java/
│   │   ├── controller/     # REST endpoints and APIs
│   │   ├── service/        # Business rules
│   │   ├── repository/     # Data access
│   │   ├── entity/         # JPA domain entities
│   │   ├── dto/            # Data transfer objects
│   │   └── exception/      # Error handling
│   │
│   └── resources/
│       ├── application.properties
│       └── static/         # Static files
│
└── test/
    └── java/
        └── ...              # Unit and integration tests
```

### Main components

- Pantry item management;
- Inventory management;
- Meal management;
- Nutritional calculation;
- Integration between stock and consumption;
- Data persistence in a relational database;
- API for communication with clients and future frontends.

## 2.4 User characteristics

The expected users of the system are people interested in organizing their diet and controlling what they have at home. The main profile is a person who wants to maintain simple but consistent records of food, consumption, and nutrition.

### User profile

- domestic user or person who prepares meals at home;
- interest in controlling purchases and stock;
- desire to track calories and macronutrients;
- frequent use of technology and digital habits;
- need for organization and clarity in food management.

### Level of experience

- the system must be intuitive and easy to use;
- the interface should minimize the need for extensive training;
- the core operation must be simple, fast, and practical;
- data should be displayed clearly to facilitate consumption analysis.

# Part III: System requirements

## 3.1 By subsystem/component

### 3.1.1 Food management subsystem

The food subsystem is responsible for registering the available items in the system, their categories, quantities, and units of measurement. It should allow the registration of basic products, consultation of existing items, and maintenance of essential information for inventory control.

### 3.1.2 Inventory subsystem

The inventory subsystem must control stock entries, withdrawals, and quantity adjustments. This module must ensure that the available balance is updated according to the operation performed and that the history of movements is preserved.

### 3.1.3 Meal subsystem

This module must allow the registration of meals, the association of ingredients and consumed quantities, and the maintenance of a history of records. It should also make it possible to identify food intake at different times of the day, such as breakfast, lunch, dinner, or snack.

### 3.1.4 Nutritional subsystem

The nutritional module must calculate the energetic value and macronutrients of each meal, in addition to facilitating consultation of data by period. The calculation must consider the nutritional values of the ingredients and the quantity used.

### 3.1.5 Integration subsystem

Integration between the inventory and meals must ensure that the consumption of ingredients reduces the corresponding stock, maintaining consistency between what was consumed and what remains available.

## 3.2 Functional requirements, quality requirements, and constraints

### Functional requirements

- FR01: the system must allow food registration;
- FR02: the system must record the unit of measure and food category;
- FR03: the system must control the available quantity in stock;
- FR04: the system must allow product entry and withdrawal operations;
- FR05: the system must register meals with date and meal type;
- FR06: the system must associate ingredients and quantities with meals;
- FR07: the system must calculate meal calories;
- FR08: the system must calculate the meal macronutrients;
- FR09: the system must automatically update inventory when a meal is recorded;
- FR10: the system must provide a history of meals and stock movements;
- FR11: the system must allow data queries by period and category;
- FR12: the system must ensure consistency between stock and consumption data.

### Quality requirements

- QR01: the application must be easy to maintain and evolve;
- QR02: the code must follow good organization and architecture practices;
- QR03: the system must maintain data integrity in critical operations;
- QR04: the application must respond quickly in common operations;
- QR05: the system must be testable through automated tests;
- QR06: the solution must be compatible with development and testing environments via Docker.

### Constraints

- C01: the system will be implemented in Java with Spring Boot;
- C02: the main database will be PostgreSQL;
- C03: the project must follow a layered backend organization;
- C04: the execution environment can be configured with Docker and Docker Compose;
- C05: the initial solution prioritizes the application and persistence layers, without focusing on a complex frontend;
- C06: the application must respect integrity rules to avoid inconsistencies in stock and consumption.

## 3.3 Interfaces

### User interfaces

The initial solution can be accessed through HTTP endpoints, with future web or mobile interfaces added as the project evolves. The user interface should make it easy to register foods, meals, and consult history.

### System interfaces

- REST API for food registration and consultation;
- REST API for meal registration and consumption records;
- Communication with a relational database;
- Internal integration between stock and nutrition modules;
- Potential future integration with frontend and external services.

### Communication interfaces

The system should use simple and consistent communication patterns, with JSON as the main data exchange format between client and server. The backend architecture should separate the presentation layer from business logic and persistence.

## References

- Spring Boot Documentation: https://spring.io/projects/spring-boot
- Java Documentation: https://docs.oracle.com/en/java/
- PostgreSQL Documentation: https://www.postgresql.org/docs/
- Docker Documentation: https://docs.docker.com/
