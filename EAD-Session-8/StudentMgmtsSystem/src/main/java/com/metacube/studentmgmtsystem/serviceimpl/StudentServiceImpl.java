package com.metacube.studentmgmtsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.studentmgmtsystem.dao.StudentDao;
import com.metacube.studentmgmtsystem.model.Student;
import com.metacube.studentmgmtsystem.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	public boolean addStudent(Student newStudent) {
		return studentDao.addStudent(newStudent);
	}

	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}
}

