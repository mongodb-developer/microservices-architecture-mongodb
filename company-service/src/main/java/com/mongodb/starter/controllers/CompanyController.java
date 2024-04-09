package com.mongodb.starter.controllers;

import com.mongodb.starter.dtos.CompanyDTO;
import com.mongodb.starter.services.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyController {

    private final static Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("company")
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyDTO postCompany(@RequestBody CompanyDTO CompanyDTO) {
        return companyService.save(CompanyDTO);
    }

    @GetMapping("companies")
    public List<CompanyDTO> getCompanies() {
        return companyService.findAll();
    }

    @GetMapping("company/{id}")
    public ResponseEntity<CompanyDTO> getCompany(@PathVariable String id) {
        CompanyDTO CompanyDTO = companyService.findOne(id);
        if (CompanyDTO == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(CompanyDTO);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final Exception handleAllExceptions(RuntimeException e) {
        LOGGER.error("Internal server error.", e);
        return e;
    }
}
