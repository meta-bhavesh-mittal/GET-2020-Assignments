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
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.models.Pass;
import com.metacube.metaparkingsystemv2.models.PassInfo;
import com.metacube.metaparkingsystemv2.models.Vehicle;
import com.metacube.metaparkingsystemv2.services.EmployeeService;
import com.metacube.metaparkingsystemv2.services.PassInfoService;
import com.metacube.metaparkingsystemv2.services.VehicleService;

@Controller
public class VehicleController {

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

	@PostMapping("/addVehicle")
	public String addVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle, @RequestParam("empId") int empId, Errors errors, Model model) {
		System.out.println("Employee Id : " + empId);
		if (errors.hasErrors()) {
			return "vehicle";
		} else {
			Employee employee = employeeService.getEmployeeById(empId);
			System.out.println(employee);
			vehicle.setEmployee(employee);
			PassInfo passInfo = new PassInfo();
			passInfo.setPassId(-1);
			passInfo.setPassType("empty");
			passInfo.setPassType("empty");
			passInfo.setPassPrice(0.0);
			vehicle.setPassInfo(passInfo);
			
			int vehicleId = vehicleService.addVehicle(vehicle);
			
			model.addAttribute("vehicleType", vehicle.getType());
			model.addAttribute("vehicleId", vehicleId);
			model.addAttribute("pass", new Pass());
			return "pass";
		}
	}

	@GetMapping("/getVehicleDetails")
	public String getVehicleDetails(HttpSession session, Model model, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			int empId = (int) session.getAttribute("empId");
			Employee employee = employeeService.getEmployeeById(empId);
			Vehicle vehicle = vehicleService.getVehicleByEmpId(employee);
			model.addAttribute("vehicle", vehicle);
			System.out.println(vehicle.getEmployee().getEmpId() + " " + vehicle.getPassInfo().getPassId());
			return "showVehicleDetails";
		} else {
			return "redirect:login";
		}
	}

	@PostMapping("/editVehicle")
	public String updateVehicleDetails(@Valid @ModelAttribute("vehicle") Vehicle vehicle, Errors errors,
			HttpSession session) {
		if (errors.hasErrors()) {
			System.out.println("In Error code...");
			System.out.println(errors.getFieldErrorCount());
			System.out.println(vehicle.getPassInfo());
			return "showVehicleDetails";
		} else {
			System.out.println(vehicle);
			int empId = (int) session.getAttribute("empId");
//			Employee employee = employeeService.getEmployeeById(empId);
			System.out.println(empId);
			System.out.println(vehicle.getEmployee());
			Vehicle entireVehicle = vehicleService.getVehicleById(vehicle.getVehicleId());
			System.out.println(entireVehicle);
			
			PassInfo passInfo = passInfoService.getPassInfo(vehicle.getType(), entireVehicle.getPassInfo().getPassType());
			
			entireVehicle.setIdentification(vehicle.getIdentification());
			entireVehicle.setPassInfo(passInfo);
			entireVehicle.setType(vehicle.getType());
			entireVehicle.setVehicleName(vehicle.getVehicleName());
			entireVehicle.setVehicleNumber(vehicle.getVehicleNumber());
			
			System.out.println("vehicle id : " + entireVehicle.getVehicleId());
			vehicleService.updateVehicle(entireVehicle);
			return "redirect:display";
		}
	}
}
