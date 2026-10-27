# UGV Bus Route Management System 🚍

A Java-based desktop application designed to manage bus routes and calculate fares for different transportation categories, including City, Intercity, and Shuttle services.

Developed using **Java Swing, JDBC, and MySQL**, this project demonstrates fundamental Object-Oriented Programming (OOP) concepts, including abstraction, inheritance, polymorphism, and encapsulation. It also implements the Data Access Object (DAO) pattern to organize database operations.

---

## 📌 Project Overview

The **UGV Bus Route Management System** provides a graphical interface for managing bus route information and calculating transportation fares. It connects to a MySQL database to store and retrieve route records, allowing users to view route details through an interactive table.

The project was developed as part of the **Object-Oriented Programming (OOP), 4th Semester** academic coursework at UGV.

### 🎯 Objectives

* Apply OOP principles to a practical Java application.
* Develop a desktop GUI using Java Swing.
* Integrate a Java application with MySQL using JDBC.
* Implement database operations using the DAO design pattern.
* Calculate fares dynamically according to different route categories.
* Organize source code into reusable and maintainable classes.

---

## ✨ Features

### 🚌 Route Management

* Manage route information for City, Intercity, and Shuttle services.
* Store route names, departure times, starting locations, and destinations.
* Record route distances, unit costs, and calculated fares.

### 💰 Dynamic Fare Calculation

* **City Route:** Calculates fares based on distance and unit cost.
* **Intercity Route:** Calculates fares based on distance, unit cost, and an additional fixed tax.
* **Shuttle Route:** Uses a fixed flat fare.

### 🖥️ Graphical User Interface

* Built with Java Swing components.
* Provides input fields for route information.
* Uses dropdown menus for selecting route categories.
* Displays saved route records in a `JTable`.

### 🗄️ Database Integration

* Connects to MySQL using JDBC.
* Stores route information in a structured database.
* Retrieves saved records using the DAO pattern.
* Supports inserting and displaying route records.

### 🔄 Table Refresh

* Refreshes the route table after database operations.
* Displays stored route information in an organized format.

---

## 🛠️ Technologies Used

| Technology                  | Purpose                             |
| --------------------------- | ----------------------------------- |
| Java                        | Core application development        |
| Java Swing                  | Graphical user interface            |
| JDBC                        | Database connectivity               |
| MySQL                       | Database management                 |
| MySQL Connector/J           | JDBC driver for MySQL               |
| NetBeans IDE                | Development environment             |
| Object-Oriented Programming | Application architecture and design |

---

## 🏗️ Project Architecture

The application is organized under the Java package `ugv.bus`.

```text
UGVBusManagement/
│
├── src/
│   └── ugv/
│       └── bus/
│           ├── DatabaseConnection.java
│           ├── Route.java
│           ├── CityRoute.java
│           ├── IntercityRoute.java
│           ├── ShuttleRoute.java
│           ├── RouteDAO.java
│           └── BusRouteUI.java
│
├── README.md
└── Libraries/
    └── mysql-connector-j.jar
```

*Note: The directory structure may vary depending on your IDE and project configuration.*

### 📂 Source Code Description

| Class                     | Description                                                                           |
| ------------------------- | ------------------------------------------------------------------------------------- |
| `DatabaseConnection.java` | Establishes a connection between the Java application and the MySQL database.         |
| `Route.java`              | Abstract base class containing common route properties and fare calculation behavior. |
| `CityRoute.java`          | Implements fare calculation for city routes.                                          |
| `IntercityRoute.java`     | Implements fare calculation for intercity routes, including an additional fixed tax.  |
| `ShuttleRoute.java`       | Implements the fixed-fare calculation for shuttle services.                           |
| `RouteDAO.java`           | Handles database operations, including inserting and retrieving route records.        |
| `BusRouteUI.java`         | Provides the main graphical user interface and application entry point.               |

---

## 🧠 Object-Oriented Programming Concepts

This project demonstrates the practical application of several fundamental OOP concepts.

### 1. Abstraction

The abstract `Route` class defines common route properties and fare calculation behavior without requiring every route type to use the same calculation implementation.

### 2. Inheritance

The `CityRoute`, `IntercityRoute`, and `ShuttleRoute` classes inherit shared properties and behaviors from the `Route` base class.

### 3. Polymorphism

Each route subclass can implement its own fare calculation logic, allowing the application to handle different route categories through a common interface.

### 4. Encapsulation

Route-related data and database operations are organized into dedicated classes, helping separate responsibilities and maintain the codebase.

### 5. Data Access Object (DAO) Pattern

The `RouteDAO` class separates database access logic from the graphical user interface and route calculation logic.

---

## 🗄️ Database Configuration

The application uses MySQL to store bus route information.

### Step 1: Create the Database

Open MySQL Workbench or another MySQL client and execute:

