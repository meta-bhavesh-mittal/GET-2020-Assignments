package com.metacube.metaparkingsystemv2.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.metaparkingsystemv2.dao.EmployeeDao;
import com.metacube.metaparkingsystemv2.models.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Employee getEmployeeById(int empId) {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("from Employee where empId = :empId", Employee.class);
		query.setParameter("empId", empId);
		Employee employee = query.getSingleResult();
		return employee;
	}

	@Override
	public int addEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.save(employee);
		System.out.println("Employee Id : " + employee.getEmpId());
		return employee.getEmpId();
	}
	
	public Employee updateEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.update(employee);
		System.out.println("Employee Id : " + employee.getEmpId());
		return employee;
	}

	@Override
	public List<Employee> getFriends(int empId) {
		Session session = entityManager.unwrap(Session.class);
		Employee employee = getEmployeeById(empId);
		Query<Employee> query = session.createQuery("from Employee where orgName = :orgName and empId <> :empId", Employee.class);
		query.setParameter("orgName", employee.getOrgName());
		query.setParameter("empId", employee.getEmpId());
		List<Employee> friends = query.getResultList();
		return friends;
	}

	@Override
	public int getEmployeeIdByEmailId(String emailId) {
		Session session = entityManager.unwrap(Session.class);
		Query<Integer> query = session.createQuery("Select empId from Employee where emailId = :emailId", Integer.class);
		query.setParameter("emailId", emailId);
		int empId = -1;
		try {
			empId = query.getSingleResult();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println(empId);
		return empId;
	}
}
