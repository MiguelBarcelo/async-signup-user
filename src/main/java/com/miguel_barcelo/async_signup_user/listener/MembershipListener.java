package com.miguel_barcelo.async_signup_user.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.miguel_barcelo.async_signup_user.event.MembershipExpiredEvent;

@Component
public class MembershipListener {

	@Async("taskExecutor")
	@EventListener
	public void handleMembershipExpired(MembershipExpiredEvent event) {
		try {
			Thread.sleep(500); // Simulates
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("📬 Reminder sent for expired membership: " + event.getUser().getEmail() +
				" [Thread: " + Thread.currentThread().getName() + "]");
	}
}
