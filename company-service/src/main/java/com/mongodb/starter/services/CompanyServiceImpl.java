package com.mongodb.starter.services;

import com.mongodb.starter.dtos.CompanyDTO;
import com.mongodb.starter.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public CompanyDTO save(CompanyDTO CompanyDTO) {
        return new CompanyDTO(companyRepository.save(CompanyDTO.toCompanyEntity()));
    }

    @Override
    public List<CompanyDTO> findAll() {
        return companyRepository.findAll().stream().map(CompanyDTO::new).toList();
    }

    @Override
    public CompanyDTO findOne(String id) {
        return new CompanyDTO(companyRepository.findOne(id));
    }

}
