package com.ecommerce.order.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.order.model.User;
import com.ecommerce.order.service.IUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController
{

	private final IUserService userService;

	@PostMapping(value = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> createUser(@RequestBody @Validated User user) throws Exception
	{
		return ResponseEntity.ok(userService.saveUser(user).get());
	}

	@PutMapping(value = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> updateUser(@RequestBody @Validated User user) throws Exception
	{
		return ResponseEntity.ok(userService.updateUser(user).get());
	}

	@GetMapping(value = "/{userId}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> getUser(@PathVariable String userId) throws Exception
	{
		return ResponseEntity.ok(userService.getUser(userId).get());
	}

	@GetMapping(value = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<User>> getAllUsers() throws Exception
	{
		return ResponseEntity.ok(userService.getUsers());
	}

	@DeleteMapping(value = "/{userId}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> deleteUser(@PathVariable String userId) throws Exception
	{
		return ResponseEntity.ok(userService.deleteUser(userId).get());
	}
}
