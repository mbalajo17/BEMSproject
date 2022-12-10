package com.bems.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bems.project.entity.Employee;
import com.bems.project.entity.User;
import com.bems.project.repo.UserRepo;
import com.bems.project.service.EmpService;

@Controller
public class Usercontroller {
@Autowired	
private UserRepo repo;	
@GetMapping("/")
public String login(Model model) {
	User user=new User();
	model.addAttribute("user",user);
	return "login";
}
@PostMapping("/userLogin")
public String loginUser(@ModelAttribute("user")User user,Model model) {
	String userId=user.getUserId();
	String password=user.getPassword();
	Optional<User> userdata=repo.findById(userId);
	if(userId.equals(userdata.get().getUserId())&&password.equals(userdata.get().getPassword()))	
	{
	return "home";
	}
	else
	{
		model.addAttribute("logError","logError");
		return "login";
	}
}
private EmpService empService;

public Usercontroller(EmpService empService) {
	super();
	this.empService = empService;
}
@RequestMapping("/empdetails")
public String listStidents(Model model) {
	model.addAttribute("employee",empService.getAllEmployee());
	return "empdetails";
}

@GetMapping("/employee/new")
public String  createEmployeeForm(Model model)
{
	Employee employee=new Employee();
	model.addAttribute("employee",employee);
	return "create_employee";
}
@PostMapping("/employee")
public String saveEmployee(@ModelAttribute("employee")Employee employee){
	empService.saveEmployee(employee);
	return "redirect:/empdetails";	
}

@GetMapping("/employee/edit/{id}")
public String editEmployeeForm(@PathVariable Long id, Model model) {
	model.addAttribute("employee",empService.getEmployeeById(id));
	return "edit_emp";
}

@PostMapping("/employee/{id}")
public String updateEmployee(@PathVariable Long id,
		@ModelAttribute("employee") Employee employee,
		Model model) {
	
	// get student from database by id
	Employee existingEmployee = empService.getEmployeeById(id);
	existingEmployee.setId(id);
	existingEmployee.setEmpname(employee.getEmpname());
	existingEmployee.setEmpphone(employee.getEmpphone());
	existingEmployee.setEmail(employee.getEmail());
	
	// save updated student object
	empService.updateEmployee(existingEmployee);
	return "redirect:/empdetails";		

}
//handler method to handle delete student request

	@GetMapping("/employee/{id}")
	public String deleteStudent(@PathVariable Long id) {
		empService.deleteEmployeeById(id);
		return "redirect:/empdetails";
	}	
}
