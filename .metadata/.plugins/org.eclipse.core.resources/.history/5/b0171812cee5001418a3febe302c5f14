package util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	/*
	private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
        	Configuration configuration = new Configuration();
        	configuration.configure("hibernate.cfg.xml");
            System.out.println("Kelve --> Hibernate Configuration loaded");
             
            ServiceRegistry serviceRegistry = 
            		new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            
            System.out.println("Kelve --> Hibernate serviceRegistry created");
             
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
             
            return sessionFactory;
            
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Kelve --> Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }*/
	
	// Novo coidigo no lugar do de cima
	private static final SessionFactory sessionFactory;
	
	static {
		try {
			// configura
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			
			// Registra
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
			
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static Session getSession() {
		return sessionFactory.openSession();
	}
    
    // Pega atributo da sessao que é passado pelo filtro
    public static Object getRequestAttribute(String name) {
    	FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		
		return request.getAttribute(name);
    }
}	
