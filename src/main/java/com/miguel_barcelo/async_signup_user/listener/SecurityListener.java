package com.miguel_barcelo.async_signup_user.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.miguel_barcelo.async_signup_user.event.PasswordChangedEvent;

@Component
public class SecurityListener {
	
	private static final Logger log = LoggerFactory.getLogger(SecurityListener.class);

	@Async("taskExecutor")
	@EventListener
	public void handlePasswordChange(PasswordChangedEvent event) {
		try {
			log.info("🔐 Handling PasswordChangedEvent for {}", event.getUser().getEmail());
			Thread.sleep(500); // Simulates operation
			log.info("📣 Password change logged for {}", event.getUser().getEmail());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			log.warn("⚠️ Thread interrupted while handling PasswordChangedEvent", e);
		} catch (Exception e) {
			log.error("❌ Error in SecurityListener while handling PasswordChangedEvent", e);
		}
	}
}
