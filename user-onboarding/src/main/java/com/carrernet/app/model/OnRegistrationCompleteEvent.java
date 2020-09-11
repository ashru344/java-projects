package com.carrernet.app.model;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.carrernet.app.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OnRegistrationCompleteEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1850759014881119212L;

	private String appUrl;
	private Locale locale;
	private User user;

	public OnRegistrationCompleteEvent(User user, Locale locale, String appUrl) {
		super(user);

		this.user = user;
		this.locale = locale;
		this.appUrl = appUrl;
	}

}
