package com.accc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accc.domain.model.Car;
import com.accc.domain.model.Customer;
import com.accc.domain.model.JobOrder;

@Repository
public interface JobOrderRepository extends JpaRepository<JobOrder, String> {

	JobOrder findByJoNumber(String joNumber);

	List<JobOrder> findAllByCar(Car car);

	List<JobOrder> findAllByCustomer(Customer customer);
	
	@Query("SELECT jobOrder From JobOrder jobOrder WHERE MONTH({d 'jobOrder.date.toString()'}) = :month")
	List<JobOrder> findByMonth(int month);
	
	JobOrder findTopByJobOrder();
}
