package com.example.JobApplication1.company;

import java.util.List;

public interface CompanyService {

    public Company addCompany(Company company);
    public List<Company> getAllCompany();

    public  Company getById(Long id);

    public   Company updateCompany(Long id,Company company);

    public  boolean deleteCompanyId(Long id);
}
