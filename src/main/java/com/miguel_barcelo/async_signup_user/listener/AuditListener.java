package com.miguel_barcelo.async_signup_user.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.miguel_barcelo.async_signup_user.event.UserRegisteredEvent;

@Component
public class AuditListener {

	@Async("taskExecutor")
	@EventListener
	public void auditUserRegistration(UserRegisteredEvent event) {
		try {
			Thread.sleep(1000); // Simulates audit log
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("🕵️ Audit log for user: " + event.getUser().getName() + 
				" [Thread: " + Thread.currentThread().getName() + "]");
	}
}
