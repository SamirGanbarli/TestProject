package com.enoca.project.TestProject.Service.interfaces;

import com.enoca.project.TestProject.Models.Company;

import java.util.List;

public interface ICompanyService {
    List<Company> getAllCompany();

    Company getCompanyById(int id);

    void addCompany(Company company);

    void updateCompany(Company company);

    void deleteCompany(int id);
}
