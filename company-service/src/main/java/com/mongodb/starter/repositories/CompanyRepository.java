package com.mongodb.starter.repositories;

import com.mongodb.starter.models.CompanyEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository {

    CompanyEntity save(CompanyEntity companyEntity);

    List<CompanyEntity> findAll();

    CompanyEntity findOne(String id);

}
