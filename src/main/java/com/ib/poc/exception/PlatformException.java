package com.ib.poc.exception;

import org.springframework.http.HttpStatus;

public class PlatformException  extends Exception{

	private String message;
	
	private HttpStatus status;
	
	public PlatformException(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}
	
	
	
}


