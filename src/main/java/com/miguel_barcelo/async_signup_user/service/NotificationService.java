package com.miguel_barcelo.async_signup_user.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.miguel_barcelo.async_signup_user.model.User;

@Service
public class NotificationService {

	@Async("taskExecutor")
	public void sendWelcomeEmail(User user) {
		try {
			Thread.sleep(2000); // Simulates sending email
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("📧 Email sent to: " + user.getEmail() + " [Thread: " + Thread.currentThread().getName() + "]");
	}
}
