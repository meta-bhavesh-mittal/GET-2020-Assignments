package com.metacube.studentmgmtsystem.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Student {
	private int id;
	
	@NotBlank(message="{emptyField}")
	@Size(min=2, max=20, message="{badLength}")
	private String first_name;
	
	@NotBlank(message="{emptyField}")
	@Size(min=2, max=20, message="{badLength}")
	private String last_name;
	
	@NotBlank(message="{emptyField}")
	@Size(min=2, max=20, message="{badLength}")
	private String father_name;
	
	@NotBlank(message="{emptyField}")
	@Email(message="{badEmail}")
	private String email;
	
	private int std;
	
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFather_name() {
		return father_name;
	}
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [first_name=" + first_name + ", last_name=" + last_name + ", father_name=" + father_name
				+ ", email=" + email + ", std=" + std + ", age=" + age + "]";
	}
}
