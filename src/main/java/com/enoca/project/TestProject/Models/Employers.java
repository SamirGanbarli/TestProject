package com.enoca.project.TestProject.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Employers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employerId;
    private String employerNameSurname;
    private String employerExperience;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Employers(Integer employerId, String employerNameSurname, String employerExperience, Company companyId) {
        this.employerId = employerId;
        this.employerNameSurname = employerNameSurname;
        this.employerExperience = employerExperience;
        this.company = companyId;
    }

    public Employers() {
    }

    public Integer getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Integer employerId) {
        this.employerId = employerId;
    }

    public String getEmployerNameSurname() {
        return employerNameSurname;
    }

    public void setEmployerNameSurname(String employerNameSurname) {
        this.employerNameSurname = employerNameSurname;
    }

    public String getEmployerExperience() {
        return employerExperience;
    }

    public void setEmployerExperience(String employerExperience) {
        this.employerExperience = employerExperience;
    }

    public Company getCompanyId() {
        return company;
    }

    public void setCompanyId(Company companyId) {
        this.company = companyId;
    }
}
