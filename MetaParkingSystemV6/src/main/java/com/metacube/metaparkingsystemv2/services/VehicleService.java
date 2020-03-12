package com.metacube.metaparkingsystemv2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.metaparkingsystemv2.dao.VehicleDao;
import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.models.Vehicle;

@Service
public class VehicleService {

	@Autowired
	private VehicleDao vehicleDao;

	@Transactional
	public int addVehicle(Vehicle vehicle) {
		return vehicleDao.save(vehicle).getVehicleId();
	}

	@Transactional
	public Vehicle getVehicleById(int vehicleId) {
		return vehicleDao.findById(vehicleId).orElse(new Vehicle());
	}

	@Transactional
	public int updateVehicle(Vehicle vehicle) {
		return vehicleDao.save(vehicle).getVehicleId();
	}

	@Transactional
	public Vehicle getVehicleByEmpId(Employee employee) {
		return vehicleDao.findVehicleByEmployee(employee);
	}
}
