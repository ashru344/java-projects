package com.carrernet.app.service;

import static com.carrernet.app.constants.EmailConstants.CC_EMAIL;
import static com.carrernet.app.constants.EmailConstants.DEFAULT_PORT;
import static com.carrernet.app.constants.EmailConstants.EMAIL_SUBJECT;
import static com.carrernet.app.constants.EmailConstants.FROM_EMAIL;
import static com.carrernet.app.constants.EmailConstants.GMAIL_SMTP_SERVER;
import static com.carrernet.app.constants.EmailConstants.PASSWORD;
import static com.carrernet.app.constants.EmailConstants.SIMPLE_MAIL_TRANSFER_PROTOCOL;
import static com.carrernet.app.constants.EmailConstants.SMTP_AUTH;
import static com.carrernet.app.constants.EmailConstants.SMTP_HOST;
import static com.carrernet.app.constants.EmailConstants.SMTP_PORT;
import static com.carrernet.app.constants.EmailConstants.SMTP_STARTTLS_ENABLE;
import static com.carrernet.app.constants.EmailConstants.SMTP_STARTTLS_REQUIRED;
import static com.carrernet.app.constants.EmailConstants.USERNAME;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.sun.mail.smtp.SMTPTransport;

@Service
public class EmailService {

	public void sendEmail(String firstName, String toEmailAddress,String whatMessage) {

		try {
			Message message = createMessage(firstName, toEmailAddress,whatMessage);

			SMTPTransport transport = (SMTPTransport) getEmailSession().getTransport(SIMPLE_MAIL_TRANSFER_PROTOCOL);

			transport.connect(GMAIL_SMTP_SERVER, USERNAME, PASSWORD);

			transport.sendMessage(message, message.getAllRecipients());

			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	public Message createMessage(String userName, String email,String whatMessage) throws MessagingException {

		Message message = new MimeMessage(getEmailSession());
		message.setSubject(EMAIL_SUBJECT);
		message.setFrom(new InternetAddress(FROM_EMAIL));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
		message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(CC_EMAIL, false));

		message.setText(whatMessage);
		message.setSentDate(new Date());
		message.saveChanges();
		return message;

	}

	public Session getEmailSession() {

		Properties props = System.getProperties();

		props.put(SMTP_HOST, GMAIL_SMTP_SERVER);
		props.put(SMTP_AUTH, true);
		props.put(SMTP_PORT, DEFAULT_PORT);

		props.put(SMTP_STARTTLS_ENABLE, true);
		props.put(SMTP_STARTTLS_REQUIRED, true);
		return Session.getInstance(props, null);
	}

}
