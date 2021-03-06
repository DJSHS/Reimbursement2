package com.revature.email;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.stereotype.Component;

import net.bytebuddy.asm.Advice.This;

@Component
public class Email {

	private String emplAuth = "defaultPass";
	private String emplName = "defaultName";
	private String userString = System.getenv("gmail_username");
	private String passString = System.getenv("gmail_password");
	private String sendToString = System.getenv("gmail_send_to");
	
	public Email() {
		super();
	}
	
	public Email(String emplAuth) {
		this.emplAuth = emplAuth;
	}
	
	public void sendEmail() {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getInstance(prop,
        		new javax.mail.Authenticator() {
            	protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userString, passString);
            }
        });

        try {
        	MimeMessage message = new MimeMessage(session);  
            message.setFrom(new InternetAddress(userString)); 
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendToString));
            message.setSubject("Reimbursement");  
            message.setText("Hi " + emplName + ". Welcome to Revature. Your Password Is " + emplAuth + ". You can login to \"localhost:4200/login\" with your email now.");  

            Transport.send(message);  

            System.out.println("message sent successfully...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getEmplAuth() {
		return emplAuth;
	}

	public void setEmplAuth(String emplAuth) {
		this.emplAuth = emplAuth;
	}

	public String getUserString() {
		return userString;
	}

	public void setUserString(String userString) {
		this.userString = userString;
	}

	public String getPassString() {
		return passString;
	}

	public void setPassString(String passString) {
		this.passString = passString;
	}

	public String getSendToString() {
		return sendToString;
	}

	public void setSendToString(String sendToString) {
		this.sendToString = sendToString;
	}

	public String getEmplName() {
		return emplName;
	}

	public void setEmplName(String emplName) {
		this.emplName = emplName;
	}
	
}