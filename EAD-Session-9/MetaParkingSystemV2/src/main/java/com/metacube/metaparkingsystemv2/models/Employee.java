package com.metacube.metaparkingsystemv2.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Employee {
	private int empId;

	@Pattern(regexp = "^[a-zA-Z]{2,}\\s?[a-zA-Z]{2,}$", message = "Please enter valid Name")
	private String fullName;

	@NotNull
	private String gender;

	@NotBlank(message = "Please enter email id")
	@Email(message = "Please enter valid email")
	private String emailId;

	@Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*_-]{8,}$", message = "Please enter valid password")
	private String password;

	@Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*_-]{8,}$", message = "Please enter valid confirm password")
	private String confirmPassword;

	@Pattern(regexp = "^[0-9]{10,15}", message = "Please enter valid contact number")
	private String contactNumber;

	@Pattern(regexp = "^[a-zA-Z0-9]{2,}$", message = "Please enter valid Org. Name")
	private String orgName;
	private int passId;

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

	public int getPassId() {
		return passId;
	}

	public void setPassId(int passId) {
		this.passId = passId;
	}

	@Override
	public String toString() {
		return "Employee [fullName=" + fullName + ", gender=" + gender + ", emailId=" + emailId + ", password="
				+ password + ", confirmPassword=" + confirmPassword + ", contactNumber=" + contactNumber + ", orgName="
				+ orgName + "]";
	}
}
