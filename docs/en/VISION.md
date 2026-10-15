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

The following requirements were defined based on the quality characteristics of
ISO/IEC 25010 that apply to the current scope. Each requirement includes an
acceptance criterion and a measurement or operationalization method.

- QR01 - Functional suitability: the system must implement the flows specified
    in functional requirements FR01 to FR12, including nutritional calculations
    and the stock deduction associated with consumption. It will be measured
    quantitatively through acceptance tests, with 100% of the specified scenarios
    passing. Calculated nutritional values must differ by no more than 0.01 from
    the expected result, respecting the registered unit of measure.
- QR02 - Performance efficiency: common registration, consultation, and
    consumption operations must have a response time of up to 2 seconds at the
    95th percentile, with up to 20 simultaneous requests. It will be measured by
    load tests in a reference environment, recording latency, error rate, and
    throughput.
- QR03 - Reliability: a consumption operation must be atomic, so a failure
    cannot leave a meal registered without the corresponding stock deduction, or
    vice versa. It will be operationalized through database transactions and
    failure tests, with 100% of invalid scenarios resulting in rollback and never
    allowing negative stock.
- QR04 - Usability and operability: endpoints must use consistent names and
    formats, return appropriate HTTP status codes, and report validation errors in
    JSON. It will be evaluated qualitatively through an endpoint checklist covering
    error messages, naming, and registration flow, with 100% of the checklist items
    passing quantitatively.
- QR05 - Security: data received by the API must be validated, and dependencies
    must be checked for known vulnerabilities. It will be operationalized through
    Bean Validation, tests for invalid input, and OWASP Dependency-Check; the
    build must not accept vulnerabilities with a CVSS score equal to or greater
    than 7.
- QR06 - Maintainability: the code must remain organized into presentation,
    service, persistence, and domain layers, with separated responsibilities and
    low coupling. It will be verified through code review and package structure,
    together with automated tests for business rules; each new feature must
    include tests for its main and error scenarios.
- QR07 - Compatibility: the application must work with Java 21, Spring Boot,
    and PostgreSQL defined for the project, while maintaining communication over
    HTTP and JSON. It will be measured by the successful execution of `./mvnw
    test` and integration tests with PostgreSQL in the reference environment.
- QR08 - Portability: the development and testing environment must be
    reproducible through documented configuration, preferably with Docker and
    Docker Compose. It will be measured by creating the environment on a clean
    machine and successfully running the application and test suite without manual
    code changes.

### Constraints

- C01: the implementation must use Java 21 and Spring Boot, according to the
    project configuration and dependencies defined in `pom.xml`.
- C02: the main relational database must be PostgreSQL; using another DBMS
    requires explicit adaptation of the persistence configuration and tests.
- C03: the backend must maintain separation between the presentation, service,
    persistence, and domain layers, avoiding business rules implemented directly
    in controllers or repositories.
- C04: external communication must occur through an HTTP API, using JSON as the
    standard input and output format.
- C05: operations that change stock, meals, and their relationships must comply
    with database integrity constraints and run transactionally.
- C06: the initial solution must prioritize the backend, persistence, and
    business rules; complex frontend, authentication, authorization, and external
    integrations are outside the initial scope.
- C07: the development and testing environment must be reproducible through
    Docker and Docker Compose, when those files are provided, without changing
    the application's business rules.
- C08: new features must preserve compatibility with the functional
    requirements, API contracts, and persisted data, unless an approved migration
    is documented.

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
