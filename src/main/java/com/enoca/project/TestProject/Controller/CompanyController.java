package com.enoca.project.TestProject.Controller;

import com.enoca.project.TestProject.Models.Company;
import com.enoca.project.TestProject.Service.CompanyService;
import com.enoca.project.TestProject.Service.interfaces.ICompanyService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/comp")
public class CompanyController {
    private final ICompanyService companyService;
    public CompanyController (CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/addCompany")
    public void addCompanyToDb(@RequestBody Company company){
        companyService.addCompany(company);
    }

    @GetMapping("/getCompanies")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompany();
    }

    @GetMapping("/getCompany/{id}")
    public Company getCompanyById(@PathVariable Integer id) {
        Company company = companyService.getCompanyById(id);

        if (Objects.nonNull(company)) {
            return companyService.getCompanyById(id);
        } else {
            return null;
        }
    }



    @PutMapping("/updateCompanyById/{id}")
    public ResponseEntity<Void> updateCompanyById(@PathVariable Integer id, @RequestBody Company company) {
        Company tempCompany = companyService.getCompanyById(id);

        if (tempCompany != null) {
            companyService.updateCompany(company);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteCompanyById/{id}")
    public ResponseEntity<Void> deleteCompanyById(@PathVariable Integer id){
        Company tempCompany = companyService.getCompanyById(id);

        if (Objects.nonNull(tempCompany)) {
            companyService.deleteCompany(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
