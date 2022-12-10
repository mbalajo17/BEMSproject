package com.bems.project.service;

import java.util.List;

import com.bems.project.entity.Employee;


public interface EmpService {
	List<Employee> getAllEmployee();
	Employee saveEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	Employee getEmployeeById(Long id);
	void deleteEmployeeById(Long id);

}
