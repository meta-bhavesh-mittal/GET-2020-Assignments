package com.metacube.metaparkingsystemv2.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.metaparkingsystemv2.dtos.EmployeeDto;
import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.models.Pass;
import com.metacube.metaparkingsystemv2.models.PassInfo;
import com.metacube.metaparkingsystemv2.models.Vehicle;
import com.metacube.metaparkingsystemv2.services.EmployeeService;
import com.metacube.metaparkingsystemv2.services.PassInfoService;
import com.metacube.metaparkingsystemv2.services.VehicleService;

@Controller
public class PassController {

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private PassInfoService passInfoService;

	@Autowired
	private EmployeeService employeeService;
	
	public static boolean isSessionValid(HttpSession session, HttpServletResponse res) {
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("empId") == null) {
			return false;
		}
		return true;
	}

	@PostMapping("/addPass")
	public String generatePass(@Valid @ModelAttribute("pass") Pass pass, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "pass";
		} else {
			Vehicle vehicle = vehicleService.getVehicleById(pass.getVehicleId());
			String vehicleType = vehicle.getType();
			String passType = pass.getPassType();
			PassInfo passInfo = passInfoService.getPassInfo(vehicleType, passType);
			vehicle.setPassInfo(passInfo);
			System.out.println(vehicleService.updateVehicle(vehicle));
			model.addAttribute("employeeDto", new EmployeeDto());
			return "redirect:login";
		}
	}

	@GetMapping("/getPassDetails")
	public String getPassDetails(Model model, HttpSession session, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			int empId = (int) session.getAttribute("empId");
			Employee employee = employeeService.getEmployeeById(empId);
			Vehicle vehicle = vehicleService.getVehicleByEmpId(employee);
			PassInfo passInfo = vehicle.getPassInfo();
			
			Pass pass = new Pass();
			pass.setPassId(passInfo.getPassId());
			pass.setVehicleId(vehicle.getVehicleId());
			pass.setPassType(passInfo.getPassType());
			pass.setPassPrice(passInfo.getPassPrice());
			System.out.println(pass);

			model.addAttribute("pass", pass);
			model.addAttribute("vehicleType", vehicle.getType());

			return "showPassDetails";
		} else {
			return "redirect:login";
		}
	}

	@PostMapping("/editPass")
	public String updateEmployeeDetails(@Valid @ModelAttribute("employee") Pass pass, Errors errors,
			HttpSession session) {
		int empId = (int) session.getAttribute("empId");
		Employee employee = employeeService.getEmployeeById(empId);
		Vehicle vehicle = vehicleService.getVehicleByEmpId(employee);
		
		String passType = pass.getPassType();
		PassInfo updatedPassInfo = passInfoService.getPassInfo(vehicle.getType(), passType);
		vehicle.setPassInfo(updatedPassInfo);
		vehicleService.updateVehicle(vehicle);
		return "redirect:display";
	}
}
