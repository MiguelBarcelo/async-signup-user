package com.miguel_barcelo.async_signup_user.service;

import org.springframework.stereotype.Service;

import com.miguel_barcelo.async_signup_user.model.User;

@Service
public class UserService {
	
	private final NotificationService notificationService;
	private final AuditService auditService;
	
	public UserService(NotificationService notificationService, AuditService auditService) {
		this.notificationService = notificationService;
		this.auditService = auditService;
	}
	
	public void registerUser(User user) {
		// Simulate saving record
		System.out.println("💾 Saving user to DB: " + user.getName());
		
		// Async tasks
		notificationService.sendWelcomeEmail(user);
		auditService.logUserRegistration(user);
	}
}
