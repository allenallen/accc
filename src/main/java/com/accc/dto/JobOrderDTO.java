package com.accc.dto;

import java.util.ArrayList;
import java.util.List;

import com.accc.domain.model.JobOrder;

public class JobOrderDTO {

	private String joNumber;
	private String name;
	private String date;
	private String make;
	private String address;
	private String contactNumber;
	private String plateNumber;
	private String vehicleColor;
	private String odometer;
	private List<JobDescriptionDTO> jobDescriptions;
	private List<PartsDTO> parts;
	private String totalAmountDue;
	private String datePaid;
	private String depositDate;

	public JobOrderDTO() {
	}

	public static List<JobOrderDTO> buildFromEntities(List<JobOrder> jos) {
		ArrayList<JobOrderDTO> dtos = new ArrayList<>();

		for (JobOrder jo : jos) {
			JobOrderDTO dto = new JobOrderDTO();
			dto.setAddress(jo.getAddress());
			dto.setContactNumber(jo.getContactNumber());
			dto.setDate(jo.getDate().toString());
			dto.setDatePaid(jo.getDatePaid().toString());
			dto.setDepositDate(jo.getDepositDate().toString());
			dto.setJobDescriptions(JobDescriptionDTO.buildFromEntities(jo.getJobDescriptions()));
			dto.setJoNumber(jo.getJoNumber());
			dto.setMake(jo.getMake());
			dto.setName(jo.getName());
			dto.setOdometer(jo.getOdomoter());
			dto.setParts(PartsDTO.buildFromEntities(jo.getParts()));
			dto.setPlateNumber(jo.getPlateNumber());
			dto.setTotalAmountDue(jo.getTotalAmountDue().toString());
			dto.setVehicleColor(jo.getVehicleColor());
			dtos.add(dto);
		}

		return dtos;
	}

	public String getJoNumber() {
		return joNumber;
	}

	public void setJoNumber(String joNumber) {
		this.joNumber = joNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
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

	public List<JobDescriptionDTO> getJobDescriptions() {
		return jobDescriptions;
	}

	public void setJobDescriptions(List<JobDescriptionDTO> jobDescriptions) {
		this.jobDescriptions = jobDescriptions;
	}

	public List<PartsDTO> getParts() {
		return parts;
	}

	public void setParts(List<PartsDTO> parts) {
		this.parts = parts;
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
		return "JobOrderDTO [joNumber=" + joNumber + ", name=" + name + ", date=" + date + ", make=" + make
				+ ", address=" + address + ", contactNumber=" + contactNumber + ", plateNumber=" + plateNumber
				+ ", vehicleColor=" + vehicleColor + ", odometer=" + odometer + ", jobDescriptions=" + jobDescriptions
				+ ", parts=" + parts + ", totalAmountDue=" + totalAmountDue + ", datePaid=" + datePaid
				+ ", depositDate=" + depositDate + "]";
	}

}
