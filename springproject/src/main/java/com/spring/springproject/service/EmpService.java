package com.spring.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springproject.dao.EmployeeDao;
import com.spring.springproject.model.Employee;

@Service
public class EmpService {
	
	@Autowired
	EmployeeDao empdao;
	
	public Employee getEmployeeService(int id) {
		return empdao.getEmployeeDao(id);
	}
	
	public int insertEmployeeService(Employee emp) {
		return empdao.insertEmployee(emp);
	}
	
	public int updateEmployeeSalaryService(Employee emp) {
		return empdao.updateEmployeeSalary(emp);
	}

}
