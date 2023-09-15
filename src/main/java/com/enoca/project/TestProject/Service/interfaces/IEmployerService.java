package com.enoca.project.TestProject.Service.interfaces;


import com.enoca.project.TestProject.Models.Employers;

import java.util.List;

public interface IEmployerService {
    List<Employers> getAllEmployers();
    Employers getEmployersById(int id);
    void addEmployers(Employers employers);
    void updateEmployers(Employers employers);
    void deleteEmployers(int id);
}
