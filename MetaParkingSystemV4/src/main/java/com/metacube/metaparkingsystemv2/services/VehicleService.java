package com.metacube.metaparkingsystemv2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.metaparkingsystemv2.daoimpl.VehicleDaoImpl;
import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.models.Vehicle;

@Service
public class VehicleService {

	@Autowired
	private VehicleDaoImpl vehicleDao;

	@Transactional
	public int addVehicle(Vehicle vehicle) {
		return vehicleDao.addVehicle(vehicle);
	}

	@Transactional
	public Vehicle getVehicleById(int vehicleId) {
		return vehicleDao.getVehicle(vehicleId);
	}

	@Transactional
	public int updateVehicle(Vehicle vehicle) {
		System.out.println("In Service...");
		return vehicleDao.addVehicle(vehicle);
	}

	@Transactional
	public Vehicle getVehicleByEmpId(Employee employee) {
		return vehicleDao.getVehicleByEmpId(employee);
	}
}
