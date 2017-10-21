package com.accc.service;

import java.time.LocalDate;
import java.util.List;

import com.accc.domain.model.JobOrder;
import com.accc.domain.model.Parts;

public interface PartsService {

	List<Parts> findAllByJobOrder(JobOrder jobOrder);
	
	List<Parts> findAllByDate(LocalDate date);
	
	Parts create(Parts parts);
}
