# User Management API with JWT Authentication

# Overview

This project is designed to provide an API for managing users with JWT authentication. It supports user registration, login, and management with role-based access control (RBAC) for users and administrators.

# Technologies Used

~Java (Spring Boot)
~Spring Security for authentication and authorization
~JWT (JSON Web Tokens) for stateless authentication
~Spring Data JPA for database interaction

# Features

1. User Registration: Allows users to register with a username and password.
2. User Authentication: Users can log in with their username and password to receive a JWT token.
3. Role-based Access Control: Differentiates between user and admin roles for route protection.
4. JWT Authentication: Uses JWT tokens to secure the endpoints.
5. Exception Handling: Custom exception for "user not found."

# End Points

1. POST /register - User Registration
This endpoint allows new users to register by providing a username and password.

Request Body:
{
  "username": "exampleUser",
  "password": "password123"
}

Response:
~ 201 Created: User successfully registered.
~ 400 Bad Request: If the request body is missing or invalid.

2. POST /login - User Login
This endpoint allows users to log in using their username and password. Upon successful authentication, the server returns a JWT token.

Request Body:
{
  "username": "exampleUser",
  "password": "password123"
}

Response:
200 OK: Returns JWT token.
{
  "token": "jwt_token_here"
}
~401 Unauthorized: If the username or password is incorrect.

3. GET /user/{username} - Get User Details
This endpoint retrieves details of the user based on their username. Only accessible by authenticated users.

Path Parameter:

username: The username of the user to fetch.
Response:

200 OK: Returns user details.
{
  "username": "exampleUser",
  "role": "USER"
}
404 Not Found: If the user does not exist.

4. GET /admin/dashboard - Admin Dashboard (Protected Route)
This endpoint is only accessible to users with an admin role. It returns an admin dashboard.

Response:
~ 200 OK: Returns admin data.
~ 403 Forbidden: If the user does not have the admin role.

# Authentication & Authorization

JWT Authentication: The application uses JWT tokens for stateless authentication. The token is included in the Authorization header of requests to protected endpoints.
Authorization Header Format: Bearer <JWT_TOKEN>
Role-based Access: The system differentiates between USER and ADMIN roles:
USER: Basic user with access to their own data.
ADMIN: Admin users have access to all user data and protected admin endpoints.

# Implementation Details

User Registration
When a user registers, their password is hashed using a secure hashing algorithm (e.g., BCrypt). The hashed password is then stored in the database, and the user is saved with the role USER.

JWT Token Generation
Upon successful login, the server generates a JWT token containing the username and role as claims. The token is signed with a secret key to prevent tampering. This token is returned to the user and should be sent with subsequent requests to access protected routes.

JWT Token Validation
Each request to a protected endpoint checks the validity of the provided JWT token. If the token is valid, the user's identity is extracted from the token, and access is granted. If the token is invalid or expired, a 401 Unauthorized response is returned.

Role-Based Route Protection
The routes requiring authentication and authorization are protected using Spring Security. The @PreAuthorize or @Secured annotations are used to enforce role-based access control.

Exception Handling
The system includes custom exception handling for cases such as:

UserNotFoundException: Thrown when a user is not found during authentication or user retrieval.
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}

# Setup Instructions

1. Clone the Repository: Clone the repository to your local machine using:
git clone <repository_url>
2. Build the Application:
If you're using Maven:
mvn clean install
If you're using Gradle:
gradle build
3. Run the Application: You can run the application using:
mvn spring-boot:run
or from your IDE by running the main class Application.java.
4. Testing the Endpoints: Use Postman or any HTTP client to test the API. Start by registering a new user, then log in to get the JWT token. Use the token to access protected endpoints.
 
# Conclusion

This API provides basic functionality for managing users, authenticating them with JWT tokens, and using role-based access control for route protection. It supports the user registration, login, and administration dashboard features, with JWT-based authentication ensuring that only authorized users can access specific routes.
