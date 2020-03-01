package com.metacube.metaparkingsystemv2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.metaparkingsystemv2.daoimpl.EmployeeDaoImpl;
import com.metacube.metaparkingsystemv2.models.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDaoImpl employeeDao;

	public int addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	public Employee getEmployeeById(int empId) {
		return employeeDao.getEmployeeById(empId);
	}

	public int getEmployeeId(String emailId) {
		return employeeDao.getEmployeeId(emailId);
	}

	public boolean updateEmployee(int empId, Employee employee) {
		return employeeDao.updateEmployee(empId, employee);
	}

	public List<Employee> getFriends(int empId) {
		return employeeDao.getFriends(empId);
	}
}
