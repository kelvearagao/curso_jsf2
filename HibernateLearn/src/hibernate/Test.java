package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.Assert;

import util.SessionUtil;

public class Test {
	@org.testng.annotations.Test
	public void TestProperSimpleInversionCode() {
		Long emailId;
		Long messageId;
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Email email = new Email("Kelve");
		Message message = new Message("Gostoso");
		
		//email.setMessage(message);
		message.setEmail(email);
		
		session.save(email);
		session.save(message);
		
		
		emailId = email.getId();
		messageId = message.getId();
		
		tx.commit();
		session.close();
		
		Assert.assertNull(email.getMessage());
	//	System.out.println(">> " + email.getMessage().content);
		Assert.assertNotNull(message.getEmail());
		
		// Nova sessao
		session = SessionUtil.getSession();
		tx = session.beginTransaction();
		
		email = (Email) session.get(Email.class, emailId);
		
		message = (Message) session.get(Message.class, messageId);
		
		tx.commit();
		session.close();
		
		Assert.assertNotNull(email.getMessage());
		Assert.assertNotNull(message.getEmail());
		System.out.println(email.getMessage().content);
		System.out.println(message.getEmail().subject);
		
	}
}
