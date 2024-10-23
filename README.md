# Digital Banking API - Madis / Mansa Bank Integration (madis-mansacard-service)

This Service is a **Spring Boot** and **Java 21** implementation of the **madis-mansacard-service** for **Mansa Finance**. It provides RESTful endpoints those interact with Mansa Bank's core banking system, supporting operations like agent account activation, credit card management, balance inquiries, and transaction history retrieval.

## Key Features
- **Agent Account Activation**: Secure activation of agent accounts using AES-encrypted PINs.
- **Credit Card Management**:
  - Create new credit cards linked to customer accounts.
  - Activate, deactivate, block, or unblock cards.
  - Retrieve card balances and recharge funds.
- **Transaction History**: Access transaction history for any card.
- **Batch Card Creation**: Generate anonymous credit cards in bulk.
- **Security**: All sensitive data is encrypted using **AES 256 CBC mode** to ensure secure communication.

## Technologies Used
- **Java 21**
- **Spring Boot (WebFlux)** for reactive REST APIs.
- **WebClient** for making HTTP requests to Madis Bank's core system.
- **Jackson** for JSON processing.
- **Lombok** for reducing boilerplate code.
- **Maven** for project build and dependency management.

## API Endpoints

| Endpoint                           | Method | Description                                                   |
|-------------------------------------|--------|---------------------------------------------------------------|
| `/activationagent/madis`            | POST   | Activate an agent account using a secure PIN.                  |
| `/create_card/madis`                | POST   | Create a new credit card linked to a customer account.         |
| `/operation_card/madis`             | POST   | Activate, deactivate, block, or unblock a credit card.         |
| `/balance_card/madis`               | POST   | Retrieve the balance of a credit card.                         |
| `/recharge_card/madis`              | POST   | Recharge a credit card with a specified amount.                |
| `/history/madis`                    | POST   | Retrieve transaction history for a credit card.                |

## Running the Application

### Prerequisites
Ensure you have the following installed:
- **Java 21** or later
- **Maven** (optional, if not using the provided Maven wrapper)

### Clone the Repository
```bash
git clone https://github.com/yourusername/digital-banking-api-madis.git
cd digital-banking-api-madis
```

# Running the Application with Maven
To run the application using the Maven wrapper:

```bash
./mvnw spring-boot:run
```
# Building and Running the JAR
Alternatively, you can build the project and run the JAR file:

```bash
./mvnw clean install
java -jar target/digital-banking-api-madis.jar
```

The application will start on **http://localhost:xxxx**.

# Testing the API
You can test the API endpoints using tools like Postman or curl. Make sure to send requests with the appropriate JSON body.

## Request and Response Examples
### Create Credit Card (/create_card/madis)
Request:
```json
{
  "numeroAgent": "123456789",
  "numeroClient": "987654321",
  "prenomClient": "John",
  "nomClient": "Doe",
  "idTypeClient": "CNI",
  "idScanVerso": "base64string",
  "idScanRecto": "base64string",
  "idNumberClient": "ID12345",
  "pinAgent": "encryptedPin"
}
```

Response:
```json
{
  "operationType": "createCreditCard",
  "status": "SUCCESS",
  "code": "200",
  "numeroClient": "987654321",
  "compteClient": "173624209",
  "carte": "5556-XXXX-XXXX-4221",
  "address": "Abidjan Cocody Bonoumin",
  "timestamp": "2022-10-28 03:07:59"
}
```

# Security
All sensitive data, such as PINs, is encrypted using **AES 256 CBC** mode to ensure secure communication between clients and the server. Encryption ensures that all personal and sensitive information is safeguarded.

## Note:
**It is part of Madis microservice architecture so it will be better to read the docker-compose or kubernetes configuration file for installation and running purpose.**
