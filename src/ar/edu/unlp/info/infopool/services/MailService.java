package ar.edu.unlp.info.infopool.services;


import org.springframework.mail.SimpleMailMessage;


public interface MailService {
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage);
	public void sendMail(String from, String to, String subject, String msg);
}
