package com.accc.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.accc.forms.CarForm;

@Entity
public class Car {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Column
	private String make;

	@Column(unique = true)
	private String plateNumber;

	@Column
	private String vehicleColor;

	@Column
	private String odometer;

	@ManyToOne
	private Customer customer;

	public Car(String make, String plateNumber, String vehicleColor, String odometer, Customer customer) {
		this.make = make;
		this.plateNumber = plateNumber;
		this.vehicleColor = vehicleColor;
		this.odometer = odometer;
		this.customer = customer;
	}
	
	public void updateFromForm(CarForm form) {
		this.make = form.getMake();
		this.plateNumber = form.getPlateNumber();
		this.vehicleColor = form.getVehicleColor();
		this.odometer = form.getOdometer();
	}
	
	public String getId() {
		return id;
	}

	public String getMake() {
		return make;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public String getOdometer() {
		return odometer;
	}

	public Customer getCustomer() {
		return customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", plateNumber=" + plateNumber + ", vehicleColor=" + vehicleColor
				+ ", odometer=" + odometer + ", customer=" + customer + "]";
	}

	protected Car() {
	}
}
