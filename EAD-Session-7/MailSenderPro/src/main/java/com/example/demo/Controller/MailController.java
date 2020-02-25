package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MailSender.MailSender;

/**
 * Controller for Mail Sender
 * @author Bhavesh
 * 
 */
@RestController
public class MailController 
{
	
	private MailSender sender;
	
	/**
	 * Setter type dependency
	 * @param sender : instance of interface MailSender
	 * Dependency by qualifiers
	 */
	/*
	@Autowired
	@Qualifier("smtp")
	public void setSender(MailSender sender) {
		this.sender = sender;
	}
	*/
	
	/**
	 * Constructor type dependency 
	 * @param sender : instance of interface MailSender
	 * ALso the Autowired annotation is used as a dependency by name
	 */
	@Autowired
	public MailController( MailSender sender)
	{
		this.sender = sender;
	}
	
	/**
	 * 
	 * @return : String type message
	 */
	@GetMapping("/")
	public String test()
	{
		sender.send();
		return "success";
		
	}

}
