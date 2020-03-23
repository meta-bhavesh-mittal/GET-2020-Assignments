package com.metacube.metaparkingsystemv2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.metaparkingsystemv2.dao.EmployeeDao;
import com.metacube.metaparkingsystemv2.models.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Transactional
	public int addEmployee(Employee employee) {
		Employee emp = employeeDao.save(employee);
		return emp.getEmpId();
	}

	@Transactional
	public Employee getEmployeeById(int empId) {
		return employeeDao.findById(empId).orElse(new Employee());
	}

	@Transactional
	public int getEmployeeId(String emailId) {
		return employeeDao.findEmpIdByEmailId(emailId);
	}
	
	@Transactional
	public Employee updateEmployee(Employee employee) {
		return employeeDao.save(employee);
	}

	@Transactional
	public List<Employee> getFriends(int empId) {
		Employee employee = employeeDao.findById(empId).orElse(new Employee());
		return employeeDao.findFriends(employee.getOrgName(), empId);
	}
}