```sql
CREATE DATABASE ugv_bus_db;

USE ugv_bus_db;
```

### Step 2: Create the Bus Routes Table

Execute the following SQL statement:

```sql
CREATE TABLE bus_routes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    route_name VARCHAR(100) NOT NULL,
    time VARCHAR(50) NOT NULL,
    start_loc VARCHAR(100) NOT NULL,
    end_loc VARCHAR(100) NOT NULL,
    distance DOUBLE NOT NULL,
    unit_cost DOUBLE NOT NULL,
    total_fare DOUBLE NOT NULL,
    route_type VARCHAR(50) NOT NULL
);
```

### Step 3: Configure the Database Connection

Open `DatabaseConnection.java` and ensure that the connection settings match your local MySQL configuration.

Example:

```java
String url = "jdbc:mysql://localhost:3306/ugv_bus_db";
String username = "root";
String password = "your_password";
```

Replace `your_password` with your actual MySQL password.

**Security note:** Do not commit real database passwords or other sensitive credentials to a public repository. Use environment variables or a configuration file excluded from version control when appropriate.

---

## ⚙️ Installation and Setup

Follow these steps to configure and run the application in NetBeans.

### Prerequisites

Before running the project, ensure that you have installed:

* Java Development Kit (JDK 8 or higher).
* NetBeans IDE or another compatible Java IDE.
* MySQL Server.
* MySQL Workbench or another MySQL client.
* MySQL Connector/J JDBC driver.

### Step 1: Create the Java Project

1. Open NetBeans IDE.
2. Create a new Java Application project named `UGVBusManagement`.
3. Create a Java package named `ugv.bus`.

### Step 2: Add the Source Files

Create or copy the following classes into the `ugv.bus` package:

* `DatabaseConnection.java`
* `Route.java`
* `CityRoute.java`
* `IntercityRoute.java`
* `ShuttleRoute.java`
* `RouteDAO.java`
* `BusRouteUI.java`

### Step 3: Configure MySQL

1. Start your MySQL server.
2. Create the `ugv_bus_db` database.
3. Create the `bus_routes` table using the SQL statements provided above.
4. Update the database credentials in `DatabaseConnection.java`.

### Step 4: Add the JDBC Driver

1. Download the MySQL Connector/J driver if it is not already available.
2. In NetBeans, right-click the project.
3. Select **Properties**.
4. Open the **Libraries** section.
5. Add the MySQL Connector/J JAR file.

### Step 5: Run the Application

1. Ensure that MySQL is running.
2. Verify that the database connection settings are correct.
3. Open `BusRouteUI.java`.
4. Right-click the file and select **Run File**, or press `Shift + F6`.

The application's graphical interface should launch, allowing you to manage route information and view database records.

---

## 🧪 Example Fare Calculation

The following examples illustrate the general fare calculation logic.

| Route Type | Calculation Method                 | Example             |
| ---------- | ---------------------------------- | ------------------- |
| City       | Distance × Unit Cost               | 10 × 5 = 50         |
| Intercity  | (Distance × Unit Cost) + Fixed Tax | (20 × 5) + 30 = 130 |
| Shuttle    | Fixed Flat Fare                    | 40                  |

*Note: These values are illustrative examples, not predefined application settings. Actual results depend on the fare calculation rules and values implemented in the source code.*

---

## 🔮 Future Enhancements

The project can be extended with additional features to improve functionality, security, and usability.

* [ ] Update existing bus route records.
* [ ] Delete route records.
* [ ] Search routes by name or destination.
* [ ] Filter routes by category.
* [ ] Add input validation and improved error handling.
* [ ] Display fare summaries and route statistics.
* [ ] Improve the interface with a modern visual design.
* [ ] Add user authentication and role-based access.
* [ ] Use `DECIMAL` database columns for monetary values.
* [ ] Introduce automated tests for fare calculations.
* [ ] Improve database configuration and credential management.

---

## 🎓 Academic Information

| Field         | Details                           |
| ------------- | --------------------------------- |
| Project Title | UGV Bus Route Management System   |
| Course        | Object-Oriented Programming (OOP) |
| Semester      | 4th Semester                      |
| University    | UGV                               |
| Project Type  | Java Desktop Application          |

---

## 👨‍💻 Project Author

**Sajid Al Raian**

Object-Oriented Programming (OOP)
4th Semester | UGV

This project was developed as part of academic coursework to demonstrate the practical application of Java programming, Object-Oriented Programming principles, graphical user interface development, and relational database integration.

---

## 📄 License

This project was developed for educational purposes.

If you intend to distribute the project publicly, consider adding a `LICENSE` file to define the terms under which others may use, modify, and distribute the source code.

---

<div align="center">

**UGV Bus Route Management System**

*Applying Object-Oriented Programming to Real-World Transportation Management.*

Developed by **Sajid Al Raian**

</div>
