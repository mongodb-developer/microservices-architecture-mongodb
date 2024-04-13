package com.mongodb.employee.dtos;

import com.mongodb.employee.models.EmployeeEntity;
import org.bson.types.ObjectId;

import java.util.Date;

public record EmployeeDTO(String id, String firstName, String lastName, String company, String headquarters,
                          Date created, Date joined, int salary) {

    public EmployeeDTO(EmployeeEntity p, CompanyDTO c) {
        this(p.getId() == null ? new ObjectId().toHexString() : p.getId().toHexString(), p.getFirstName(),
             p.getLastName(), p.getCompany(), c.headquarters(), c.created(), p.getJoined(), p.getSalary());
    }

    public EmployeeEntity toEmployeeEntity() {
        ObjectId _id = id == null ? new ObjectId() : new ObjectId(id);
        return new EmployeeEntity(_id, firstName, lastName, company, joined, salary);
    }

    public String fullName() {
        return firstName + " " + lastName;
    }
}
