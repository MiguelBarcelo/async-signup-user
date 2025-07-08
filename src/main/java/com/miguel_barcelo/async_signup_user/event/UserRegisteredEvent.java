package com.miguel_barcelo.async_signup_user.event;

import com.miguel_barcelo.async_signup_user.model.User;

public class UserRegisteredEvent {

	private final User user;
	
	public UserRegisteredEvent(User user) {
		this.user = user;
	}
	
	public User getUser() { return user; }
}
