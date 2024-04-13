# Microservices Architecture with MongoDB

This repository contains a set of templates to help you create a Java Spring Boot microservices architecture with MongoDB.

In this repo you'll find: 

- A config-server on port 8888
- A service-registry on port 8761
- An api-gateway on port 8080
- Two microservices:
  - company-service on port 8081
  - employee-service on port 8082

## Prerequisites

- Docker (for local ephemeral MongoDB nodes or you can use MongoDB Atlas)
- Java 21
- Maven 3.6.3+

## Getting Started

### MongoDB

Microservices are supposed to be independent of each others. For this reason, we need two MongoDB instances: one for each microservice.

**With Docker** 

The following script will start two local single node replica set nodes on port 27017 and 27018.
```bash
./1_docker-start-mongodb.sh
```

When you are done:

```bash
./3_docker-stop-mongodb.sh
```

**With MongoDB Atlas**

You can create two tests clusters on MongoDB Atlas and overwrite the default MongoDB URIs before starting the two microservices.

For the `company_service` use:

```bash
export MONGODB_URI_1="ATLAS_URI_HERE"
```

For the `employee_service` use:

```bash
export MONGODB_URI_2="ATLAS_URI_HERE"
```

### Start Spring Boot projects

You need to open five terminals: one for each folder. Then you can start the Spring Boot projects.

Start with the config-server as the microservices need this one running to be able to retrieve their configuration.

```bash
cd config-server
mvn clean spring-boot:run
```

```bash
cd service-registry
mvn clean spring-boot:run
```

```bash
cd company-service
mvn clean spring-boot:run
```

```bash
cd employee-service
mvn clean spring-boot:run
```

```bash
cd api-gateway
mvn clean spring-boot:run
```

## Test the REST APIs

The `api-gateway` running on port 8080 can distribute the queries to the relevant microservices.

You can test all the APIs using the script:

```bash
./2_api-tests.sh
```

> Note that the script is only targeting the port 8080 of the api-gateway.
