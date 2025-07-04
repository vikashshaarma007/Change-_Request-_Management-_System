<h1 align="center">Change Request Management System 🧮🚀</h1>

<p align="left"><i>The Change Request Management System is a web-based backend application developed using Java Spring Boot and structured with the Model-View-Controller (MVC) architectural pattern. It is designed to efficiently handle and track change requests (CRs) made within an organization — such as changes to software, infrastructure, or business processes.

This system provides full CRUD functionality for managing change requests, along with user role-based control, status tracking, and optional approval workflows. </i></p>
<br>


<p align="center"><i>CRUD Operations</i> 👨🏽‍💻
  <br>

  To create APIs that allow users to create, update, delete, and fetch all agents and campaigns with pagination in Spring Boot.
  
## Built With : 
## Tables to include:
```sh
 1. Users: Details on all users, including roles and project assignments.
 2. Roles: Defines role types (Requester, Manager, Developer). -
 3. ChangeRequests: Fields for title, description, priority, due date, status, and timestamps. 
 4. Teams: Information on development teams and assigned developers. -
 5. Timeline: Tracks stages of each change request (start/completion dates, responsible 
```

 # Technology Stack:
 ```sh
    * Java 17
    * Spring Boot
    * HTML
    * Bootstrap
    * Spring MVC
    * Spring Data JPA
    * Hibernate
    * Maven
    * PostgreSQL Database
    * Spring-Boot-Devtools
```

* dependencies
  ```sh
  
  dependencies : 
  Spring Boot DevTools
  Spring Data Jpa
  PostgreSQL Driver
  Spring Web
  Spring Web Services
  ```
* to run the project
  ```sh
  intellij/eclipse
  ```
* to build the project for production
  ```sh
  Go to start.spring.io.
  Choose Maven, set Group and Artifact names.
  Pick Java version and add any dependencies (e.g., Spring Web, Spring JPA).
  Click Generate to download the project as a .zip file.
  Extract and import it into your IDE.
  Run the main method in DemoApplication.java to start the app.
  https://start.spring.io/
  ```
## Installation 
  ```sh
    _Follow these simple steps to get the server up and running 👾🧮🚀✅._   
    1. Create Database -> Change_Request_Management_System
    2. Open project in preferred IDE (I used SpringToolsSuite4)
    3. Run the project as a Spring Boot app.
    4. Hibernate will automatically create a table -> Campaign, CampaignResult, Agent
    5. Add sample data to the table using Postgresql pgadmin tools
    6. Ren web browser at localhost: 8080/
    7. Add, Fatch, Update, Delete records from the web app
   ```



