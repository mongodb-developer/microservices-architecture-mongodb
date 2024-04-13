package com.mongodb.employee.services;

import com.mongodb.employee.dtos.CompanyDTO;
import com.mongodb.employee.dtos.EmployeeDTO;
import com.mongodb.employee.exceptions.EntityNotFoundException;
import com.mongodb.employee.models.EmployeeEntity;
import com.mongodb.employee.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, RestTemplate restTemplate) {
        this.employeeRepository = employeeRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        CompanyDTO companyDTO = getCompany(employeeDTO.company());
        return new EmployeeDTO(employeeRepository.save(employeeDTO.toEmployeeEntity()), companyDTO);
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll().stream().map(e -> new EmployeeDTO(e, getCompany(e.getCompany()))).toList();
    }

    @Override
    public EmployeeDTO findOne(String id) {
        EmployeeEntity employee = employeeRepository.findOne(id);
        if (employee == null) {
            throw new EntityNotFoundException(id);
        }
        CompanyDTO companyDTO = getCompany(employee.getCompany());
        return new EmployeeDTO(employee, companyDTO);
    }

    @Override
    public long deleteAll() {
        return employeeRepository.deleteAll();
    }

    private CompanyDTO getCompany(String company) {
        String url = "http://company-service/api/company/name/";
        CompanyDTO companyDTO = restTemplate.getForObject(url + company, CompanyDTO.class);
        if (companyDTO == null) {
            throw new EntityNotFoundException("Company not found: ", company);
        }
        return companyDTO;
    }

}
