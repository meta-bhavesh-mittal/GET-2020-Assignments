package com.example.demo.MailSender;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * MockMailSender class which implements MailSender Interface 
 * @author Bhavesh
 *
 */
public class MockMailSender implements MailSender {

	@Override
	public void send() {
		System.out.println("MOCK MAIL SENT");

	}

}
