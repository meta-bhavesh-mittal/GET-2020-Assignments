package com.metacube.metaparkingsystemv2.dao;

import java.util.List;

import com.metacube.metaparkingsystemv2.models.Employee;

public interface EmployeeDao {
	String insertEmployee = "INSERT INTO Employee VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	String updateEmployee = "UPDATE Employee set fullName = ?, gender = ?, emailId = ?, password = ?"
			+ ", confirmPassword = ?, contactNumber = ?, orgName = ? where empId = ?";
	String selectEmployee = "SELECT * FROM Employee where empId = ?";
	String lastRecord = "SELECT AUTO_INCREMENT" + " FROM information_schema.TABLES"
			+ " WHERE TABLE_SCHEMA = 'metaparkingdbv2'" + " AND TABLE_NAME = 'Employee'";
	String getEmployeeIdByEmail = "SELECT empId from Employee where emailId = ?;";
	String selectOrgName = "SELECT OrgName from Employee where empId = ?";
	String selectFriends = "SELECT * FROM Employee where orgName = ? and empId <> ?;";

	Employee getEmployeeById(int empId);

	boolean updateEmployee(int empId, Employee employee);

	int addEmployee(Employee employee);

	String getOrgName(int empId);

	List<Employee> getFriends(int empId);
}
