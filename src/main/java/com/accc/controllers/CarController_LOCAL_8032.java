package com.accc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accc.domain.model.Car;
import com.accc.domain.model.ModalResponse;
import com.accc.dto.CarDTO;
import com.accc.dto.Response;
import com.accc.forms.CarForm;
import com.accc.service.CarService;
import com.google.common.collect.Lists;

@Controller
@RequestMapping("/api/cars")
public class CarController extends BaseController{

	@Autowired
	private CarService carService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Response<List<CarDTO>> findAll(){
		try {
			List<Car> cars = carService.findAll();
			return new Response<List<CarDTO>>(CarDTO.buildFromEntities(cars));
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<List<CarDTO>>(HttpStatus.INTERNAL_SERVER_ERROR, Lists.newArrayList());
		}
	}
	
	@RequestMapping(value="/", method = RequestMethod.PUT, consumes = "application/json")
	public Response<ModalResponse<CarDTO>> create(CarForm form){
		try {
			Car car = carService.create(form);
			return okModalResponse(CarDTO.buildFromEntity(car));
		} catch(Exception e) {
			e.printStackTrace();
			return errorResponse("Error");
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = "application/json")
	public Response<ModalResponse<CarDTO>> update(@PathVariable("id") String carId, CarForm form){
		try {
			Car car = carService.findById(carId);
			Car updatedCar = carService.update(car, form);
			return okModalResponse(CarDTO.buildFromEntity(updatedCar));
		} catch (Exception e) {
			e.printStackTrace();
			return errorResponse("Error");
		}
	}
}
