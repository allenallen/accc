package com.accc.forms;

public class CarForm {

	private String make;

	private String plateNumber;

	private String vehicleColor;

	private String odometer;

	public CarForm(String make, String plateNumber, String vehicleColor, String odometer) {
		this.make = make;
		this.plateNumber = plateNumber;
		this.vehicleColor = vehicleColor;
		this.odometer = odometer;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public String getOdometer() {
		return odometer;
	}

	public void setOdometer(String odometer) {
		this.odometer = odometer;
	}

	@Override
	public String toString() {
		return "CarForm [make=" + make + ", plateNumber=" + plateNumber + ", vehicleColor=" + vehicleColor
				+ ", odometer=" + odometer + "]";
	}

}
