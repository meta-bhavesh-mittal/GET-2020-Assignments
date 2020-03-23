package com.metacube.metaparkingsystemv2.models;

public class Pass {
	private int passId;
	private int vehicleId;
	private String passType;
	private double passPrice;

	public int getPassId() {
		return passId;
	}

	public void setPassId(int passId) {
		this.passId = passId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getPassType() {
		return passType;
	}

	public void setPassType(String passType) {
		this.passType = passType;
	}

	public double getPassPrice() {
		return passPrice;
	}

	public void setPassPrice(double passPrice) {
		this.passPrice = passPrice;
	}

	@Override
	public String toString() {
		return "Pass [passId=" + passId + ", vehicleId=" + vehicleId + ", passType=" + passType + ", passPrice="
				+ passPrice + "]";
	}

}
