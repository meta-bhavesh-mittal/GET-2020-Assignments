package com.metacube.metaparkingsystemv2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.metacube.metaparkingsystemv2.models.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

	@Query("Select empId from Employee where emailId = :emailId")
	int findEmpIdByEmailId(@Param("emailId") String emailId);
	
	@Query("from Employee where orgName = :orgName and empId <> :empId")
	List<Employee> findFriends(@Param("orgName") String orgName, @Param("empId") int empId);
	/*
	 * Employee getEmployeeById(int empId);
	 * 
	 * int addEmployee(Employee employee);
	 * 
	 * List<Employee> getFriends(int empId);
	 * 
	 * int getEmployeeIdByEmailId(String emailId);
	 * 
	 * Employee updateEmployee(Employee employee);
	 */
}
