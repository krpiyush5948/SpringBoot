package com.spring.springproject.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import  com.spring.springproject.model.Employee;

@Repository
	public class EmployeeDao {
		
		/**
		 
		 */
		@Autowired
		JdbcTemplate jdbcTemplate;
		
		public Employee getEmployeeDao(int id) {
			String query ="SELECT id,name,salary from employee where id = ?";
			return jdbcTemplate.queryForObject(query,new Object[] {id},new RowMapper<Employee>() {
				
				@Override
				public Employee mapRow(ResultSet rs,int rownum) throws SQLException{
					Employee emp =new Employee();
					emp.setId(rs.getInt(1));
					emp.setName(rs.getString(2));
					emp.setSalary(rs.getInt(3));
					return emp;
				}
				
			});
			
					
		}
		
		
		
	  public int insertEmployee(Employee emp) {
		  
		  String query="INSERT into Employee values(?,?,?)";
		  return jdbcTemplate.update(query, new PreparedStatementSetter() {
			  
			  @Override
			    public void setValues(PreparedStatement ps) throws SQLException{
				  ps.setInt(1,emp.getId());
				  ps.setString(2,emp.getName());
				  ps.setInt(3,emp.getSalary());
			  }
		  });
	  }
	  
	  public int updateEmployeeSalary(Employee emp) {
		  String query="UPDATE employee set salary = ? where id = ? ";
		  return jdbcTemplate.update(query ,new PreparedStatementSetter() {
			  
			 @Override
			 public void setValues(PreparedStatement ps) throws SQLException {
				 ps.setInt(1,emp.getSalary());
				 ps.setInt(2, emp.getId());
			 }
		  });
	  }
	  
	}



