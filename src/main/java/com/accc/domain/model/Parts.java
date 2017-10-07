package com.accc.domain.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Parts {

	private String parts;
	
	private BigDecimal amount;

	public String getParts() {
		return parts;
	}

	public void setParts(String parts) {
		this.parts = parts;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Parts [parts=" + parts + ", amount=" + amount + "]";
	}
}
