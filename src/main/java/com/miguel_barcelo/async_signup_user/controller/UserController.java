package com.miguel_barcelo.async_signup_user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miguel_barcelo.async_signup_user.dto.UserRequestDTO;
import com.miguel_barcelo.async_signup_user.model.User;
import com.miguel_barcelo.async_signup_user.service.MembershipService;
import com.miguel_barcelo.async_signup_user.service.SecurityService;
import com.miguel_barcelo.async_signup_user.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;
	private final SecurityService securityService;
	private final MembershipService membershipService;
	
	public UserController(UserService userService, SecurityService securityService, MembershipService membershipService) {
		this.userService = userService;
		this.securityService = securityService;
		this.membershipService = membershipService;
	}
	
	@PostMapping("/register")
	public String register(@RequestBody UserRequestDTO dto) {
		User user = new User(dto.getName(), dto.getEmail());
		userService.registerUser(user);
		
		return "✅ User registered successfully!";
	}
	
	@GetMapping("/change-password")
	public String changePassword() {
		User user = new User("Han Solo", "han@falcon.com");
		securityService.changePassword(user, "newpass123");
		
		return "Password changed!";
	}
	
	@GetMapping("/expire-membership")
	public String expireMembership() {
		User user = new User("Chewbacca", "chewie@kashyyyk.com");
		membershipService.checkAndExpiredMembership(user);
		
		return "Membership checked!";
	}
}
