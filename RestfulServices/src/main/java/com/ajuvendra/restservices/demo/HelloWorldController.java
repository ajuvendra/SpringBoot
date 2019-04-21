package com.ajuvendra.restservices.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
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
	
	/*
	 * @GetMapping("/hello-world-ineternationalized") public String
	 * helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required
	 * = false) Locale locale) { return
	 * messageSource.getMessage("good.morning.message", null, locale); }
	 */
	
	@GetMapping("/hello-world-ineternationalized")
	public String helloWorldInternationalized()	{
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
