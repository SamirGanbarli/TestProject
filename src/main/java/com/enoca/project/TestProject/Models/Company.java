package com.enoca.project.TestProject.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Integer companyId;
    @Column(name = "company_name")
    private String companyName;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Employers> employersList;

    public Company(Integer companyId, String companyName, List<Employers> employersList) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.employersList = employersList;
    }

    public Company() {
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Employers> getEmployersList() {
        return employersList;
    }

    public void setEmployersList(List<Employers> employersList) {
        this.employersList = employersList;
    }
}
