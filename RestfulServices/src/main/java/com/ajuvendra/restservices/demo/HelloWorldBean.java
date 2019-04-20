package com.ajuvendra.restservices.demo;

public class HelloWorldBean {
	String message;

	public HelloWorldBean() {
		super();
	}

	public HelloWorldBean(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
