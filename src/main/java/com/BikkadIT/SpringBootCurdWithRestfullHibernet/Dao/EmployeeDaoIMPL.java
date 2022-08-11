package com.BikkadIT.SpringBootCurdWithRestfullHibernet.Dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BikkadIT.SpringBootCurdWithRestfullHibernet.model.Employee;

@Repository
public class EmployeeDaoIMPL implements EmployeeDaoI{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Integer saveEmployee(Employee employee) {
		Session session = sf.openSession();
		
		session.beginTransaction();
		Integer empId = (Integer) session.save(employee);
		session.getTransaction().commit();
		return empId;
	}

	
	public String SaveAllEmployee(List<Employee> employee){
		Session session = sf.openSession();
		session.beginTransaction();
		
		for(Employee E:employee) {
			
			session.save(E);
			 
		       }
		
		String msg=" All Employees Saved";
		
		session.getTransaction().commit();
		return msg;
		
	}


	@Override
	public Employee getById(Integer empId) {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Employee employee = session.get(Employee.class, empId);
		
		Hibernate.initialize(employee);
		
		session.getTransaction().commit();
		return employee;
	}
	@Override
	public List<Employee> getAllEmployees(){
	
		Session session = sf.openSession();
		
		String hql="from Employee";
		Query query = session.createQuery(hql);
		List employees = query.getResultList();
		
		return employees;
	
		
	}
	
	
	
}
