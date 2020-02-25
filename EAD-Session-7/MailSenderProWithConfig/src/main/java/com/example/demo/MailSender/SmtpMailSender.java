package com.example.demo.MailSender;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * SmtpMailSender class which implements MailSender Interface 
 * @author Bhavesh
 *
 */
public class SmtpMailSender implements MailSender
{

	@Override
	public void send() {
		System.out.println("SMTP MAIL SENT");
		
	}
	

}
