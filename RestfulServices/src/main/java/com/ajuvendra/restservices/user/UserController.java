package com.ajuvendra.restservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ajuvendra.restservices.exception.UserNotFoundException;

@RestController
public class UserController {
	@Autowired
	private UserDaoService service;

	@GetMapping(path = "/users")
	public List<UserBean> getAllUsers() {
		return service.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public Resource<UserBean> findById(@PathVariable int id) {
		UserBean user = service.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id: " + id);
		}
		Resource<UserBean> resource = new Resource<>(user);
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserBean user) {
		UserBean userBean = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userBean.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
		UserBean user = service.deleteById(id);
		if(user == null) {
			throw new UserNotFoundException("id-" + id);
		}
		
		return ResponseEntity.noContent().build();
	}
}
