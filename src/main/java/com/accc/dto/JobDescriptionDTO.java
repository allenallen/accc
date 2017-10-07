package com.accc.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.accc.domain.model.JobDescription;

public class JobDescriptionDTO {

	private String jobDescription;
	private String labor;

	public JobDescriptionDTO() {
	}

	public JobDescriptionDTO(String jobDescription, String labor) {
		this.jobDescription = jobDescription;
		this.labor = labor;
	}

	public static List<JobDescriptionDTO> buildFromEntities(List<JobDescription> jobDescs) {
		return jobDescs.stream().map(jd -> {
			return new JobDescriptionDTO(jd.getJobDescription(), jd.getLabor().toString());
		}).collect(Collectors.toList());
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

	@Override
	public String toString() {
		return "JobDescriptionDTO [jobDescription=" + jobDescription + ", labor=" + labor + "]";
	}

}
