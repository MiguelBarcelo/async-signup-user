package com.miguel_barcelo.async_signup_user.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.miguel_barcelo.async_signup_user.event.UserRegisteredEvent;

@Component
public class NotificationListener {

	@Async("taskExecutor")
	@EventListener
	public void handleUserRegistered(UserRegisteredEvent event) {
		try {
			Thread.sleep(2000); // Simulates sending email
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("📧 Email sent to: " + event.getUser().getEmail() + 
				" [Thread: " + Thread.currentThread().getName() + "]");
	}
}
