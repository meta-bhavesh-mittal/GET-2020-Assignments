package com.metacube.assignment.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.metacube.assignment.dto.EmployeeDto;
import com.metacube.assignment.model.Employee;



@Controller
public class HomeController {

	/*
	 * This method is used to validate session.
	 */
	public static boolean isSessionValid(HttpSession session, HttpServletResponse res) {
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("empId") == null) {
			return false;
		}
		return true;
	}

	/*
	 * This method is used to go to homepage.
	 */
	@GetMapping({ "/", "/home" })
	public String getHomePage() {
		System.out.println("In home controller...");
		return "home";
	}

	/*
	 * This method is used to go to register page.
	 */
	@GetMapping("/register")
	public String getRegisterPage(Model model) {
		model.addAttribute("employee", new Employee());
		return "register";
	}

	/*
	 * This method is used to go to login page.
	 */
	@GetMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("employeeDto", new EmployeeDto());
		return "login";
	}

	/*
	 * This method is used to go to display page.
	 */
	@GetMapping("/display")
	public String getDisplayPage(HttpSession session, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			return "display";
		} else {
			return "redirect:login";
		}
	}
}
