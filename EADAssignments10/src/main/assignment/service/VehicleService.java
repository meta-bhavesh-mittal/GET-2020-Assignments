package com.metacube.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.assignment.daoimplement.VehicleDaoImpl;
import com.metacube.assignment.model.Vehicle;



@Service
public class VehicleService {

	@Autowired
	private VehicleDaoImpl vehicleDao;

	public int addVehicle(Vehicle vehicle) {
		return vehicleDao.addVehicle(vehicle);
	}

	public Vehicle getVehicleById(int vehicleId) {
		return vehicleDao.getVehicle(vehicleId);
	}

	public boolean updateVehicle(Vehicle vehicle, int vehicleId) {
		return vehicleDao.updateVehicle(vehicle, vehicleId);
	}

	public int getVehicleIdByEmpId(int empId) {
		return vehicleDao.getVehicleIdByEmpId(empId);
	}
}
