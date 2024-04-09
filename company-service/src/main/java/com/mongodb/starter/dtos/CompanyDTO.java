package com.mongodb.starter.dtos;

import com.mongodb.starter.models.CompanyEntity;
import org.bson.types.ObjectId;

import java.util.Date;

public record CompanyDTO(String id, String name, String headquarters, Date created) {

    public CompanyDTO(CompanyEntity p) {
        this(p.getId() == null ? new ObjectId().toHexString() : p.getId().toHexString(), p.getName(),
             p.getHeadquarters(), p.getCreated());
    }

    public CompanyEntity toCompanyEntity() {
        ObjectId _id = id == null ? new ObjectId() : new ObjectId(id);
        return new CompanyEntity(_id, name, headquarters, created);
    }
}
