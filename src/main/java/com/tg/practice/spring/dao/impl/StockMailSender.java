package com.tg.practice.spring.dao.impl;

import java.util.Properties;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class StockMailSender {
	
	private JavaMailSenderImpl mailSender;
	
	public MailSender getMailSender() {
		return mailSender;
	}
	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}
	
	public void enviarMsg(String from, String password, String to, String texto) {
		
		mailSender.setHost("smtp.mailtrap.io");
		mailSender.setPort(465);
		
		mailSender.setUsername(from);
		mailSender.setPassword(password);
		
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.smtp.auth", "true");
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom(from);
		message.setTo(to);
		message.setText(texto);
		
		try {
			this.mailSender.send(message);
		}
		
		catch(MailException ex){
			System.out.println("Error envio");
		}
	}

}
