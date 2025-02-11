# Finance Management App

## Overview
Finance Management App is a Spring Boot-based REST API that helps users manage their financial transactions. Users can create, retrieve, update, and delete financial entries using the provided endpoints.

## Project Structure
```
src/main/java/com.assignment.Personal.Finance.Tracker
│── controller
│   └── FinanceController.java
│── dto
│   ├── Finance.java
│   └── FinanceSummaryDTO.java
│── repo
│   └── FinanceRepository.java
│── services
│   └── FinanceService.java
│── PersonalFinanceTrackerApplication.java
src/main/resources
│── application.properties
```

## Technologies Used
- Java 17
- Spring Boot 3+
- Spring Data JPA
- MySQL Database
- Maven
- Postman (for API testing)

## Setup and Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repository/finance-management.git
   cd finance-management
   ```
2. Build and run the application:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
3. The application will start at `http://localhost:8080`

## API Endpoints
The API follows RESTful principles and exposes the following endpoints:

### 1. Create an Entry
**Endpoint:** `POST /api/v1/entries`

**Request Body:**
```json
{
  "amount": 5000.75,
  "date": "2025-02-11",
  "category": "Salary",
  "description": "Monthly grocery shopping"
}
```

### 2. Retrieve All Entries
**Endpoint:** `GET /api/v1/entries`

### 3. Retrieve an Entry by ID
**Endpoint:** `GET /api/v1/entries/{id}`

### 4. Update an Entry
**Endpoint:** `PUT /api/v1/entries/{id}`

**Request Body:**
```json
{
  "amount": 5000.75,
  "date": "2025-02-11",
  "category": "Salary",
  "description": "Monthly grocery shopping Edited"
}
```

### 5. Delete an Entry
**Endpoint:** `DELETE /api/v1/entries/{id}`



