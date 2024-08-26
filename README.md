# Employee Management System

The Employee System is a web-based application that allows users to search Add, edit,update,and delete employee information.

## Table of Contents
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Features](#features)
- [Project Setup](#project-setup)
- [Configuration](#configuration)
- [API Documentation](#api-documentation)

## Technologies Used

- **Java**: Programming language.
- **Spring Boot**: Framework for building Java applications.
- **Spring Data JPA**: For database access and ORM.
- **Thymeleaf**: Template engine for rendering web pages.
- **Swagger (OpenAPI)**: For API documentation.
- **Maven**: Build automation tool.
- **MySQL**: Database.
- **HTML**: Markup language for creating web pages.
- **CSS**: Style sheet language for designing web pages.

## Prerequisites

- Java 8 or higher
- Maven
- Git (optional)

## Features

- **add emp**: Users can add new employee details
- **edit employee details**:Users can edit existing employee details
- **update details**: Users can update the edited employee details
- **delete employee**: Users can delete/remove employee details
## Project Setup

1. **Clone the repository**:
    ```sh
    git clone https://github.com/your-repo/employee-management-system-app.git
    cd employee-management-system-app
    ```

2. **Install dependencies**:
    ```sh
    mvn clean install
    ```

3. **Set up the database**:
    - Create a MySQL database named `employeemanagement`.
    - Update the `application.properties` file with your database credentials.

4. **Run the application**:
    ```sh
    mvn spring-boot:run
    ```

5. **Access the application**:
    - Open your browser and navigate to `http://localhost:8095`.

## Configuration

### Application Properties

Update the `src/main/resources/application.properties` file with your database configuration:

```properties
spring.application.name=employee-management-system-app
spring.datasource.url=jdbc:mysql://localhost:3306/employeemanagement
spring.datasource.username=root
spring.datasource.password=guvi
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
## API Documentation

### Endpoints

#### Swagger OpenAPI Doc: https://github.com/rshc07/employee-management-system-App/blob/main/Swagger%20Open%20API%20Document.pdf

#### User Registration

- **URL**: ```/registration```
- **Method**: ```POST```
- **Request Body**:
  ```JSON
     {
    "name": "John Doe",
    "email": "john.doe@example.com",
    "password": "password123"
     }
  
- **Response**:
  - **Success**: Redirects to the login page.
  - **Failure**: Returns validation errors.
    
#### User Login

- **URL**: ```/login```
- **Method**: ```POST```
- **Request Body**:
  ```JSON
  {
    "email": "john.doe@example.com",
    "password": "password123"
  }
- **Response**:
  - **Success**: Redirects to the login page.
  - **Failure**: Returns validation errors.
 
#### Search Buses

- **URL**: ```/dashboard```
- **Method**: ```POST```
- **Request Body**:
  ```JSON
     {
    "from": "City A",
    "to": "City B",
    "filterDate": "2024-08-14"
     }
- **Response**:
  ```JSON
    {
       "id": 1,
       "fromDestination": "City A",
       "toDestination": "City B",
       "time": "10:00 AM",
       "busName": "Bus 101",
       "price": 500
    }
  
#### Book Ticket

- **URL**: ```/dashboard/book/{id}```
- **Method**: ```GET```
- **Response**: Displays the booking page for the selected bus.

#### Finalize Booking

- **URL**: ```/dashboard/booking```
- **Method**: ```POST```
- **Request Body**:
  ```JSON
  {
    "busId": 1,
    "userId": 1,
    "seatNumber": "A1"
  }
- **Response**:
  - **Success**: Redirects to the login page.
  - **Failure**: Returns validation errors.
 
#### View Bookings

- **URL**: ```/myBooking```
- **Method**: ```GET```
- **Response**:
  ```JSON
    {
        "id": 1,
        "busName": "Bus 101",
        "fromDestination": "City A",
        "toDestination": "City B",
        "time": "10:00 AM",
        "price": 500,
        "status": "Booked"
    }
  
#### Cancel Booking

- **URL**: ```/myBooking/cancel/{id}```
- **Method**: ```GET```
- **Response**:
  - **Success**: Redirects to the user’s bookings page with a success message.
  - **Failure**: Returns an error message if the booking is already canceled.

  
