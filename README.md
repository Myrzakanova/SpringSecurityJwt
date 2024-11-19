# **User Management API with JWT Authentication**

## **Project Overview**

This project implements a **RESTful API** for **user registration**, **authentication**, and **management**. It uses **JSON Web Token (JWT)** for securing API routes and provides **role-based access control** for different types of users (e.g., **user** and **admin**). The project is built using **Spring Boot** and supports basic operations like **user registration**, **login**, and **profile management**.

## **Features**

- **User Registration**: Allows users to create an account by providing necessary information.
- **User Login**: Users can authenticate using their credentials and receive a **JWT token**.
- **Role-Based Access Control**: Differentiates users with roles like **user** and **admin**.
- **JWT Authentication**: Secure routes using **JWT** for authenticated access.
- **Profile Management**: Allows users to manage their profiles and update personal details.

## **Technologies Used**

- **Spring Boot**: Framework for building the backend.
- **Spring Security**: For implementing **JWT-based** authentication and **role-based access control**.
- **JWT (JSON Web Token)**: For securing API endpoints.
- **H2 Database**: In-memory database for storing user data 
- **Maven**: For managing dependencies.

## **API Endpoints**

### **User Registration**

- **URL**: `/api/auth/register`
- **Method**: `POST`
- **Description**: Registers a new user in the system.
- **Request Body**:

  ```json
  {
    "username": "name",
    "password": "string",
    "email": "example@example.com"
  }
# User Login
- **URL**: /api/auth/login
- **Method**: POST
- **Description**: Logs in an existing user and returns a JWT token for authentication.
- **Request Body**:
{
  "username": "name",
  "password": "string"
}
- **Response**:
{
  "token": "eyJhbGciOiJIUzIlNiJ9.eyJyb2x1IjpbIlJPTEVfQURNSU4iLCJST0xFX1VTRVIiXSwidXN1c19pZCI6IjEiLCJ1c2VybmFtZSI6ImFkbWluIiwiZXhwIjoxNzAzMTU1NzAxLCJzdWIiOiJhZG1pbiJ9.aNHtaBa-7WDXO_MM183MG9wxT00MnMmEwdjgzS0rh0g"
}
# Get User Profile (Protected Route)
- **URL**: /api/user/profile
- **Method**: GET
- **Description**: Returns the profile of the authenticated user.
- **Headers**:
  - **Authorization**: Bearer JWT_TOKEN 
Example:

curl -X GET http://localhost:9080/api/user/profile -H "Authorization: Bearer JWT_TOKEN"

 **Admin Dashboard** 
- **URL**: /api/admin/dashboard
- **Method**: GET
- **Description**: Returns a dashboard for admin users. Only accessible by users with the admin role.
- **Headers**:
  - **Authorization**: Bearer JWT_TOKEN
Example:

curl -X GET http://localhost:9080/api/admin/dashboard -H "Authorization: Bearer JWT_TOKEN"

# Authentication Flow

1. Registration: Users register by providing their username, password, and email.
2. Login: Users authenticate by providing their credentials and receive a JWT token.
3. Authenticated Routes: For protected routes, the JWT token needs to be included in the Authorization header of the request.
4. Role-Based Access: Admin routes require the user to have the admin role, which is determined when the user logs in.

# Setup and Installation

**Prerequisites**

- **Java 11+**
- **Maven** 
- **Postman** 
- **Spring Boot** 
 
# Steps to Set Up the Project
1. Clone the repository: https://github.com/Myrzakanova
2. Build the project:
mvn clean install
3. Run the application:
mvn spring-boot:run
4. The application will run on http://localhost:9080.

# Security Considerations

- All routes requiring authentication will check for a valid JWT token in the Authorization header.
- The token must be prefixed with Bearer.
- The JWT token is issued upon successful login and is valid for a set period.

# Testing the API

You can use tools like Postman or cURL to test the API endpoints. For example, to get the user profile, include the JWT token in the Authorization header:

curl -X GET http://localhost:9080/api/user/profile -H "Authorization: Bearer YeyJhbGciOiJIUzIlNiJ9.eyJyb2x1IjpbIlJPTE
VfQURNSU4iLCJST0xFX1VTRVIiXSwidXN1c19pZCI6IjEiLCJ1c2VybmFtZSI6ImFkbWluIiwiZXhwIjoxNzAzMTU1NzAxLCJzdWIiOiJhZG1pbiJ9.aNHtaBa-7WDXO_MM183MG9wxT00MnMmEwdjgzS0rh0g

**Role-Based Access**

- **User Role**: Basic user with access to their profile and personal - information.
- **Admin Role**: Admin users have access to admin-only routes, such as the admin dashboard. Admins are able to perform administrative tasks in the application.

# Conclusion

This project demonstrates a simple implementation of JWT-based authentication in a user management system. The system supports basic user registration, login, profile management, and role-based access control for different user types.

