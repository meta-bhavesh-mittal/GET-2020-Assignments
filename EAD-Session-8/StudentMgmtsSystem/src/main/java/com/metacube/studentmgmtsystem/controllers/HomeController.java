package com.metacube.studentmgmtsystem.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.metacube.studentmgmtsystem.model.Student;

@Controller
@PropertySource("classpath:application.yml")
public class HomeController {
	
	@Value("${home.message}")
	private String welcomeMessage;
	
	@GetMapping({"/", "/home"})
	public String getHomePageController(Model model) {
		model.addAttribute("welcomeMessage", welcomeMessage);
		return "home";
	}
	
	@GetMapping("/student")
	public String addStudentController(Model model) {
		model.addAttribute("student", new Student());
		return "addstudent";
	}
}
