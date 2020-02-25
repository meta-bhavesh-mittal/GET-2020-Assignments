package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.MailSender.MockMailSender;
import com.example.demo.MailSender.SmtpMailSender;

/**
 * 
 * @author Bhavesh
 * Java Config Class
 */
@Configuration
public class AppConfig {
	
	@Bean("smtpmail")
	public SmtpMailSender smtpMailSender() {
		return new SmtpMailSender();
	}
	
	@Bean("mockmail")
	public MockMailSender mockMailSender() {
		return new MockMailSender();
	}

}
