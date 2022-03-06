package com.example.spring.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public void sendmail(String email, int id) throws MessagingException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp-relay.sendinblue.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("topilama23@gmail.com", "HyU4KapN78PsgzMn");
			}
		});

		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("rux12@icloud.com", false));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		msg.setSubject("Verify your email");
		msg.setContent("Verify your email: http://localhost:8080/api/student/verify/%s".formatted(id), "text/html");
		msg.setSentDate(new Date());

		Transport.send(msg);
	}

}
