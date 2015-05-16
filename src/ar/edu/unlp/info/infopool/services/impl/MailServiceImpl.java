package ar.edu.unlp.info.infopool.services.impl;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import ar.edu.unlp.info.infopool.services.MailService;

public class MailServiceImpl implements MailService {
		private MailSender mailSender;
		private SimpleMailMessage simpleMailMessage;
		
		public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
			this.simpleMailMessage = simpleMailMessage;
		}

		public void setMailSender(MailSender mailSender) {
			this.mailSender = mailSender;
		}
		
		public void sendMail(String from, String to, String subject, String msg) {
			 
			SimpleMailMessage message = new SimpleMailMessage();
	 
			message.setFrom(from);
			message.setTo(to);
			message.setSubject(subject);
			message.setText(msg);
			mailSender.send(message);	
		}
		
		
	}
