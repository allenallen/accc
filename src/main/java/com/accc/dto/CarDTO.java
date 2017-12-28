package com.accc.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import com.accc.domain.model.Car;
import com.accc.domain.model.Customer;

public class CarDTO {
	private String id;
	private String make;
	private String plateNumber;
	private String vehicleColor;
	private String odometer;
	private CustomerDTO customer;
	
	public static CarDTO buildFromEntity(Car car) {
		CarDTO dto = new CarDTO();
		dto.setId(car.getId());
		dto.setMake(car.getMake());
		dto.setPlateNumber(car.getPlateNumber());
		dto.setVehicleColor(car.getVehicleColor());
		dto.setOdometer(car.getOdometer());
		dto.setCustomer(CustomerDTO.buildFromEntity(car.getCustomer()));
	}
	
	public static List<CarDTO> buildFromEntities(List<Car> cars){
		return cars.stream().map(car ->  buildFromEntity(car)).collect(Collectors.toList());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CarDTO [id=" + id + ", make=" + make + ", plateNumber=" + plateNumber + ", vehicleColor=" + vehicleColor
				+ ", odometer=" + odometer + "]";
	}
	
	public CarDTO() {}
}
