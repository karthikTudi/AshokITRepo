package com.ashokit.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailService {

	@Autowired
	private JavaMailSender mailsender;

	public boolean sendMail(String Subject, String body, String to) {
		boolean isSent = false;
		try {
			// create simple msg class object
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setSubject(Subject);
			msg.setText(body);
			msg.setTo(to);
			// use javaMailSender
			mailsender.send(msg);
			 isSent=true;
		} catch (Exception e) {
			e.printStackTrace();
			 isSent=false;
		}
		return isSent;
	}
}
