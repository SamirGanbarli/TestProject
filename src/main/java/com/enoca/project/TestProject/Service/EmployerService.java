package com.enoca.project.TestProject.Service;

import com.enoca.project.TestProject.Models.Employers;
import com.enoca.project.TestProject.Repository.EmployerRepository;
import com.enoca.project.TestProject.Service.interfaces.IEmployerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService implements IEmployerService {
    private final EmployerRepository IemployerRepository;
    public EmployerService(EmployerRepository iemployerRepository) {
        IemployerRepository = iemployerRepository;
    }

    public List<Employers> getAllEmployers() {
        return IemployerRepository.findAll();
    }

    public Employers getEmployersById(int id) {
        return IemployerRepository.findById(id).orElse(null);
    }

    public void addEmployers(Employers employers) {
        IemployerRepository.save(employers);
    }

    public void updateEmployers(Employers employers) {
        IemployerRepository.save(employers);
    }

    public void deleteEmployers(int id) {
        IemployerRepository.deleteById(id);
    }
}
