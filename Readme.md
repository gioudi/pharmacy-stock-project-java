# Pharmacy Stock Project Java

## Description

Pharmacy Stock Project Java is a desktop application developed using Java Swing that simulates the medicine ordering process for a pharmacy.

The project was built following the MVC (Model View Controller) architectural pattern in order to maintain separation between the UI, business logic, and data models.

Additionally, several design patterns and software engineering practices were applied to improve maintainability, readability, and scalability.

---

## Features

* Medicine order form.
* Dynamic order summary window.
* Input validations and error handling.
* Event-driven controller architecture.
* Type-safe enums implementation.
* Encapsulated domain models.
* Compatible with NetBeans and Eclipse.

---

## Technologies

* Java 17
* Java Swing
* NetBeans 29
* Eclipse IDE
* Git

---

## Project Structure

```plaintext
src
└── main
    └── java
        └── com
            └── pharmacystockproject
                └── pharmacy
                    ├── controller
                    ├── model
                    └── view
```

---

## Design Patterns Used

* MVC (Model View Controller)
* Event-Driven Controller
* Data Encapsulation
* Type-safe Enums
* View Composition via Parameter Injection
* View Component Isolation

---

## Functionalities

The application allows the user to:

* Register a medicine order.
* Select medicine type.
* Choose a provider company.
* Select a pharmacy branch.
* Validate form inputs.
* Generate an order summary.
* Simulate order dispatch.

---

## Validation Rules

The system validates:

* Medicine name cannot be empty.
* Medicine name must be alphanumeric.
* Quantity must be a positive integer.
* A provider must be selected.
* A branch must be selected.

---

## Author

Sergio Penagos
