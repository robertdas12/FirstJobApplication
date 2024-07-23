package com.example.JobApplication1.company.impl;


import com.example.JobApplication1.company.Company;
import com.example.JobApplication1.company.CompanyRepository;
import com.example.JobApplication1.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CompanyServiceImpl implements CompanyService {


  public CompanyServiceImpl(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  CompanyRepository companyRepository;

  @Override
  public Company addCompany(Company company) {
    System.out.println(company);
      Company company1 =    this.companyRepository.save(company);
    System.out.println(company1 + " &&&&");
      return  company1;
  }

  @Override
  public List<Company> getAllCompany() {
    List<Company> companies =   this.companyRepository.findAll();
    if(companies!=null){
      return companies;
    }
    return null;
  }

  @Override
  public Company getById(Long id) {
    Optional<Company> company =  this.companyRepository.findById(id);
     if(company.isPresent()){
          return  company.get();
     }
     else {
        return  null;
     }
  }

  @Override
  public Company updateCompany(Long id, Company company) {
      Optional<Company>  company1 = this.companyRepository.findById(id);
       if(company1.isPresent()){
            Company newcompany =  company1.get();
            newcompany.setDescription(company.getDescription());
            newcompany.setName(company.getName());
            return  newcompany;
       }
    return null;
  }

  @Override
  public boolean deleteCompanyId(Long id) {
        if(companyRepository.existsById(id)){
             companyRepository.deleteById(id);
             return  true;
        }
        else {
           return  false;
        }
  }
}
