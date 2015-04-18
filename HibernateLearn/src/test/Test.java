package test;

import hibernate.Email;
import hibernate.Message;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.SessionUtil;

public class Test {
	
	public static void main(String args[]){
		Long emailId;
		Long messageId;
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Email email = new Email("Kelve");
		Message message = new Message("Gostoso");
		
		email.setMessage(message);
		
		session.save(email);
		session.save(message);
		
		emailId = email.getId();
		messageId = message.getId();
	}
}
