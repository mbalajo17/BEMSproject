package com.bems.project.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bems.project.entity.Employee;
import com.bems.project.repo.EmpRepo;
import com.bems.project.service.EmpService;

@Service

public class EmpServiceImpl implements EmpService {
	
	
	private EmpRepo empRepo;
	public EmpServiceImpl(EmpRepo empRepo){
		super();
		this.empRepo=empRepo;
	}
	
	
	@Override
	public List<Employee> getAllEmployee(){
		return empRepo.findAll();
	}


	@Override
	public Employee saveEmployee(Employee employee){
		return empRepo.save(employee);
	}
	
	@Override
	public Employee getEmployeeById(Long id){
		return empRepo.findById(id).get();
	}
	
	@Override
	public Employee updateEmployee(Employee employee){
		return empRepo.save(employee);
	}


	@Override
	public void deleteEmployeeById(Long id) {
		empRepo.deleteById(id);
		
	}
	

}
