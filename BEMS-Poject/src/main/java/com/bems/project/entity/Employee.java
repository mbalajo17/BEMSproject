package com.bems.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee1")
public class Employee {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@Column(name="Employee_name",nullable=false)
	private String empname;
	
	@Column(name="Employee_phone",nullable=false)
	private Long empphone;
	
	@Column(name="Employee_Email",nullable=false)
	private String email;
	
	public Employee() {
	}
	
	public Employee(String empname, Long empphone, String email) {
		super();
		this.empname = empname;
		this.empphone = empphone;
		this.email = email;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Long getEmpphone() {
		return empphone;
	}
	public void setEmpphone(Long empphone) {
		this.empphone = empphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
