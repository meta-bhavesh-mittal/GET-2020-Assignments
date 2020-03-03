package com.metacube.metaparkingsystemv2.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Vehicle {
	private int vehicleId;

	@Pattern(regexp = "^[a-zA-Z0-9]{2,}$", message = "Please enter valid vehicle name")
	private String vehicleName;
	private String type;

	@Pattern(regexp = "^[a-zA-Z]{2}.{4}[0-9]{4}", message = "Please enter valid vehicle number")
	private String vehicleNumber;

	@NotBlank(message = "Please enter vehicle identification")
	private String identification;
	private int empId;
	private int passId;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getPassId() {
		return passId;
	}

	public void setPassId(int passId) {
		this.passId = passId;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", type=" + type
				+ ", vehicleNumber=" + vehicleNumber + ", identification=" + identification + ", empId=" + empId + "]";
	}
}
