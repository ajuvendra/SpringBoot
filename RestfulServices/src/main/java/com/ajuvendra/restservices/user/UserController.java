package com.ajuvendra.restservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserDaoService service;
	
	@GetMapping(path = "/users")
	public List<UserBean> getAllUsers() {
		return service.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public UserBean findById(@PathVariable int id) {
		return service.findOne(id);
	}
	
	@PostMapping(path = "/users")
	public void save(@RequestBody UserBean user) {
		service.save(user);
	}
}
