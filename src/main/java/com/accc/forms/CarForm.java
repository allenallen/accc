package com.accc.forms;

public class CarForm {

	private String make;

	private String plateNumber;

	private String vehicleColor;

	private String odometer;
	
	private String customerId;
	
	public CarForm() {}

	public CarForm(String make, String plateNumber, String vehicleColor, String odometer, String customerId) {
		this.make = make;
		this.plateNumber = plateNumber;
		this.vehicleColor = vehicleColor;
		this.odometer = odometer;
		this.customerId = customerId;
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

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}
