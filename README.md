# PantryFit

System for meal management, nutritional tracking, and pantry inventory management.

## About the Project

PantryFit is an application developed with the goal of integrating **meal management** with **pantry inventory tracking**.

The purpose is to allow users to keep track of available food items, record meals, and monitor nutritional information such as calories and macronutrients.

One of the main goals of the system is to establish a relationship between food consumption and pantry inventory. This way, ingredients used to prepare a meal can directly affect inventory tracking.

The project also has an academic and portfolio-oriented purpose, being used to deepen knowledge in software development, Java, Spring Boot, application architecture, databases, testing, and software engineering best practices.

---

## Objectives

PantryFit aims to address two related problems:

* managing and tracking food items available in the pantry;
* organizing and tracking meals and their nutritional values.

By integrating these features, the system does not treat inventory management and nutritional tracking as isolated functionalities.

---

## Features

The project is currently in the early stages of development. The main planned features are:

### Pantry Management

* Food item registration;
* Available quantity tracking;
* Inventory entry and removal records;
* Tracking of available food items.

### Meal Management

* Meal registration;
* Association of food items with meals;
* Tracking of quantities used;
* Meal history.

### Nutritional Information

* Calorie calculation;
* Macronutrient calculation;
* Nutritional value tracking for meals.

### Integration

* Inventory updates based on ingredients used in meals;
* Relationship between meals, ingredients, and nutritional information.

---

## Technologies

### Backend

* Java
* Spring Boot
* Maven
* PostgreSQL

### Infrastructure

* Docker
* Docker Compose

### Version Control

* Git
* GitHub

The frontend will be developed at a later stage, after the main backend and API structure have been consolidated.

---

## Architecture

The backend will be structured using a layered architecture, keeping the application's responsibilities separated.

The initial structure will follow an organization similar to:

```text
src/
├── main/
│   ├── java/
│   │   └── ...
│   │       ├── controller/
│   │       ├── service/
│   │       ├── repository/
│   │       ├── model/
│   │       └── ...
│   │
│   └── resources/
│       └── application.properties
│
└── test/
    └── java/
        └── ...
```

The architecture may evolve as new requirements are identified throughout the development process.

---

## Conceptual Model

The main idea behind PantryFit is to connect pantry management with meal management.

The application's conceptual flow can be represented as follows:

```text
Food Items
    │
    ▼
Pantry
    │
    │ used in
    ▼
Meals
    │
    ├──────────────► Inventory Update
    │
    └──────────────► Nutritional Information
                              │
                              ├── Calories
                              ├── Protein
                              ├── Carbohydrates
                              └── Fats
```

This integration is one of the main concepts guiding the development of the system.

---

## Project Status

The project is currently in the **early stages of development**.

### Roadmap

* [x] Repository creation
* [x] Initial technology stack definition
* [ ] Spring Boot project setup
* [ ] PostgreSQL configuration
* [ ] Docker environment configuration
* [ ] Data model definition
* [ ] Pantry management implementation
* [ ] Meal management implementation
* [ ] Nutritional calculation implementation
* [ ] Meal and pantry integration
* [ ] API implementation
* [ ] Automated testing implementation
* [ ] Frontend development
* [ ] Frontend and backend integration
* [ ] Application deployment

---

## Running the Project

### Prerequisites

To run the project locally, you will need:

* Java;
* Maven;
* Docker;
* Docker Compose;
* Git.

### Cloning the Repository

```bash
git clone https://github.com/gustavoJTT/PantryFit.git

cd PantryFit
```

### Running the Application

Setup and execution instructions will be added as the project's infrastructure is consolidated.

---

## Testing

The application will include automated tests throughout the development process.

The testing strategy will be applied according to the different layers of the application, aiming to ensure the reliability of business rules and system components.

---

## Development

PantryFit is being developed as a study and portfolio project, focusing on the practical application of software engineering concepts.

The main concepts explored include:

* Object-Oriented Programming;
* REST API development;
* Layered architecture;
* Spring Boot;
* Data persistence;
* Database modeling;
* Automated testing;
* Docker and containerization;
* Version control with Git;
* Development best practices;
* Software quality and maintainability.

---

## Future Improvements

After the implementation of the core features, some potential improvements include:

* User authentication and authorization;
* User profiles and nutritional preferences;
* Meal planning;
* Shopping list generation based on inventory;
* Low-stock alerts;
* Consumption history and analysis;
* Nutritional dashboard;
* Integration with external nutritional information sources;
* Complete web application;
* Production deployment.

---

## Repository

The project's source code is available on GitHub:

https://github.com/gustavoJTT/PantryFit

---

## License

The project's license has not yet been defined.
