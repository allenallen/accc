package com.accc.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.accc.domain.model.Car;
import com.accc.domain.model.Customer;
import com.accc.domain.model.JobOrder;

public class JobOrderDTO {
	
	private String id;
	private String date;
	private CustomerDTO customer;
	private CarDTO car;
	private String joNumber;
	private List<JobDescriptionDTO> jobDescriptions;
	private List<PartsDTO> parts;
	private List<EmployeeDTO> technician;
	private String totalAmountDue;
	private String datePaid;
	private String dateDeposit;
	
	public static JobOrderDTO buildFromEntity(JobOrder jobOrder) {
		JobOrderDTO dto = new JobOrderDTO();
		dto.setId(jobOrder.getId());
		dto.setDate(jobOrder.getDate().toString());
		dto.setCustomer(CustomerDTO.buildFromEntity(jobOrder.getCustomer()));
		dto.setCar(CarDTO.buildFromEntity(jobOrder.getCar()));
		dto.setJoNumber(String.valueOf(jobOrder.getJoNumber()));
		dto.setJobDescriptions(JobDescriptionDTO.buildFromEntities(jobOrder.getJobDescriptions()));
		dto.setParts(PartsDTO.buildFromEntities(jobOrder.getParts()));
		dto.setTechnician(EmployeeDTO.buildFromEntities(jobOrder.getTechnician()));
		dto.setTotalAmountDue(jobOrder.getTotalAmountDue().toString());
		dto.setDatePaid(String.valueOf(jobOrder.getDatePaid()));
		dto.setDateDeposit(String.valueOf(jobOrder.getDateDeposit()));
		
		return dto;
	}
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


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}


	public String getJoNumber() {
		return joNumber;
	}


	public void setJoNumber(String joNumber) {
		this.joNumber = joNumber;
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


	public List<EmployeeDTO> getTechnician() {
		return technician;
	}


	public void setTechnician(List<EmployeeDTO> technician) {
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


	public String getDateDeposit() {
		return dateDeposit;
	}


	public void setDateDeposit(String dateDeposit) {
		this.dateDeposit = dateDeposit;
	}


	public JobOrderDTO() {}
}
