package com.metacube.studentmgmtsystem.service;

import java.util.List;

import com.metacube.studentmgmtsystem.model.Student;

public interface StudentService {
	
	boolean addStudent(Student newStudent);
	List<Student> getAllStudents();
}
