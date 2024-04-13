package com.mongodb.employee.controllers;

import com.mongodb.employee.dtos.EmployeeDTO;
import com.mongodb.employee.exceptions.EntityNotFoundException;
import com.mongodb.employee.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("employee")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO postEmployee(@RequestBody EmployeeDTO employeeDTO) {
        LOGGER.info("POST /employee {}", employeeDTO.fullName());
        return employeeService.save(employeeDTO);
    }

    @GetMapping("employees")
    public List<EmployeeDTO> getCompanies() {
        LOGGER.info("GET /employees");
        return employeeService.findAll();
    }

    @GetMapping("employee/id/{id}")
    public EmployeeDTO getEmployee(@PathVariable("id") String id) {
        LOGGER.info("GET /employee/id/{}", id);
        return employeeService.findOne(id);
    }

    @DeleteMapping("employees")
    public long deleteEmployees() {
        LOGGER.info("DELETE /employees");
        return employeeService.deleteAll();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "MongoDB didn't find any document.")
    public final void handleNotFoundExceptions(EntityNotFoundException e) {
        LOGGER.info("=> Employee not found: {}", e.toString());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public final void handleAllExceptions(RuntimeException e) {
        LOGGER.error("=> Internal server error.", e);
    }
}
