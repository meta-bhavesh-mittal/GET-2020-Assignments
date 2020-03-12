package com.metacube.metaparkingsystemv2.dao;

import org.springframework.data.repository.CrudRepository;

import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.models.Vehicle;

public interface VehicleDao extends CrudRepository<Vehicle, Integer> {
	
	Vehicle findVehicleByEmployee(Employee employee);
}
