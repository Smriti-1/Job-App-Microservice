A Spring Boot–based **Job Application system** built using **microservices architecture**.  
The application manages **Jobs, Companies, and Reviews**, all of which are **interlinked** and communicate using **Eureka Service Discovery** and **Feign Clients**.

---

## Tech Stack

- Java  
- Spring Boot  
- Spring Cloud Netflix Eureka  
- OpenFeign  
- REST APIs  
- Maven
- Resillience4j

---

## Microservices

### Eureka Server
- Service discovery and registration
- All microservices register with Eureka

### Job Service
- Core microservice of the application
- Manages all job-related operations
- Acts as the link between Company and Review services

### Company Service
- Manages company details
- Fetches all jobs and reviews related to a company via Job Service

### Review Service
- Manages reviews for companies
- Reviews are associated with companies and jobs

---

## Features

### Job Management
- Create job
- Fetch all jobs
- Fetch job by ID
- Update job
- Delete job

### Company Management
- Create company
- Fetch all companies
- Fetch company by ID
- Update company
- Delete company
- Fetch company with all associated jobs and reviews

### Review Management
- Create review
- Fetch reviews by company
- Update review
- Delete review

---

## Service Communication

- Eureka Server handles service discovery
- Feign Clients are used for inter-service communication
- No hardcoded service URLs
- Job Service connects Company and Review services

---

## Project Structure
job-application/
│
├── eureka-server/
├── job-service/
├── company-service/
├── review-service/
└── README.md



---

## How to Run

1. Start Eureka Server  
2. Start Job Service  
3. Start Company Service  
4. Start Review Service  

All services will automatically register with Eureka and communicate using Feign.

---

## Highlights

- Microservices architecture
- CRUD operations for Jobs, Companies, and Reviews
- Service discovery with Eureka
- Inter-service communication using Feign
- Scalable and extensible design

---

## Future Enhancements

- API Gateway
- Security (JWT / OAuth)
- Docker and Kubernetes
- Centralized Config Server

---

## Author
Smriti
Smriti-1/Job-App-Microservice
