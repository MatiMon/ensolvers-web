package com.ensolvers.webexercise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensolvers.webexercise.domain.User;
import com.ensolvers.webexercise.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public void createUser(@RequestBody User user) {
		this.userService.createUser(user);
	}
	
	
}
