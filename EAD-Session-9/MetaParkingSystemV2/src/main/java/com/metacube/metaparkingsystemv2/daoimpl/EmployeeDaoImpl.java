package com.metacube.metaparkingsystemv2.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.metacube.metaparkingsystemv2.dao.EmployeeDao;
import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.utils.ConnectionUtility;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Employee getEmployeeById(int empId) {
		Employee employee = new Employee();
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(selectEmployee);
			st.setInt(1, empId);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				employee.setEmpId(empId);
				employee.setFullName(rs.getString("fullName"));
				employee.setGender(rs.getString("gender"));
				employee.setEmailId(rs.getString("emailId"));
				employee.setPassword(rs.getString("password"));
				employee.setConfirmPassword(rs.getString("confirmPassword"));
				employee.setContactNumber(rs.getString("contactNumber"));
				employee.setOrgName(rs.getString("orgName"));
			}
		} catch (SQLException e) {
			System.out.println("Employee could not be fetched...");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		return employee;
	}

	@Override
	public boolean updateEmployee(int empId, Employee employee) {
		boolean result = false;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(updateEmployee);
			st.setString(1, employee.getFullName());
			st.setString(2, employee.getGender());
			st.setString(3, employee.getEmailId());
			st.setString(4, employee.getPassword());
			st.setString(5, employee.getPassword());
			st.setString(6, employee.getContactNumber());
			st.setString(7, employee.getOrgName());
			st.setInt(8, empId);
			int rowsAffected = st.executeUpdate();
			if (rowsAffected != 0) {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("Employee Added");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		return result;
	}

	@Override
	public int addEmployee(Employee employee) {
		int empId = -1;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(insertEmployee);
			st.setInt(1, employee.getEmpId());
			st.setString(2, employee.getFullName());
			st.setString(3, employee.getGender());
			st.setString(4, employee.getEmailId());
			st.setString(5, employee.getPassword());
			st.setString(6, employee.getConfirmPassword());
			st.setString(7, employee.getContactNumber());
			st.setString(8, employee.getOrgName());
			int rowsAffected = st.executeUpdate();
			if (rowsAffected != 0) {
				st = connection.prepareStatement(lastRecord);
				ResultSet rs = st.executeQuery();
				rs.next();
				empId = rs.getInt(1) - 1;
			}
		} catch (SQLException e) {
			System.out.println("Employee Added");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		return empId;
	}

	public int getEmployeeId(String emailId) {
		int empId = -1;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(getEmployeeIdByEmail);
			st.setString(1, emailId);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				empId = rs.getInt("empId");
			}
		} catch (SQLException e) {
			System.out.println("Employee could not be Added");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		return empId;
	}

	public String getOrgName(int empId) {
		String orgName = "";
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(selectOrgName);
			st.setInt(1, empId);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				orgName = rs.getString("orgName");
			}
		} catch (SQLException e) {
			System.out.println("Org name could not fetch...");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		return orgName;
	}

	public List<Employee> getFriends(int empId) {
		String orgName = getOrgName(empId);
		List<Employee> friends = new ArrayList<Employee>();
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(selectFriends);
			st.setString(1, orgName);
			st.setInt(2, empId);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt("empId"));
				employee.setFullName(rs.getString("fullName"));
				employee.setGender(rs.getString("gender"));
				employee.setEmailId(rs.getString("emailId"));
				employee.setContactNumber(rs.getString("contactNumber"));
				employee.setOrgName(rs.getString("orgName"));
				friends.add(employee);
			}
		} catch (SQLException e) {
			System.out.println("Org name could not fetch...");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		return friends;
	}
}
