package com.accc.controllers;

import org.springframework.http.HttpStatus;

import com.accc.domain.model.ModalResponse;
import com.accc.dto.Response;

public class BaseController {

	<T> Response<ModalResponse<T>> errorResponse(String message) {
		Response<ModalResponse<T>> r = new Response<ModalResponse<T>>(HttpStatus.INTERNAL_SERVER_ERROR, new ModalResponse<T>(message, null));
		return r;
	}

	<T> Response<ModalResponse<T>> okModalResponse(T t) {
		return new Response<ModalResponse<T>>(new ModalResponse<T>("Ok", t));
	}

	<T> Response<T> entityResponse(T t) {
		return new Response<T>(t);
	}
}
