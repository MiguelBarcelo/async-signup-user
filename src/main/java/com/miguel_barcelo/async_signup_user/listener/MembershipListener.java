package com.miguel_barcelo.async_signup_user.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.miguel_barcelo.async_signup_user.event.MembershipExpiredEvent;

@Component
public class MembershipListener {
	
	private static final Logger log = LoggerFactory.getLogger(MembershipListener.class);

	@Async("taskExecutor")
	@EventListener
	public void handleMembershipExpired(MembershipExpiredEvent event) {
		try {
			log.info("📬 Handling MembershipExpiredEvent for {}", event.getUser().getEmail());
			Thread.sleep(500); // Simulates
			log.info("📬 Reminder sent for expired membership: {}", event.getUser().getEmail());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			log.warn("⚠️ Thread interrupted while handling MembershipExpiredEvent", e);
		} catch (Exception e) {
			log.error("❌ Error in MembershipListener while handling MembershipExpiredEvent", e);
		}
	}
}
