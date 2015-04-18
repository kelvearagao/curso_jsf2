package test;

import org.hibernate.Session;

import pojo.Movie;
import util.HibernateUtil;

public class Teste {
	public static void main(String[] args)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Movie movie = new Movie();
		movie.setTitle("Naconda 2");
		movie.setSynopsis("Uma cobra que come muitas pessoas");
		movie.setDirector("Desconhecida");
		session.save(movie);
		
		session.getTransaction().commit();
		
		HibernateUtil.getSessionFactory().close();
	}
}
