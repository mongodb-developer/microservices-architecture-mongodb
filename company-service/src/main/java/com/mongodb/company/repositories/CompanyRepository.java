package com.mongodb.company.repositories;

import com.mongodb.company.models.CompanyEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository {

    CompanyEntity save(CompanyEntity companyEntity);

    List<CompanyEntity> findAll();

    CompanyEntity findOneById(String id);

    CompanyEntity findOneByName(String name);

    long deleteAll();
}
