package com.mongodb.employee.repositories;

import com.mongodb.employee.models.EmployeeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository {

    EmployeeEntity save(EmployeeEntity employeeEntity);

    List<EmployeeEntity> findAll();

    EmployeeEntity findOne(String id);

    long deleteAll();
}
