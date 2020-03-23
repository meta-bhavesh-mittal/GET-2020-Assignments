package com.metacube.metaparkingsystemv2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PassInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pass_id")
	private int passId;
	
	@Column(name="pass_type")
	private String passType;
	
	@Column(name="vehicle_type")
	private String vehicleType;
	
	@Column(name="pass_price")
	private double passPrice;

	public int getPassId() {
		return passId;
	}

	public void setPassId(int passId) {
		this.passId = passId;
	}

	public String getPassType() {
		return passType;
	}

	public void setPassType(String passType) {
		this.passType = passType;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public double getPassPrice() {
		return passPrice;
	}

	public void setPassPrice(double passPrice) {
		this.passPrice = passPrice;
	}

	@Override
	public String toString() {
		return "PassInfo [passId=" + passId + ", passType=" + passType + ", vehicleType=" + vehicleType + ", passPrice="
				+ passPrice + "]";
	}
	
}
