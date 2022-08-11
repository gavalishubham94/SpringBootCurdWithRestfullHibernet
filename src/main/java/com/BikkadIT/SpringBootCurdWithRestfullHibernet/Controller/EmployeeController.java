package com.BikkadIT.SpringBootCurdWithRestfullHibernet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.SpringBootCurdWithRestfullHibernet.model.Employee;
import com.BikkadIT.SpringBootCurdWithRestfullHibernet.service.ServiceI;

@RestController
public class EmployeeController {

	@Autowired
	private ServiceI servicei;
	
	@PostMapping(value = "/saveEmployee", consumes="application/json",produces = "application/json")
	public ResponseEntity<String> saveEmployee(@RequestBody  Employee employee){

		Integer empId = servicei.saveEmployee(employee);
		
		String msg="Employee datails has been saved successfully with EmployeeId : "+empId;
		return new ResponseEntity<String>  (msg,HttpStatus.CREATED);

	}
	
	
	@PostMapping(value = "/saveAllEmployee", consumes="application/json",produces = "application/json")
	public ResponseEntity<String> saveAddEmployee(@RequestBody  List<Employee> employee){

		String employees = servicei.saveAllEmployees(employee);
		
		
		return new ResponseEntity<String>  (employees,HttpStatus.CREATED);

	}
	
	
	@GetMapping(value="/getById", consumes = "application/json", produces="application/json")
	public ResponseEntity<Employee> getById(@RequestBody Employee employee){
		
		Employee employee2 = servicei.getById(employee.getEmpId());
		
		if(employee2!=null) {
		return new ResponseEntity<Employee> (employee2, HttpStatus.OK);
		}

		return new ResponseEntity<Employee> (employee2, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value="/getAll", produces="application/json")
	public List<Employee> getAllEmployees(){
		
		List<Employee> employees = servicei.getAllEmployees();
	
		return employees;
		
		
	}
	
	
	
	
}
