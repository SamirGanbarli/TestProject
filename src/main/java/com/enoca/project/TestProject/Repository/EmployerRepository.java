package com.enoca.project.TestProject.Repository;

import com.enoca.project.TestProject.Models.Employers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employers, Integer> {
}
