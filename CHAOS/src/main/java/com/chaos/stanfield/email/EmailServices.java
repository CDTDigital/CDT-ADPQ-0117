package com.chaos.stanfield.email;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




import javax.mail.Authenticator;

import javax.mail.PasswordAuthentication;

import javax.mail.internet.AddressException;


public class EmailServices {
	public static boolean sendMail(String message, String to[]) {
		String from="XXXXXXXXX@gmail.com";
		String password="XXXXXXXXX";
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		  // Get a Properties object
		     Properties props = System.getProperties();
		     props.setProperty("mail.smtp.host", "smtp.gmail.com");
		     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		     props.setProperty("mail.smtp.socketFactory.fallback", "false");
		     props.setProperty("mail.smtp.port", "465");
		     props.setProperty("mail.smtp.socketFactory.port", "465");
		     props.put("mail.smtp.auth", "true");
		     props.put("mail.debug", "true");
		     props.put("mail.store.protocol", "pop3");
		     props.put("mail.transport.protocol", "smtp");
		     final String username = from;
		     final String password1 = password;
		     try{
		     Session session = Session.getDefaultInstance(props, 
		                          new Authenticator(){
		                             protected PasswordAuthentication getPasswordAuthentication() {
		                                return new PasswordAuthentication(username, password1);
		                             }});

		   // -- Create a new message --
		     Message msg = new MimeMessage(session);

		  // -- Set the FROM and TO fields --
		  //   InternetAddress[] toAddress = new InternetAddress[to.length];
		     msg.setFrom(new InternetAddress("patel.201192@gmail.com"));
		     msg.setRecipients(Message.RecipientType.TO, 
		                      InternetAddress.parse(to[0],false));
		     msg.setSubject("EveryEvent");
		     msg.setContent(message, "text/html; charset=utf-8");
		     msg.setSentDate(new Date());
		     Transport.send(msg);
		     System.out.println("Message sent.");
		     return true;
		  }catch (MessagingException e){ System.out.println("Erreur d'envoi, cause: " + e);
		  		return false;
		  }
		     
	}
}
