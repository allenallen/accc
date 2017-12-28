package com.accc.domain.model;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class JobOrder {

	@Transient
	static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private LocalDate date;

	@ManyToOne
	@Column(nullable = true)
	private Customer customer;

	@ManyToOne
	@Column(nullable = true)
	private Car car;

	@Column(unique = true)
	private Integer joNumber = 0;

	@ElementCollection
	@CollectionTable(name = "jo_job_desc", joinColumns = @JoinColumn(name = "jo_number", referencedColumnName = "joNumber"))
	private List<JobDescription> jobDescriptions;

	@OneToMany(cascade = CascadeType.PERSIST)
	@Column(nullable = true)
	private List<Parts> parts;

	@ManyToMany
	@Column(nullable = true)
	private List<Employees> technician;

	private BigDecimal totalAmountDue;
	private LocalDate datePaid;
	private LocalDate dateDeposit;

	protected JobOrder() {
	}

	public JobOrder(LocalDate date, Customer customer, Car car, List<JobDescription> jobDescription, List<Parts> parts,
			List<Employees> technician, BigDecimal totalAmountDue, LocalDate datePaid, LocalDate dateDeposit) {

		this.date = date;
		this.setCustomer(customer);
		this.setCar(car);
		this.jobDescriptions = jobDescription;
		this.parts = parts;
		this.technician = technician;
		this.totalAmountDue = totalAmountDue;
		this.datePaid = datePaid;
		this.dateDeposit = dateDeposit;
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

	public Integer getJoNumber() {
		return joNumber;
	}

	public void setJoNumber(Integer joNumber) {
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

	public List<Employees> getTechnician() {
		return technician;
	}

	public void setTechnician(List<Employees> technician) {
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

	public LocalDate getDateDeposit() {
		return dateDeposit;
	}

	public void setDateDeposit(LocalDate depositDate) {
		this.dateDeposit = depositDate;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
					.append(id)
					.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobOrder other = (JobOrder) obj;

		return new EqualsBuilder()
					.append(id, other.id)
					.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
					.append("id", id)
					.append("date", date)
					.append("customer", getCustomer())
					.append("car", getCar())
					.append("joNumber", joNumber)
					.append("jobDescription", jobDescriptions)
					.append("parts", parts)
					.append("technician", technician)
					.append("totalAmountDue", totalAmountDue)
					.append("datePaid", datePaid)
					.append("dateDeposit", dateDeposit)
					.toString();
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * @param car the car to set
	 */
	public void setCar(Car car) {
		this.car = car;
	}
}
