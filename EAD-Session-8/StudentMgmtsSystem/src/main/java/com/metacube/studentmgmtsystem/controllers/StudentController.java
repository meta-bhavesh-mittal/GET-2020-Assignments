package com.metacube.studentmgmtsystem.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.studentmgmtsystem.model.Student;
import com.metacube.studentmgmtsystem.serviceimpl.StudentServiceImpl;

@Controller
public class StudentController {
	
	@Autowired	
	private StudentServiceImpl studentService;
	
	@PostMapping("/addStudent")
	public String addStudent(@Valid @ModelAttribute("student") Student student, Errors errors) {
		if (errors.hasErrors()) {
			return "addstudent";
		}
		studentService.addStudent(student);
		return "redirect:home";
	}
	
	@GetMapping("/getAllStudents")
	public ModelAndView getAllStudents() {
		ModelAndView modelAndView = new ModelAndView();
		List<Student> studentsList = studentService.getAllStudents();
		modelAndView.setViewName("showstudents");
		modelAndView.addObject("students", studentsList);
		return modelAndView;
	}
}
