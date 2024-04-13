package com.mongodb.employee.repositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.employee.models.EmployeeEntity;
import jakarta.annotation.PostConstruct;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoDBEmployeeRepository implements EmployeeRepository {

    private final MongoClient client;
    private MongoCollection<EmployeeEntity> employeeCollection;

    public MongoDBEmployeeRepository(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        employeeCollection = client.getDatabase("test").getCollection("employees", EmployeeEntity.class);
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        employeeEntity.setId(new ObjectId());
        employeeCollection.insertOne(employeeEntity);
        return employeeEntity;
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return employeeCollection.find().into(new ArrayList<>());
    }

    @Override
    public EmployeeEntity findOne(String id) {
        return employeeCollection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public long deleteAll() {
        return employeeCollection.deleteMany(new Document()).getDeletedCount();
    }

}
