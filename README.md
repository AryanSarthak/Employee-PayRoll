# Employee Payroll System (Spring Boot)

## 📌 Project Overview
Employee Payroll is a Spring Boot REST API project used to manage employee payroll data.  
It supports full CRUD operations for employees including creating, reading, updating, and deleting employee records.

The project follows a layered architecture using:
- Controller Layer
- Service Layer
- Repository Layer
- DTO Layer
- Exception Handling Layer

---

## 🛠 Tech Stack
- Java 21  
- Spring Boot 4.x  
- Spring Data JPA  
- MySQL Database  
- Maven  
- Lombok  
- Hibernate Validator  

## ⚙️ Features
✔ Add Employee  
✔ Get Employee By ID  
✔ Get All Employees  
✔ Update Employee  
✔ Delete Employee  
✔ Exception Handling  
✔ Validation Support  
✔ Logging with Lombok  

---

## 🗄 Database Configuration
Update your application.properties file:

spring.datasource.url=jdbc:mysql://localhost:3306/employeedb  
spring.datasource.username=root  
spring.datasource.password=yourpassword  

spring.jpa.hibernate.ddl-auto=update  
spring.jpa.show-sql=true  
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect  

---

## 📡 API Endpoints

### Add Employee
POST  
/api/employees/save  

### Get Employee By ID
GET  
/api/employees/get/{id}  

### Get All Employees
GET  
/api/employees  

### Update Employee
PUT  
/api/employees/update/{id}  

### Delete Employee
DELETE  
/api/employees/delete/{id}  

---

## 🧾 Sample Request Body
{
  "name": "Aryan",
  "department": "IT",
  "salary": 50000
}

---

## 🚀 How To Run

### Clone Repository
git clone https://github.com/your-username/EmployeePayRoll.git  

### Navigate To Project
cd EmployeePayRoll  

### Build Project
mvn clean install  

### Run Application
mvn spring-boot:run  

---

## 🧪 Testing
You can test APIs using:
- Postman
- Swagger (If added later)

---

## 📜 Exception Handling
Custom Exception:
- EmployeeNotFoundException

Handled using Global Exception Handler to return proper error responses.

---

## 🔐 Validation
Uses Jakarta Validation:
- @NotNull  
- @NotBlank  
- @Valid  

---

## 🧑‍💻 Author
Aryan Sarthak  

---

## 📄 License
This project is for learning and development purposes.
