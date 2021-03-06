package infra;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;
import model.City;
import model.Type;

public class TypeDAO implements Serializable{
	List<Type> types = new ArrayList<Type>();
		
	@SuppressWarnings("unchecked")
	public List<Type> getTypes() {
		Session session = (Session) HibernateUtil.getRequestAttribute("session");
		
		this.types = session.createQuery("from Type").list();
		System.out.println("Fazendo a consulta!");
		
		return this.types;
	}
}
