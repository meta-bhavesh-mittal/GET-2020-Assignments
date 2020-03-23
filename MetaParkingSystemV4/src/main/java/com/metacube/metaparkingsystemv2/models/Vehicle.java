package com.metacube.metaparkingsystemv2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="vehicle_id")
	private int vehicleId;

	@Pattern(regexp = "^[a-zA-Z0-9]{2,}$", message = "Please enter valid vehicle name")
	@Column(name="vehicle_name")
	private String vehicleName;
	
	@Column(name="type")
	private String type;

	@Pattern(regexp = "^[a-zA-Z]{2}.{4}[0-9]{4}", message = "Please enter valid vehicle number")
	@Column(name="vehicle_number")
	private String vehicleNumber;

	@NotBlank(message = "Please enter vehicle identification")
	@Column(name="identification")
	private String identification;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Employee employee;
	
	@OneToOne(fetch=FetchType.EAGER)
	private PassInfo passInfo;

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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public PassInfo getPassInfo() {
		return passInfo;
	}

	public void setPassInfo(PassInfo passInfo) {
		this.passInfo = passInfo;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", type=" + type
				+ ", vehicleNumber=" + vehicleNumber + ", identification=" + identification + ", employee=" + employee
				+ ", passInfo=" + passInfo + "]";
	}
}
