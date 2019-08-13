package com.spring.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springproject.model.Employee;
import com.spring.springproject.service.EmpService;

@RestController
public class controller {
	
	@Autowired
	EmpService empser;
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public Employee getEmployees(@PathVariable(name="id") int id) {
		return empser.getEmployeeService(id);
	}
	
	
	@RequestMapping(value="/inemp",method=RequestMethod.POST)
	public int insertEmployee(@RequestBody Employee emp) {
		return (empser).insertEmployeeService(emp);
	}
	
	@RequestMapping(value="/putemp",method=RequestMethod.PUT)
	public int updateEmployeeSalryService(@RequestBody Employee emp) {
		return empser.updateEmployeeSalaryService(emp);
		
	}
}
