package com.metacube.studentmgmtsystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.metacube.studentmgmtsystem.model.Student;

@Repository
public class StudentDao {
	private static List<Student> studentsList = new ArrayList<Student>();
	private static int counter = 1;
	
	public boolean addStudent(Student newStudent) {
		newStudent.setId(counter);
		studentsList.add(newStudent);
		counter++;
		return true;
	}

	public List<Student> getAllStudents() {
		return studentsList;
	}
	
	
}
