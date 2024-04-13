package com.mongodb.company.services;


import com.mongodb.company.dtos.CompanyDTO;

import java.util.List;

public interface CompanyService {

    CompanyDTO save(CompanyDTO CompanyDTO);

    List<CompanyDTO> findAll();

    CompanyDTO findOneById(String id);

    CompanyDTO findOneByName(String name);

    long deleteAll();
}
