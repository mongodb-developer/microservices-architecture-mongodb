package com.mongodb.starter.services;


import com.mongodb.starter.dtos.CompanyDTO;

import java.util.List;

public interface CompanyService {

    CompanyDTO save(CompanyDTO CompanyDTO);

    List<CompanyDTO> findAll();

    CompanyDTO findOne(String id);

}
