package com.springsecurity.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.springsecurity.document.entity.Customer;
import com.springsecurity.springsecurity.entity.Users;
import com.springsecurity.springsecurity.service.UserService;

@RestController

public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/register")
	public Users register(@RequestBody Users user) {

		return service.register(user);

	}

	@PostMapping("/login")
	public String login(@RequestBody Customer user) {

		return service.verify(user);
	}

	@GetMapping("/getAll")
	public List<Users> getAllRegisterDetails() {
		return service.getAllRegisterUsers();
	}

}
