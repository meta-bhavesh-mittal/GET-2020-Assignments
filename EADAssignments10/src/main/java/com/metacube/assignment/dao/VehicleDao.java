package com.metacube.assignment.dao;

import com.metacube.assignment.model.Vehicle;

public interface VehicleDao {
	String insertVehicle = "INSERT INTO Vehicle values (?, ?, ?, ?, ?, ?, ?);";
	String selectVehicle = "SELECT * FROM Vehicle where vehicleId = ?";
	String updateVehicle = "UPDATE Vehicle set vehicleName = ?, type = ?, vehicleNumber = ?"
			+ ", identification = ?, passId = ? where vehicleId = ?;";
	String lastRecord = "SELECT AUTO_INCREMENT FROM information_schema.TABLES"
			+ " WHERE TABLE_SCHEMA = 'metaparking' AND TABLE_NAME = 'Vehicle'";
	String selectVehicleIdByEmpId = "SELECT vehicleId FROM Vehicle where empId = ?";

	Vehicle getVehicle(int vehicleId);

	boolean updateVehicle(Vehicle vehicle, int vehicleId);

	int addVehicle(Vehicle vehicle);

	int getVehicleIdByEmpId(int empId);
}
