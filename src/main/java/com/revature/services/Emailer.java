package com.revature.services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import com.revature.models.User;


public class Emailer implements Runnable{
	private HttpServletRequest req;
	final String sender = "axel.foley2017@gmail.com";
	final String password = "revature2017";
	
	public Emailer(HttpServletRequest req){
		this.req = req;
	}
	
	@Override
	public void run() {
		User u = (User)(req.getSession().getAttribute("user"));
		String receiver = u.getU_email();
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, password);
			}
		  });

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(receiver));
			message.setSubject("Welcome to School, " + u.getU_fname() + " " + u.getU_lname());
			message.setText("Welcome to School, " + u.getU_fname() + " " + u.getU_lname() + "!\n" 
						  + "You've registered with the following information: \n"
						  + "Email: " + u.getU_email() + "\n"
				  		  + "Name: " + u.getU_fname() + " " + u.getU_lname() + "\n"
		  		  		  + "Username: " + u.getU_username() + "\n"
  		  		  		  + "Password: " + u.getU_password());

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
