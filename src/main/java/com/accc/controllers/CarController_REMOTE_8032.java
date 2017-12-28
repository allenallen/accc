package com.accc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accc.service.CarService;

@Controller
@RequestMapping("/api/car")
public class CarController {

	@Autowired
	private CarService carService;
	
}
