# Employee Management System (EMS)

A Java web application for managing employee records using JSP,
Servlets, Hibernate with JPA, PostgreSQL, and Apache Tomcat.

This project was created as a learning exercise based on a training
assignment. Its goal is to practise Java web-development concepts and
understand how the technologies work together.

## Learning Objectives

The assignment focuses on:

-   Building web pages with **JSP**.
-   Handling requests with **Java Servlets**.
-   Persisting employee data with **JPA / Hibernate** and
    **PostgreSQL**.
-   Deploying a Java web application on **Apache Tomcat**.
-   Understanding servlet and web-application features such as
    `ServletContext`, `ServletConfig`, `HttpSession`, cookies,
    `RequestDispatcher`, `sendRedirect`, welcome files, and
    `load-on-startup`.

## Requirements Covered by the Training Assignment

The supplied problem statement describes the following expected
functionality:

### 1. Home page

-   Use `index.jsp` as the welcome page configured in `web.xml`.
-   Provide navigation to the employee list and the add-employee form.

### 2. Add an employee

-   Use `employeeForm.jsp` to collect an employee's name, email, and
    department.
-   Use `ServletConfig` to supply a default department when the
    department field is empty.
-   Handle form submission with a Servlet and save the employee through
    a JPA `EntityManager`.
-   Allow the database to generate the employee ID.
-   Redirect to the employee list after saving.

### 3. View employees

-   Retrieve and display employee records in a table.
-   Provide edit and delete links for each employee.
-   Ask for confirmation before deleting a record.
-   Display the last updated employee ID from `HttpSession` and the last
    updated employee name from a cookie.

### 4. Edit an employee

-   Load the selected employee by ID through JPA.
-   Forward the employee details to the shared `employeeForm.jsp` using
    `RequestDispatcher`.
-   Pre-fill the form with the existing values.
-   Update the record and store the employee ID in the session and
    employee name in a cookie.
-   Redirect back to the employee list.

### 5. Delete an employee

-   Delete the selected employee through JPA.
-   Redirect to the employee list after deletion.

> These bullets describe the requirements in the training problem
> statement; they should not be taken as confirmation that every feature
> has been implemented or tested in the repository.

## Technology Stack

  Technology              Purpose
  ----------------------- ---------------------------------------------------
  Java                    Application programming language
  JSP                     Server-rendered pages and employee form
  Jakarta Servlets        Handle HTTP requests and application flow
  JPA (`EntityManager`)   Object-relational persistence API
  Hibernate ORM           JPA implementation / ORM
  PostgreSQL              Relational database for employee records
  Apache Tomcat           Servlet container for running the web application
  Maven                   Dependency management and WAR packaging

The repository's Maven configuration includes Hibernate ORM, the
PostgreSQL JDBC driver, the Jakarta Servlet API, and JUnit for tests.
See [`pom.xml`](pom.xml) for the dependency versions.

## Prerequisites

Install and configure:

-   A JDK compatible with the project's Hibernate and Tomcat versions.
-   Apache Maven.
-   PostgreSQL.
-   A Tomcat version compatible with the Jakarta Servlet API used by the
    project.

**Compatibility note:** The current `pom.xml` sets the Java compiler
source and target to Java 8, while the declared Jakarta Servlet API 6.0
and Hibernate ORM 6.5 dependencies require a newer Java runtime. Verify
and align the JDK, compiler settings, and Tomcat version before building
or deploying.

## Setup and Running

1.  **Clone the repository**

    ``` bash
    git clone https://github.com/atharvashelkeatwork/EMS.git
    cd EMS
    ```

2.  **Create a PostgreSQL database**

    Create a database for the application. Use the database name,
    credentials, and schema expected by the project's JPA configuration.

3.  **Configure persistence**

    Configure the project's JPA persistence settings with your
    PostgreSQL JDBC URL, username, password, and required schema
    settings. Do not commit real database credentials to source control.

4.  **Build the WAR**

    ``` bash
    mvn clean package
    ```

    Maven should produce the web archive under `target/` if the build
    succeeds.

5.  **Deploy to Tomcat**

    Deploy the generated `EMS.war` to a compatible Tomcat server and
    start the server. Open the application's context path in a browser;
    if deployed under the default context name, this is typically:

    ``` text
    http://localhost:8080/EMS/
    ```

    The exact URL can differ depending on the Tomcat deployment
    configuration.

## Concepts to Review

While working through the application, pay attention to the distinction
between:

-   **Forwarding and redirecting:** `RequestDispatcher.forward()` passes
    a request to another server-side resource; `sendRedirect()` asks the
    browser to make a new request.
-   **Session and cookies:** `HttpSession` stores server-side session
    state, while cookies are stored by the browser and sent with
    subsequent requests.
-   **Servlet configuration and context:** `ServletConfig` provides
    configuration for an individual servlet; `ServletContext` provides
    application-wide context.
-   **JPA and Hibernate:** JPA defines the persistence API, while
    Hibernate provides an implementation.
-   **Entity lifecycle:** JPA operations are typically performed within
    a transaction, with entity IDs generated according to the mapping
    and database configuration.

## Project Status

This repository is a learning project for practising the technologies
and concepts listed above. Consult the source code and configuration
files to confirm which requirements are currently implemented.

## Repository

[atharvashelkeatwork/EMS](https://github.com/atharvashelkeatwork/EMS)
