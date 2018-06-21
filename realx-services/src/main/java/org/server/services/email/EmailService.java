package org.server.services.email;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSenderImpl javaMailSender;

	@Async
	public void sendEmail(List<String> to, List<String> cc, String subject, String content, boolean isHtml)
			throws MessagingException {
		MimeMessage message = getJavaMailSender().createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		for (String to2 : to) {
			helper.addTo(to2);
		}
		if (cc != null && !cc.isEmpty()) {
			for (String cc2 : cc) {
				helper.addCc(cc2);
			}
		}
		helper.setText(content, isHtml);
		helper.setSubject(subject);
		getJavaMailSender().send(message);
	}

	@Async
	public void sendEmail(String to, String cc, String subject, String content, boolean isHtml)
			throws MessagingException {
		List<String> to2 = new ArrayList<>();
		to2.add(to);
		List<String> cc2 = new ArrayList<>();
		if (cc != null && !cc.isEmpty()) {
			cc2.add(cc);
		}
		sendEmail(to2, cc2, subject, content, isHtml);
	}

	public JavaMailSenderImpl getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
}
