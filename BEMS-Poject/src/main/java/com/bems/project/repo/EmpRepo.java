package com.bems.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bems.project.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Long> {
}