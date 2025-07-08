package com.miguel_barcelo.async_signup_user.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.miguel_barcelo.async_signup_user.event.PasswordChangedEvent;

@Component
public class SecurityListener {

	@Async("taskExecutor")
	@EventListener
	public void handlePasswordChange(PasswordChangedEvent event) {
		try {
			Thread.sleep(500); // Simulates operation
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("📣 Password change logged for: " + event.getUser().getEmail() + 
				"[Thread: " + Thread.currentThread().getName() + "]");
	}
}
