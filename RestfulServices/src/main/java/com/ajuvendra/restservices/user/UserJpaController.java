package com.ajuvendra.restservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
public class UserJpaController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@GetMapping(path = "/jpa/users")
	public List<UserBean> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping(path = "/jpa/users/{id}")
	public Resource<UserBean> findById(@PathVariable int id) {
		Optional<UserBean> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		}
		Resource<UserBean> resource = new Resource<>(user.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@PostMapping(path = "/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserBean user) {
		UserBean userBean = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userBean.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/jpa/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(path = "jpa/users/{id}/posts")
	public List<Post> retrieveAllUserPosts(@PathVariable int id) {
		Optional<UserBean> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		}
		return user.get().getPosts();
	}

	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
		Optional<UserBean> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id- " + id);
		}
		UserBean user = userOptional.get();
		post.setUser(user);
		postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
