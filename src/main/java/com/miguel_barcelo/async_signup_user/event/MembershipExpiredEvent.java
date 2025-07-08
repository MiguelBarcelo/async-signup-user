package com.miguel_barcelo.async_signup_user.event;

import com.miguel_barcelo.async_signup_user.model.User;

public class MembershipExpiredEvent {

	private final User user;
	
	public MembershipExpiredEvent(User user) {
		this.user = user;
	}
	
	public User getUser() { return user; }
}
