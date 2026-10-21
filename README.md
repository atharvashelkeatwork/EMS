# Employee Management System (EMS)

A Java web application for managing employee records using JSP, Servlets, Hibernate with JPA, PostgreSQL, and Apache Tomcat.

This project was created as a learning exercise based on a training assignment. Its goal is to practise Java web-development concepts and understand how the technologies work together.

## Learning Objectives

The assignment focuses on:

- Building web pages with **JSP**.
- Handling requests with **Java Servlets**.
- Persisting employee data with **JPA / Hibernate** and **PostgreSQL**.
- Deploying a Java web application on **Apache Tomcat**.
- Understanding servlet and web-application features such as `ServletContext`, `ServletConfig`, `HttpSession`, cookies, `RequestDispatcher`, `sendRedirect`, welcome files, and `load-on-startup`.

## Requirements Covered by the Training Assignment

The supplied problem statement describes the following expected functionality.

### 1. Home page

- Use `index.jsp` as the welcome page configured in `web.xml`.
- Provide navigation to the employee list (`employee`) and the add-employee form (`employee?action=create`).

### 2. Add an employee

- Use `employeeForm.jsp` to collect an employee's name, email, and department.
- Use `ServletConfig` to supply a default department when the department field is empty.
- Handle form submission with a Servlet and save the employee through a JPA `EntityManager`.
- Allow the database to generate the employee ID.
- Redirect to the employee list after saving.

### 3. View employees

- Retrieve and display employee records in a table.
- Provide an edit link (`employee?action=edit&id=EMP_ID`) and a delete link (`employee?action=delete&id=EMP_ID`) for each employee.
- Ask for confirmation before deleting a record.
- Display the last updated employee ID from `HttpSession` and the last updated employee name from a cookie.

### 4. Edit an employee

- Load the selected employee by ID through JPA.
- Forward the employee details to the shared `employeeForm.jsp` using `RequestDispatcher`.
- Pre-fill the form with the existing values.
- Update the record and store the employee ID in the session and employee name in a cookie.
- Redirect back to the employee list.

### 5. Delete an employee

- Delete the selected employee through JPA.
- Redirect to the employee list after deletion.

> These are the requirements from the training problem statement. They are not confirmation that every feature has been implemented or tested in this repository.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java | Application programming language |
| JSP | Server-rendered pages and employee form |
| Jakarta Servlets | Handle HTTP requests and application flow |
| JPA (`EntityManager`) | Persistence API for working with database entities |
| Hibernate ORM | Object-relational mapping and JPA implementation |
| PostgreSQL | Relational database for employee records |
| Apache Tomcat | Servlet container for running the web application |
| Apache Maven | Dependency management and build packaging |

The Maven configuration declares dependencies including Hibernate ORM, the PostgreSQL JDBC driver, the Jakarta Servlet API, and JUnit. See [`pom.xml`](pom.xml) for the versions and configuration.

## Prerequisites

- A JDK compatible with the dependencies and compiler configuration in `pom.xml`.
- Apache Maven.
- PostgreSQL.
- A Tomcat version compatible with the Jakarta Servlet API used by the project.

**Compatibility note:** The project configuration should be checked before building: Java compiler source/target settings must be compatible with the declared Hibernate and Jakarta Servlet versions. Jakarta Servlet 6.0 is intended for Tomcat 10.1, and these versions require Java 11 or newer. Make sure the installed JDK, Maven compiler settings, and Tomcat version are aligned.

## Setup and Running

### 1. Clone the repository

```bash
git clone https://github.com/atharvashelkeatwork/EMS.git
cd EMS
```

### 2. Create a PostgreSQL database

Create a database for the application. Use the database name, credentials, and schema expected by the project's JPA configuration.

### 3. Configure persistence

Check the project's persistence configuration and set the PostgreSQL JDBC URL, username, password, and any required schema settings. Do not commit real database credentials to source control.

### 4. Build the project

From the project root, run:

```bash
mvn clean package
```

If the build succeeds, Maven will place the packaged artifact in the `target/` directory. Use the actual WAR filename generated there when deploying; it may depend on the Maven configuration.

### 5. Deploy to Tomcat

Deploy the generated WAR file to a compatible Tomcat server and start the server. Open the application's context path in a browser. For example, if the WAR is named `EMS.war` and deployed with the `EMS` context path:

```text
http://localhost:8080/EMS/
```

The URL can differ depending on the WAR filename and Tomcat deployment configuration.

## Concepts to Review

- **Forwarding and redirecting:** `RequestDispatcher.forward()` forwards the current request to another server-side resource. `sendRedirect()` sends a redirect response, causing the browser to make a new request.
- **Sessions and cookies:** `HttpSession` stores session state on the server; cookies are stored by the browser and sent with subsequent requests.
- **Servlet configuration and context:** `ServletConfig` provides configuration for an individual servlet, while `ServletContext` represents the web application context.
- **JPA and Hibernate:** JPA defines the persistence API; Hibernate is an ORM framework that can implement that API.
- **Entity lifecycle and transactions:** JPA database operations commonly use transactions. ID generation depends on the entity mapping and database configuration.

## Project Status

This is a learning project for practising the technologies and concepts listed above. The requirements section summarizes the trainer's assignment; consult the source code and configuration files to determine which requirements are currently implemented.

## Repository

[atharvashelkeatwork/EMS](https://github.com/atharvashelkeatwork/EMS)
