package com.accc.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accc.domain.model.JobOrder;
import com.accc.domain.model.Parts;
import com.accc.repository.PartsRepository;

@Service
@Transactional(readOnly = true)
public class PartsServiceImpl implements PartsService {

	@Autowired
	private PartsRepository partsRepository;

	@Override
	public List<Parts> findAllByJobOrder(JobOrder jobOrder) {
		return partsRepository.findAllByJobOrder(jobOrder);
	}

	@Override
	public List<Parts> findAllByDate(LocalDate date) {
		return partsRepository.findAllByDate(date);
	}

	@Override
	@Transactional(readOnly = false)
	public Parts create(Parts parts) {
		return partsRepository.save(parts);
	}

}
