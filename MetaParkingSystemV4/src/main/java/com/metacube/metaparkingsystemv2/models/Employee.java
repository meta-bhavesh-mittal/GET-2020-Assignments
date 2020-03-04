package com.metacube.metaparkingsystemv2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int empId;

	@Pattern(regexp = "^[a-zA-Z]{2,}\\s?[a-zA-Z]{2,}$", message = "Please enter valid Name")
	@Column(name="full_name")
	private String fullName;

	@NotNull
	@Column(name="gender")
	private String gender;

	@NotBlank(message = "Please enter email id")
	@Email(message = "Please enter valid email")
	@Column(name="email_id")
	private String emailId;

	@Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*_-]{8,}$", message = "Please enter valid password")
	@Column(name="password")
	private String password;

	@Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*_-]{8,}$", message = "Please enter valid confirm password")
	@Column(name="confirm_password")
	private String confirmPassword;

	@Pattern(regexp = "^[0-9]{10,15}", message = "Please enter valid contact number")
	@Column(name="contact_number")
	private String contactNumber;

	@Pattern(regexp = "^[a-zA-Z0-9]{2,}$", message = "Please enter valid Org. Name")
	@Column(name="org_name")
	private String orgName;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fullName=" + fullName + ", gender=" + gender + ", emailId=" + emailId + ", password="
				+ password + ", confirmPassword=" + confirmPassword + ", contactNumber=" + contactNumber + ", orgName="
				+ orgName + "]";
	}
}
