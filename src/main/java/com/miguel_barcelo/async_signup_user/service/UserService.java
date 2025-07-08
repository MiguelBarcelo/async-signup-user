package com.miguel_barcelo.async_signup_user.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.miguel_barcelo.async_signup_user.model.User;
import com.miguel_barcelo.async_signup_user.event.UserRegisteredEvent;

@Service
public class UserService {
	
	private final ApplicationEventPublisher eventPublisher;
	
	public UserService(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}
	
	public void registerUser(User user) {
		// Simulate saving record
		System.out.println("💾 Saving user to DB: " + user.getName());
		
		// Launch the event
		eventPublisher.publishEvent(new UserRegisteredEvent(user));
	}
}
