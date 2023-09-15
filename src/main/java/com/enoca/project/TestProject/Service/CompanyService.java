package com.enoca.project.TestProject.Service;

import com.enoca.project.TestProject.Models.Company;
import com.enoca.project.TestProject.Repository.CompanyRepository;
import com.enoca.project.TestProject.Service.interfaces.ICompanyService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompanyService {
    private final CompanyRepository IcompanyRepository;

    public CompanyService(CompanyRepository icompanyRepository) {
        IcompanyRepository = icompanyRepository;
    }

    public List<Company> getAllCompany() {
        return IcompanyRepository.findAll();
    }

    public Company getCompanyById(int id) {
        return IcompanyRepository.findById(id).orElse(null);
    }

    public void addCompany(Company company) {
        IcompanyRepository.save(company);
    }

    public void updateCompany(Company company) {
        IcompanyRepository.save(company);
    }

    public void deleteCompany(int id) {
        IcompanyRepository.deleteById(id);
    }
}
