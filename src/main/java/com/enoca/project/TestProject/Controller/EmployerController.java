package com.enoca.project.TestProject.Controller;

import com.enoca.project.TestProject.Models.Employers;
import com.enoca.project.TestProject.Service.EmployerService;
import com.enoca.project.TestProject.Service.interfaces.IEmployerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/emp")
public class EmployerController {
    private final IEmployerService employerService;
    public EmployerController (EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getEmployer")
    public List<Employers> getAllEmployers() {
        List<Employers> employersList = employerService.getAllEmployers();
        if (Objects.nonNull(employersList)) {
            return employersList;
        } else {
            return null;
        }
    }

    @GetMapping("/getEmployer/{id}")
    public Employers getEmployerById(@PathVariable Integer id) {
        Employers employer = employerService.getEmployersById(id);

        if (Objects.nonNull(employer)) {
            return employerService.getEmployersById(id);
        } else {
            return null;
        }
    }

    @PostMapping("/addEmployer")
    public void addCEmployerToDb(@RequestBody Employers employers){
        employerService.addEmployers(employers);
    }

    @PutMapping("/updateEmployerById/{id}")
    public ResponseEntity<Void> updateEmployerById(@PathVariable Integer id, @RequestBody Employers employers) {
        Employers tempEmployers = employerService.getEmployersById(id);

        if (tempEmployers != null) {
            employerService.updateEmployers(tempEmployers);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteEmployerById/{id}")
    public ResponseEntity<Void> deleteEmployerById(@PathVariable Integer id){
        Employers tempEmployers = employerService.getEmployersById(id);

        if (Objects.nonNull(tempEmployers)) {
            employerService.deleteEmployers(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
