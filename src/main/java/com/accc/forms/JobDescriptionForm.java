package com.accc.forms;

import java.io.Serializable;

public class JobDescriptionForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String jobDescription;
	private String labor;

	public JobDescriptionForm() {
	}

	public JobDescriptionForm(String jobDescription, String labor) {
		this.jobDescription = jobDescription;
		this.labor = labor;
	}

	@Override
	public String toString() {
		return "JobDescriptionForm [jobDescription=" + jobDescription + ", labor=" + labor + "]";
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getLabor() {
		return labor;
	}

	public void setLabor(String labor) {
		this.labor = labor;
	}

}
