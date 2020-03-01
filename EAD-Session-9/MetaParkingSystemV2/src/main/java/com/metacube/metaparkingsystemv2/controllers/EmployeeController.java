package com.metacube.metaparkingsystemv2.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.metaparkingsystemv2.dtos.EmployeeDto;
import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.models.Vehicle;
import com.metacube.metaparkingsystemv2.services.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public static boolean isSessionValid(HttpSession session, HttpServletResponse res) {
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("empId") == null) {
			return false;
		}
		return true;
	}

	@PostMapping("/registerEmployee")
	public String registerEmployee(@Valid @ModelAttribute("employee") Employee employee, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "register";
		} else {
			String emailId = employee.getEmailId();
			int empId = employeeService.getEmployeeId(emailId);
			if (empId == -1) {
				int employeeId = employeeService.addEmployee(employee);
				model.addAttribute("vehicle", new Vehicle());
				model.addAttribute("employeeId", employeeId);
				return "vehicle";
			} else {
				model.addAttribute("alert", "This email is already registered :)");
				return "redirect:login";
			}
		}

	}

	@PostMapping("/loginEmployee")
	public String loginEmployee(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto, Errors errors,
			HttpSession session) {
		if (errors.hasErrors()) {
			return "login";
		} else {
			String emailId = employeeDto.getEmailId();
			String password = employeeDto.getPassword();
			int empId = employeeService.getEmployeeId(emailId);
			if (empId == -1) {
				return "redirect:login";
			} else {
				Employee employee = employeeService.getEmployeeById(empId);
				if (employee.getEmailId().equals(emailId) && employee.getPassword().equals(password)) {
					session.setAttribute("empId", employeeService.getEmployeeId(employeeDto.getEmailId()));
					System.out.println(emailId + " " + password);
					return "redirect:display";
				} else {
					return "redirect:login";
				}
			}
		}
	}

	@GetMapping("/getEmployeeDetails")
	public String getEmployeeById(HttpSession session, Model model, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			int empId = (int) session.getAttribute("empId");
			Employee employee = employeeService.getEmployeeById(empId);
			model.addAttribute("employee", employee);
			return "showEmployeeDetails";
		} else {
			return "redirect:login";
		}

	}

	@PostMapping("/editEmployee")
	public String updateEmployeeDetails(@Valid @ModelAttribute("employee") Employee employee, Errors errors,
			HttpSession session) {
		if (errors.hasErrors()) {
			return "showEmployeeDetails";
		} else {
			int empId = (int) session.getAttribute("empId");
			employee.setEmpId(empId);
			employeeService.updateEmployee(empId, employee);
			return "redirect:display";
		}

	}

	@GetMapping("/getFriends")
	public String getFriends(Model model, HttpSession session, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			int empId = (int) session.getAttribute("empId");
			List<Employee> friends = employeeService.getFriends(empId);
			model.addAttribute("friends", friends);
			return "showfriends";
		} else {
			return "redirect:login";
		}
	}

	@GetMapping("getFriend/{empId}")
	public String getFriend(@PathVariable("empId") int empId, Model model, HttpSession session,
			HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			Employee friend = employeeService.getEmployeeById(empId);
			model.addAttribute("friend", friend);
			return "showprofile";
		} else {
			return "redirect:login";
		}
	}

	@GetMapping("/logout")
	public String logoutSession(HttpSession session) {
		session.removeAttribute("empId");
		session.invalidate();
		return "redirect:home";
	}
}
