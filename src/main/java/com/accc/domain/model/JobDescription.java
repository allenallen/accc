package com.accc.domain.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class JobDescription {

	private String jobDescription;
	private BigDecimal labor;

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public BigDecimal getLabor() {
		return labor;
	}

	public void setLabor(BigDecimal labor) {
		this.labor = labor;
	}

	@Override
	public String toString() {
		return "JobDescription [jobDescription=" + jobDescription + ", labor=" + labor + "]";
	}
}
