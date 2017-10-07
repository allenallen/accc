package com.accc.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.accc.forms.JobOrderForm;

@Entity
@Table(name = "job_order")
public class JobOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7272337262380770926L;

	@Transient
	static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private LocalDate date;
	private String name;
	private String address;
	private String contactNumber;
	private String make;
	private String plateNumber;
	private String vehicleColor;
	private String odomoter;
	@Column(unique = true)
	private String joNumber;

	@ElementCollection
	@CollectionTable(name = "jo_job_desc", joinColumns = @JoinColumn(name = "jo_number", referencedColumnName = "joNumber"))
	private List<JobDescription> jobDescriptions;

	@ElementCollection
	@CollectionTable(name = "jo_parts", joinColumns = @JoinColumn(name = "jo_number", referencedColumnName = "joNumber"))
	private List<Parts> parts;

	@Transient
	private List<String> technician;

	private BigDecimal totalAmountDue;
	private LocalDate datePaid;
	private LocalDate depositDate;

	protected JobOrder() {
	}

	public static JobOrder buildFromForm(JobOrderForm form) {
		JobOrder jo = new JobOrder();
		if (form.getId() != null) {
			jo.setId(form.getId());
		}

		jo.setDate(LocalDate.parse(form.getDate()));
		jo.setName(form.getName());
		jo.setAddress(form.getAddress());
		jo.setContactNumber(form.getContactNumber());
		jo.setMake(form.getMake());
		jo.setPlateNumber(form.getPlateNumber());
		jo.setVehicleColor(form.getVehicleColor());
		jo.setOdomoter(form.getOdometer());
		jo.setJoNumber(form.getJoNumber());

		ArrayList<JobDescription> jobDescs = new ArrayList<>();
		for (int i = 0; i < form.getJobDescriptions().size(); i++) {
			JobDescription jd = new JobDescription();
			jd.setJobDescription(form.getJobDescriptions().get(i).getJobDescription());
			jd.setLabor(new BigDecimal(form.getJobDescriptions().get(i).getLabor()));
			jobDescs.add(jd);
		}
		jo.setJobDescriptions(jobDescs);

		ArrayList<Parts> parts = new ArrayList<>();
		for (int i = 0; i < form.getParts().size(); i++) {
			Parts p = new Parts();
			p.setParts(form.getParts().get(i).getParts());
			p.setAmount(new BigDecimal(form.getParts().get(i).getAmount()));
			parts.add(p);
		}
		jo.setParts(parts);

		jo.setTotalAmountDue(new BigDecimal(form.getTotalAmountDue()));
		jo.setDatePaid(LocalDate.parse(form.getDatePaid()));
		jo.setDepositDate(LocalDate.parse(form.getDepositDate()));

		return jo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
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

	public String getOdomoter() {
		return odomoter;
	}

	public void setOdomoter(String odomoter) {
		this.odomoter = odomoter;
	}

	public String getJoNumber() {
		return joNumber;
	}

	public void setJoNumber(String joNumber) {
		this.joNumber = joNumber;
	}

	public List<JobDescription> getJobDescriptions() {
		return jobDescriptions;
	}

	public void setJobDescriptions(List<JobDescription> jobDescriptions) {
		this.jobDescriptions = jobDescriptions;
	}

	public List<Parts> getParts() {
		return parts;
	}

	public void setParts(List<Parts> parts) {
		this.parts = parts;
	}

	public List<String> getTechnician() {
		return technician;
	}

	public void setTechnician(List<String> technician) {
		this.technician = technician;
	}

	public BigDecimal getTotalAmountDue() {
		return totalAmountDue;
	}

	public void setTotalAmountDue(BigDecimal totalAmountDue) {
		this.totalAmountDue = totalAmountDue;
	}

	public LocalDate getDatePaid() {
		return datePaid;
	}

	public void setDatePaid(LocalDate datePaid) {
		this.datePaid = datePaid;
	}

	public LocalDate getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(LocalDate depositDate) {
		this.depositDate = depositDate;
	}

	@Override
	public String toString() {
		return "JobOrder [id=" + id + ", date=" + date + ", name=" + name + ", address=" + address + ", contactNumber="
				+ contactNumber + ", make=" + make + ", plateNumber=" + plateNumber + ", vehicleColor=" + vehicleColor
				+ ", odomoter=" + odomoter + ", joNumber=" + joNumber + ", jobDescriptions=" + jobDescriptions
				+ ", parts=" + parts + ", technician=" + technician + ", totalAmountDue=" + totalAmountDue
				+ ", datePaid=" + datePaid + ", depositDate=" + depositDate + "]";
	}
}
