package com.ashokit.mail;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailService {

	private static final MimeMessageHelper MULTIPART_SUBTYPE_MIXED = null;
	@Autowired
	private JavaMailSender mailsender;

	public boolean sendMail(String Subject, String body, String to) {
		boolean isSent = false;
		try {
			MimeMessage message = mailsender.createMimeMessage();
			// create MimeMessageHelper class object
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setSubject(Subject);
			helper.setText(body);
			helper.setTo(to);
			// use javaMailSender
			mailsender.send(message);
			isSent = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSent = false;
		}
		return isSent;
	}
}
