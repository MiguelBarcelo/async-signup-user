package com.miguel_barcelo.async_signup_user.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.miguel_barcelo.async_signup_user.model.User;
import com.miguel_barcelo.async_signup_user.event.MembershipExpiredEvent;

@Service
public class MembershipService {

	private final ApplicationEventPublisher eventPublisher;
	
	public MembershipService(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}
	
	public void checkAndExpiredMembership(User user) {
		System.out.println("🕓 Checking membership for: " + user.getName());
		
		// Simulates that user has expired
		boolean expired = true;
		
		if (expired) {
			eventPublisher.publishEvent(new MembershipExpiredEvent(user));
		}
		
	}
}
