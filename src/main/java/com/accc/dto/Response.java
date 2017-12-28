package com.accc.dto;

import org.springframework.http.HttpStatus;

public class Response<T> {
	
	private HttpStatus status;
	
	private T t;
	
	public Response(T dto) {
		this.t = dto;
		this.status = HttpStatus.OK;
	}
	
	public Response(HttpStatus status, T dto){
		this.t = dto;
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
}
