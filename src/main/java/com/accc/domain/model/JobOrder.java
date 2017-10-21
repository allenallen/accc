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

import org.hibernate.annotations.GenericGenerator;

import com.accc.forms.JobOrderForm;

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
		this.customer = customer;
		this.car = car;
		this.jobDescriptions = jobDescription;
		this.parts = parts;
		this.technician = technician;
		this.totalAmountDue = totalAmountDue;
		this.datePaid = datePaid;
		this.dateDeposit = dateDeposit;
	}

	public static JobOrder buildFromForm(JobOrderForm form) {
		return null;
		// JobOrder jo = new JobOrder();
		// if (form.getId() != null) {
		// jo.setId(form.getId());
		// }
		//
		// jo.setDate(LocalDate.parse(form.getDate()));
		// jo.setJoNumber(form.getJoNumber());
		//
		// ArrayList<JobDescription> jobDescs = new ArrayList<>();
		// for (int i = 0; i < form.getJobDescriptions().size(); i++) {
		// JobDescription jd = new JobDescription();
		// jd.setJobDescription(form.getJobDescriptions().get(i).getJobDescription());
		// jd.setLabor(new BigDecimal(form.getJobDescriptions().get(i).getLabor()));
		// jobDescs.add(jd);
		// }
		// jo.setJobDescriptions(jobDescs);
		//
		// ArrayList<Parts> parts = new ArrayList<>();
		// for (int i = 0; i < form.getParts().size(); i++) {
		// Parts p = new Parts();
		// p.setDescription(form.getParts().get(i).getParts());
		// p.setAmount(new BigDecimal(form.getParts().get(i).getAmount()));
		// parts.add(p);
		// }
		// jo.setParts(parts);
		//
		// jo.setTotalAmountDue(new BigDecimal(form.getTotalAmountDue()));
		// jo.setDatePaid(LocalDate.parse(form.getDatePaid()));
		//
		// return jo;
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
}
