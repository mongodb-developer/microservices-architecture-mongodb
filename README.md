# Microservices Architecture with MongoDB

This repository contains a set of templates to help you create a Java Spring Boot microservices architecture with MongoDB.

## Example API Calls

### Companies

```bash
curl -X 'POST' \
  'http://localhost:8080/api/company' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "MongoDB",
  "headquarters": "New York",
  "created": "2009-02-11"
}'
```

```bash
curl -X 'GET' 'http://localhost:8080/api/companies' -H 'accept: */*'
```

```bash
curl -X 'GET' 'http://localhost:8080/api/company/6617441637a62d47a22e4808' -H 'accept: */*'
```

### Employees

```bash
curl -X 'POST' \
  'http://localhost:8081/api/employee' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "firstName": "Maxime",
  "lastName": "Beugnet",
  "company": "MongoDB",
  "joined": "2018-02-12",
  "salary": 54321
}'
```

```bash
curl -X 'GET' 'http://localhost:8081/api/employees' -H 'accept: */*'
```

```bash
curl -X 'GET' 'http://localhost:8081/api/employee/66175d38898ee935f384a4df' -H 'accept: */*'
```