package com.ajuvendra.restservices.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@GetMapping("/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/helloworld-bean")
	public HelloWorldBean helloWorldObject() {
		return new HelloWorldBean("Hello World!");
	}
	
	@GetMapping("/helloworld-bean/{name}")
	public HelloWorldBean helloWorldPathParameter(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World::: %s", name));
	}
}
