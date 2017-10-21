package com.accc.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accc.domain.model.JobOrder;
import com.accc.domain.model.Parts;

public interface PartsRepository extends JpaRepository<Parts, String>{

	List<Parts> findAllByJobOrder(JobOrder jobOrder);
	
	List<Parts> findAllByDate(LocalDate date);
}
