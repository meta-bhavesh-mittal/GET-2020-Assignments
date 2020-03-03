package com.metacube.assignment.controller;

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

import com.metacube.assignment.dto.EmployeeDto;
import com.metacube.assignment.model.Pass;
import com.metacube.assignment.model.Vehicle;
import com.metacube.assignment.service.PassInfoService;
import com.metacube.assignment.service.VehicleService;



@Controller
public class PassController {

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private PassInfoService passInfoService;
	
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
	 *This method is used to generate pass. 
	 */
	@PostMapping("/addPass")
	public String generatePass(@Valid @ModelAttribute("pass") Pass pass, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "pass";
		} else {
			Vehicle vehicle = vehicleService.getVehicleById(pass.getVehicleId());
			String vehicleType = vehicle.getType();
			String passType = pass.getPassType();
			int passId = passInfoService.getPassId(vehicleType, passType);
			vehicle.setPassId(passId);
			System.out.println(vehicleService.updateVehicle(vehicle, pass.getVehicleId()));
			model.addAttribute("employeeDto", new EmployeeDto());
			return "redirect:login";
		}
	}

	/*
	 * This method is used to get the details of pass.
	 */
	@GetMapping("/getPassDetails")
	public String getPassDetails(Model model, HttpSession session, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			int empId = (int) session.getAttribute("empId");
			int vehicleId = vehicleService.getVehicleIdByEmpId(empId);
			Vehicle vehicle = vehicleService.getVehicleById(vehicleId);

			Pass pass = new Pass();
			pass.setPassId(vehicle.getPassId());
			pass.setVehicleId(vehicleId);
			pass.setPassType(passInfoService.getPassType(vehicle.getPassId()));
			pass.setPassPrice(passInfoService.getPassPrice(vehicle.getPassId()));
			System.out.println(pass);

			model.addAttribute("pass", pass);
			model.addAttribute("vehicleType", vehicle.getType());

			return "showPassDetails";
		} else {
			return "redirect:login";
		}
	}

	/*
	 * This method is used to update employee details.
	 */
	@PostMapping("/editPass")
	public String updateEmployeeDetails(@Valid @ModelAttribute("employee") Pass pass, Errors errors,
			HttpSession session) {
		int empId = (int) session.getAttribute("empId");
		int vehicleId = vehicleService.getVehicleIdByEmpId(empId);
		Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
		String passType = pass.getPassType();
		int passId = passInfoService.getPassId(vehicle.getType(), passType);
		vehicle.setPassId(passId);
		vehicleService.updateVehicle(vehicle, vehicleId);
		return "redirect:display";
	}
}
