package com.accc.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Parts {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private Integer quantity;

	private String description;

	private BigDecimal amount;

	@Column(unique = true)
	private String orNumber;

	private LocalDate date;

	@ManyToOne
	@Column(nullable = true)
	private JobOrder jobOrder;

	protected Parts() {
	}

	public Parts(int quantity, String description, String orNumber, LocalDate date, BigDecimal amount,
			JobOrder jobOrder) {
		this.quantity = quantity;
		this.description = description;
		this.orNumber = orNumber;
		this.date = date;
		this.amount = amount;
		this.jobOrder = jobOrder;
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
		Parts other = (Parts) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String parts) {
		this.description = parts;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Parts [description=" + description + ", amount=" + amount + "]";
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the orNumber
	 */
	public String getOrNumber() {
		return orNumber;
	}

	/**
	 * @param orNumber
	 *            the orNumber to set
	 */
	public void setOrNumber(String orNumber) {
		this.orNumber = orNumber;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
}
