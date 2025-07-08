package com.miguel_barcelo.async_signup_user.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.miguel_barcelo.async_signup_user.model.User;

@Service
public class AuditService {

	@Async("taskExecutor")
	public void logUserRegistration(User user) {
		try {
			Thread.sleep(1000); // Simulates audit log
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("🕵️ Audit log for user: " + user.getName() + " [Thread: " + Thread.currentThread().getName() + "]");
	}
}
