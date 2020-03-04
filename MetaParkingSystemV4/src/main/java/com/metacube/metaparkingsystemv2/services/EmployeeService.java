package com.metacube.metaparkingsystemv2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.metaparkingsystemv2.daoimpl.EmployeeDaoImpl;
import com.metacube.metaparkingsystemv2.models.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDaoImpl employeeDao;

	@Transactional
	public int addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	@Transactional
	public Employee getEmployeeById(int empId) {
		return employeeDao.getEmployeeById(empId);
	}

	@Transactional
	public int getEmployeeId(String emailId) {
		return employeeDao.getEmployeeIdByEmailId(emailId);
	}
	
	@Transactional
	public Employee updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	@Transactional
	public List<Employee> getFriends(int empId) {
		return employeeDao.getFriends(empId);
	}
}
