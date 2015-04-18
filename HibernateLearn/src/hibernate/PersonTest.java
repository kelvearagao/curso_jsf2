package hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonTest {
	SessionFactory factory;
	
	@BeforeMethod
	public void setup() {
		Configuration configuration = new Configuration();
		configuration.configure();
		
		ServiceRegistryBuilder srBuilder = new ServiceRegistryBuilder();
		srBuilder.applySettings(configuration.getProperties());
		
		ServiceRegistry serviceRegistry = srBuilder.buildServiceRegistry();
		factory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	@AfterMethod
	public void shutdown() {
		factory.close();
	}
	
	@Test
	public void testSavePerson() {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		String name = "Kelve Aragão";
		savePerson(session, name);
		
		tx.commit();
		session.close();
	}
	
	private Person findPerson(Session session, String name) {
		Query query = session.createQuery("from Person p where p.name=:name");
		query.setParameter("name", name);
		Person person = (Person) query.uniqueResult();
		
		return person;
	}
	
	private Person savePerson(Session session, String name) {
		Person person = findPerson(session, name);
		
		if(person == null) {
			person = new Person();
			person.setName(name);
			
			session.save(person);
		}
		
		return person;
	}
}
