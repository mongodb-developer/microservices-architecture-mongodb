package com.mongodb.employee.services;


import com.mongodb.employee.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO save(EmployeeDTO EmployeeDTO);

    List<EmployeeDTO> findAll();

    EmployeeDTO findOne(String id);

    long deleteAll();
}
