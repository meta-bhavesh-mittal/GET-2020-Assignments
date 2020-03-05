package com.metacube.metaparkingsystemv2.controllers;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.metaparkingsystemv2.dtos.EmployeeDto;
import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.models.Vehicle;
import com.metacube.metaparkingsystemv2.services.EmployeeService;
import com.metacube.metaparkingsystemv2.services.ImageService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ImageService imageService;

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
				Vehicle vehicle = new Vehicle();
				vehicle.setEmployee(employee);
				model.addAttribute("vehicle", vehicle);
				model.addAttribute("employeeId", employeeId);
				System.out.println("In register employee...");
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
					session.setAttribute("empId", empId);
					session.setAttribute("imagePath", searchImage(empId));
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
			System.out.println(employee.getEmpId());
			employee.setConfirmPassword(employee.getPassword());
			employeeService.updateEmployee(employee);
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
	
	public String searchImage(int empId) {
		File folder = new File("/MetaParkingSystemV2/src/main/resources/static/images");
		String imagePath = "http://localhost:8080/images/User_Avatar.png";
		for (File f: folder.listFiles()) {
			if (f.getName().equals(empId + ".png")) {
				imagePath = "http://localhost:8080/images/" + f.getName();
			}
		}
		return imagePath;
	}
	
	@PostMapping("/uploadImage")
	public String uploadImage(@RequestParam("image") MultipartFile imageFile, HttpSession session) {
		try {
			int empId = (int) session.getAttribute("empId");
			if (!imageFile.getOriginalFilename().contains(".png")) {
				System.out.println("Image Name : " + imageFile.getOriginalFilename());
				return "redirect:display";
			}
			imageService.saveImage(imageFile, empId);
			session.setAttribute("imagePath", "http://localhost:8080/images/" + empId + ".png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:display";
	}
}
