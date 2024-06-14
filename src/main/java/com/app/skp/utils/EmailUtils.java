package com.app.skp.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;
@Component
public class EmailUtils {
	@Value("${spring.mail.username}") 
	private String sender;
	@Autowired
	private JavaMailSender mailSender;
	public boolean sendEmail(String to, String subject ,String body){
	boolean isSent=false;
	try{
	MimeMessage mimeMsg=mailSender.createMimeMessage();
	MimeMessageHelper helper=new MimeMessageHelper(mimeMsg);
	helper.setFrom(sender);
	helper.setTo(to);
	helper.setSubject(subject);
	helper.setText(body,true);
	mailSender.send(mimeMsg);
	isSent=true;
	}
	catch(Exception ex){
	ex.printStackTrace();
	}
	return isSent;
	}
}