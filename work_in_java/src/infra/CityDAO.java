package infra;

import java.util.ArrayList;
import java.util.List;

import model.City;

import org.hibernate.Session;

import util.HibernateUtil;

public class CityDAO {
	private List<City> cities = new ArrayList<City>();
	
	@SuppressWarnings("unchecked")
	public List<City> getCities() {		
		Session session = (Session) HibernateUtil.getRequestAttribute("session");
		
		this.cities = session.createQuery("from City").list();
		System.out.println("Fazendo a consulta!");
		
		return this.cities;
	}
}
