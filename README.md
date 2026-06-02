# Patient Management Microservices System

## Overview

This project is a backend-based microservices architecture built using Java Spring Boot.
It demonstrates modern backend engineering concepts including:

* REST APIs
* Microservices architecture
* gRPC communication
* Apache Kafka event-driven communication
* API Gateway
* JWT Authentication & Authorization
* Docker containerization
* Integration testing

The system is composed of multiple independent services communicating through synchronous and asynchronous mechanisms.

---

# Architecture

## Services

### Patient Service

Handles:

* Patient CRUD operations
* Validation
* Business logic
* Kafka event publishing
* gRPC client communication with Billing Service

### Billing Service

Handles:

* Billing account creation
* gRPC server implementation


### Analytics Service

Handles:

* Kafka consumer logic
* Event processing


### Auth Service

Handles:

* User authentication
* JWT token generation
* JWT token validation
* Password encryption using Spring Security

### API Gateway

Handles:

* Centralized routing
* JWT validation filter
* Authentication integration
* Request forwarding to services

---

# Technologies Used

## Backend

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Security

## Database

* PostgreSQL
* H2 In-Memory Database (initial development)

## Communication

* REST APIs
* gRPC
* Apache Kafka


## Containerization

* Docker
* Docker Networking

## Authentication

* JWT (JSON Web Tokens)

## Testing

* Integration Testing
* Spring Boot Test

---

# Microservices Communication

## REST Communication

Frontend communicates with services using REST APIs.

Example:

```text
Frontend → API Gateway → Patient Service
```

## gRPC Communication

Patient Service communicates with Billing Service using gRPC.

Example:

```text
Patient Service → Billing Service
```

## Kafka Communication

Patient Service publishes events to Kafka.

Analytics Service consumes those events asynchronously.

Example:

```text
Patient Service → Kafka → Analytics Service
```

---

# Features Implemented

## Patient Service

* Create Patient
* Get Patient
* Update Patient
* Delete Patient
* Request Validation
* Global Exception Handling
* OpenAPI Documentation
* PostgreSQL Integration
* Docker Support
* gRPC Client Integration
* Kafka Producer Integration

## Billing Service

* gRPC Server
* Protobuf Definitions
* Billing Account Creation
* Docker Support

## Analytics Service

* Kafka Consumer
* Event Processing
* Docker Support

## Auth Service

* User Login
* JWT Generation
* JWT Validation
* Password Encryption
* Database Integration
* Docker Support

## API Gateway

* Request Routing
* JWT Validation Filter
* Authentication Integration
* Exception Handling

## Testing

* Login Integration Tests
* Unauthorized Access Tests
* Patient Endpoint Integration Tests

---

# gRPC Setup

The project uses:

* Protocol Buffers (protobuf)
* gRPC server/client communication
* Blocking stubs
* Spring Boot gRPC integration

Proto files are used to generate:

* Request classes
* Response classes
* Client stubs
* Server base implementations

---

# Kafka Setup

Kafka is used for asynchronous event-driven communication.

## Producer

Patient Service publishes events.

## Consumer

Analytics Service consumes events.

## Event Example

```json
{
  "eventType": "PATIENT_CREATED",
  "patientId": "101"
}
```

---

# Security

Authentication is implemented using JWT.

Flow:

```text
User Login → JWT Token Generated
          ↓
Client Sends Token
          ↓
API Gateway Validates Token
          ↓
Request Forwarded To Services
```

---

# Dockerized Services

All services are containerized using Docker.

Each service contains:

* Dockerfile
* Independent runtime
* Isolated environment

Docker networking enables inter-service communication.

---

# Integration Testing

Implemented integration tests for:

* Login endpoints
* JWT authentication
* Unauthorized access
* Patient APIs

---

# Learning Objectives

This project was built to learn:

* Microservices architecture
* Service-to-service communication
* Event-driven systems
* API Gateway patterns
* Authentication systems
* Containerization
* Distributed system concepts

---


