package com.ajuvendra.restservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 3765619673807831210L;
	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
