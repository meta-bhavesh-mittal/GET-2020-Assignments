package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MailSender.MailSender;

/**
 * Controller for MailSender
 * @author Bhavesh
 *
 */
@RestController
public class MailController 
{
	
	private MailSender sender;
	
	/**
	 * Setter dependency
	 * @param smtpmail : bean name which set in config class for MailSender Interface
	 */
	@Autowired
	public void setSender(MailSender smtpmail) {
		this.sender = smtpmail;
	}
	
	/**
	 * Constructor dependency
	 * @param mockmail : bean name which set in config class for MailSender Interface
	 */
	/*
	@Autowired
	public MailController(MailSender mockmail)
	{
		this.sender = mockmail;
	}
	*/
	
	@GetMapping("/")
	public String test()
	{
		sender.send();
		return "success";
		
	}

}
