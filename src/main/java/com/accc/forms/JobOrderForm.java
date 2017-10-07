package com.accc.forms;

import java.io.Serializable;
import java.util.List;

public class JobOrderForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String date;
	private String name;
	private String address;
	private String contactNumber;
	private String make;
	private String plateNumber;
	private String vehicleColor;
	private String odometer;
	private String joNumber;

	private List<JobDescriptionForm> jobDescriptions;
	private List<PartsForm> parts;
	private List<String> technician;

	private String totalAmountDue;
	private String datePaid;
	private String depositDate;
	
	public JobOrderForm() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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

	public void setOdometer(String odomoter) {
		this.odometer = odomoter;
	}

	public String getJoNumber() {
		return joNumber;
	}

	public void setJoNumber(String joNumber) {
		this.joNumber = joNumber;
	}

	public List<JobDescriptionForm> getJobDescriptions() {
		return jobDescriptions;
	}

	public void setJobDescriptions(List<JobDescriptionForm> jobDescriptions) {
		this.jobDescriptions = jobDescriptions;
	}

	public List<PartsForm> getParts() {
		return parts;
	}

	public void setParts(List<PartsForm> parts) {
		this.parts = parts;
	}

	public List<String> getTechnician() {
		return technician;
	}

	public void setTechnician(List<String> technician) {
		this.technician = technician;
	}

	public String getTotalAmountDue() {
		return totalAmountDue;
	}

	public void setTotalAmountDue(String totalAmountDue) {
		this.totalAmountDue = totalAmountDue;
	}

	public String getDatePaid() {
		return datePaid;
	}

	public void setDatePaid(String datePaid) {
		this.datePaid = datePaid;
	}

	public String getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(String depositDate) {
		this.depositDate = depositDate;
	}

	@Override
	public String toString() {
		return "JobOrderForm [id=" + id + ", date=" + date + ", name=" + name + ", address=" + address
				+ ", contactNumber=" + contactNumber + ", make=" + make + ", plateNumber=" + plateNumber
				+ ", vehicleColor=" + vehicleColor + ", odomoter=" + odometer + ", joNumber=" + joNumber
				+ ", jobDescriptions=" + jobDescriptions + ", parts=" + parts + ", technician=" + technician + ", totalAmountDue=" + totalAmountDue + ", datePaid="
				+ datePaid + ", depositDate=" + depositDate + "]";
	}

}
