package com.accc.forms;

import java.io.Serializable;

public class PartsForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String parts;
	private String amount;

	public PartsForm() {
	}

	public PartsForm(String parts, String amount) {
		this.parts = parts;
		this.amount = amount;
	}

	public String getParts() {
		return parts;
	}

	public void setParts(String parts) {
		this.parts = parts;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PartsForm [parts=" + parts + ", amount=" + amount + "]";
	}

}
