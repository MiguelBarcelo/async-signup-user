package com.miguel_barcelo.async_signup_user.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.miguel_barcelo.async_signup_user.model.User;
import com.miguel_barcelo.async_signup_user.event.PasswordChangedEvent;

@Service
public class SecurityService {

	private final ApplicationEventPublisher eventPublisher;
	
	public SecurityService(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}
	
	public void changePassword(User user, String newPassword) {
		System.out.println("🔐 Changing password for: " + user.getName());
		
		// Simulates change password...
		
		// Launch event
		eventPublisher.publishEvent(new PasswordChangedEvent(user));
	}
}
