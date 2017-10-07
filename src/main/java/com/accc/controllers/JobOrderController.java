package com.accc.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accc.domain.model.JobOrder;
import com.accc.domain.model.ModalResponse;
import com.accc.dto.JobOrderDTO;
import com.accc.forms.JobOrderForm;
import com.accc.service.JobOrderService;

@RestController
@RequestMapping("/joborder")
public class JobOrderController {
	final static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	JobOrderService jobOrderService;

	@GetMapping("/")
	public List<JobOrderDTO> getAll() {
		return JobOrderDTO.buildFromEntities(jobOrderService.getAll());
	}

	@RequestMapping(value = "/add", method = RequestMethod.PUT, consumes = "application/json")
	public ModalResponse addJobOrder(@RequestBody JobOrderForm jobOrderForm) {
		System.out.println(jobOrderForm);
		JobOrder jo = JobOrder.buildFromForm(jobOrderForm);

		jobOrderService.addJobOrder(jo);

		ModalResponse resp = new ModalResponse("Success. JO: " + jo, HttpStatus.OK);
		return resp;
	}
}
