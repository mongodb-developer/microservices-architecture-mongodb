# Quick Start: Java, Spring Boot & MongoDB Template

## Blog Post

The code in this repository is discussed in [this blog post](https://www.mongodb.com/developer/code-examples/java/rest-apis-java-spring-boot/) in the [MongoDB Developer Center](https://www.mongodb.com/developer/).

## Supported versions:

- Java 21
- Spring boot 3.2.4
- MongoDB 7.0
- MongoDB Java driver 5.0.1
- Maven 3.6.3
- OpenAPI 3

## MongoDB Atlas

- Get started with a Free Tier Cluster on [MongoDB Atlas](https://www.mongodb.com/cloud/atlas).
- Read this blog post: [Quick Start - Getting your Free MongoDB Atlas Cluster](https://developer.mongodb.com/quickstart/free-atlas-cluster).
- You will need to update the default MongoDB URI `spring.data.mongodb.uri` in the `application.properties` file or set an environment variable: `export MONGODB_URI=mongodb://localhost:27017`.

## Commands

- Start the server in a console with `mvn spring-boot:run`.
- If you add some Unit Tests, you would start them with `mvn clean test`.
- You can start the end-to-end tests with `mvn clean integration-test`.
- You can build the project with : `mvn clean package`.
- You can run the project with the fat jar and the embedded Tomcat: `java -jar target/java-spring-boot-mongodb-starter-1.0.0.jar` but I would use a real tomcat in production.

## Project Loom & Virtual Threads

- This project starter supports Virtual Threads thanks to:
  - JDK 21
  - Spring 3.2.0+.
  - `spring.threads.virtual.enabled=true` in the `application.properties`

## Swagger & OpenAPI 3
- `springdoc-openapi-starter-webmvc-ui` library dependency is in the `pom.xml`.
- No configuration required.
- The Swagger UI can be seen at [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).
- The JSON Open API documentation 3.0.1 is at [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs).
- The YAML Open API documentation 3.0.1 is at [http://localhost:8080/v3/api-docs.yaml](http://localhost:8080/v3/api-docs.yaml).
- You can also try the entire REST API directly from the Swagger web interface!

## Features showcase
This project showcases several features of MongoDB:

- MongoDB multi-document ACID transactions for 3 functions. See `MongoDBPersonRepository.saveAll()`.
- MongoDB Aggregation pipeline. See `MongoDBPersonRepository.getAverageAge()`.
- Implementation of basic CRUD queries. See `MongoDBPersonRepository.java`.
- MongoDB typed collection with automatic mapping to POJOs using codecs: See `ConfigurationSpring.java`.
- How to manipulate correctly ObjectId across, the REST API, the POJOs and the database itself. See the main trick in `Person.java`.

And some other cool stuff:
- You can change the default Spring Boot logo by adding a banner.txt file in your properties.
- You don't have to use Spring Data MongoDB. The MongoDB driver is more flexible and already provides everything you need to code efficiently and optimise your queries correctly.

## Example API Calls

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

## Author

Maxime Beugnet

- maxime@mongodb.com
- MaBeuLux88 on [GitHub](https://github.com/mabeulux88)
- MaBeuLux88 in the [MongoDB Developer Community forum](https://www.mongodb.com/community/forums/u/MaBeuLux88/summary).
