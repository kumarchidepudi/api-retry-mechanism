# Retry Mechanism Application

## Overview
This project is a Spring Boot application that demonstrates a retry mechanism for making HTTP calls. It includes a REST controller, a service for making HTTP calls, and a main application class to bootstrap the application.

## Project Structure
- `src/main/java/com/kumar/RetryMechanismApplication.java`: Main class to run the Spring Boot application.
- `src/main/java/com/kumar/web/UserController.java`: REST controller to handle user-related requests.
- `src/main/java/com/kumar/service/CallingService.java`: Service class to make HTTP calls to an external service.

## Technologies Used
- Java
- Spring Boot
- Maven
- SLF4J (for logging)
- RestTemplate (for making HTTP calls)

## Endpoints
- `GET /user/`: Initiates a call to an external service.

## How to Run
1. **Clone the repository:**
    ```sh
    git clone <repository-url>
    cd <repository-directory>
    ```

2. **Build the project using Maven:**
    ```sh
    mvn clean install
    ```

3. **Run the application:**
    ```sh
    mvn spring-boot:run
    ```

4. **Test the endpoint:**
    - You can use the http file to test the endpoint using IntelliJ IDEA's HTTP client.
    - Alternatively, you can use `curl` or Postman to send a `GET` request to `http://localhost:8081/user/`.

## Logging
- The application uses SLF4J for logging.
- Logs are generated for both successful and failed HTTP calls.

## Error Handling
- The `UserController` catches exceptions during the call initiation and logs the error message.
- The `CallingService` catches exceptions during the HTTP call and logs a generic error message.

## Dependencies
- Spring Boot Starter Web
- Spring Boot Starter Logging
- Spring Boot Starter Test (for testing)
- RestTemplate

## License
You can copy as many times you want:)
