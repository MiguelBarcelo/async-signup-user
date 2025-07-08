package com.miguel_barcelo.async_signup_user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miguel_barcelo.async_signup_user.dto.UserRequestDTO;
import com.miguel_barcelo.async_signup_user.model.User;
import com.miguel_barcelo.async_signup_user.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public String register(@RequestBody UserRequestDTO dto) {
		User user = new User(dto.getName(), dto.getEmail());
		userService.registerUser(user);
		
		return "✅ User registered successfully!";
	}
}
