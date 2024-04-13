package com.mongodb.company.controllers;

import com.mongodb.company.dtos.CompanyDTO;
import com.mongodb.company.exceptions.EntityNotFoundException;
import com.mongodb.company.services.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
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
    public CompanyDTO postCompany(@RequestBody CompanyDTO companyDTO) {
        LOGGER.info("POST /company {}", companyDTO.name());
        return companyService.save(companyDTO);
    }

    @GetMapping("companies")
    public List<CompanyDTO> getCompanies() {
        LOGGER.info("GET /companies");
        return companyService.findAll();
    }

    @GetMapping("company/id/{id}")
    public CompanyDTO getCompanyById(@PathVariable("id") String id) {
        LOGGER.info("GET /company/id/{}", id);
        return companyService.findOneById(id);
    }

    @GetMapping("company/name/{name}")
    public CompanyDTO getCompanyByName(@PathVariable("name") String name) {
        LOGGER.info("GET /company/name/{}", name);
        return companyService.findOneByName(name);
    }

    @DeleteMapping("companies")
    public long deleteCompanies() {
        LOGGER.info("DELETE /companies");
        return companyService.deleteAll();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "MongoDB didn't find any document.")
    public final void handleNotFoundExceptions(EntityNotFoundException e) {
        LOGGER.info("=> Company not found: {}", e.toString());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public final void handleAllExceptions(RuntimeException e) {
        LOGGER.error("=> Internal server error.", e);
    }
}
