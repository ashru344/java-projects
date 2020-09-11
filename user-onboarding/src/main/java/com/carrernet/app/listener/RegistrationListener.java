package com.carrernet.app.listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;

import com.carrernet.app.entity.User;
import com.carrernet.app.model.OnRegistrationCompleteEvent;
import com.carrernet.app.service.EmailService;
import com.carrernet.app.service.UserService;

public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

	@Autowired
	private UserService service;

	@Autowired
	private MessageSource messages;

	@Autowired
	private EmailService emailService;

	@Override
	public void onApplicationEvent(OnRegistrationCompleteEvent event) {
		this.confirmRegistration(event);
	}

	private void confirmRegistration(OnRegistrationCompleteEvent event) {
		User user = event.getUser();
		String token = UUID.randomUUID().toString();
		service.createVerificationToken(user, token);

		String recipientAddress = user.getUserName();
		String subject = "Registration Confirmation";
		String confirmationUrl = event.getAppUrl() + "/regitrationConfirm.html?token=" + token;
		String message = messages.getMessage("message.regSucc", null, event.getLocale());

		emailService.sendEmail(user.getUserName(), user.getUserName(),
				"message + \"\\r\\n\" + \"http://localhost:8080\" + confirmationUrl");
	}
}
