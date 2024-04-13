package com.mongodb.company.repositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.company.models.CompanyEntity;
import jakarta.annotation.PostConstruct;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoDBCompanyRepository implements CompanyRepository {

    private final MongoClient client;
    private MongoCollection<CompanyEntity> companyCollection;

    public MongoDBCompanyRepository(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        companyCollection = client.getDatabase("test").getCollection("companies", CompanyEntity.class);
    }

    @Override
    public CompanyEntity save(CompanyEntity companyEntity) {
        companyEntity.setId(new ObjectId());
        companyCollection.insertOne(companyEntity);
        return companyEntity;
    }

    @Override
    public List<CompanyEntity> findAll() {
        return companyCollection.find().into(new ArrayList<>());
    }

    @Override
    public CompanyEntity findOneById(String id) {
        return companyCollection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public CompanyEntity findOneByName(String name) {
        return companyCollection.find(eq("name", name)).first();
    }

    @Override
    public long deleteAll() {
        return companyCollection.deleteMany(new Document()).getDeletedCount();
    }

}
