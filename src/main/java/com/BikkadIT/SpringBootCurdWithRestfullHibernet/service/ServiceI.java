package com.BikkadIT.SpringBootCurdWithRestfullHibernet.service;

import java.util.List;

import com.BikkadIT.SpringBootCurdWithRestfullHibernet.model.Employee;

public interface ServiceI {

	public Integer saveEmployee(Employee employee);
	
	public String saveAllEmployees(List<Employee> employees);
	
	public Employee getById(Integer empId);
	
	public List<Employee> getAllEmployees();
}
