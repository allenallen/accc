package com.accc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accc.domain.model.JobOrder;

@Repository
public interface JobOrderRepository extends CrudRepository<JobOrder, String>{

}
