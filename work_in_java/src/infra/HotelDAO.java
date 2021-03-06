package infra;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.Hotel;

import org.hibernate.Session;

import util.HibernateUtil;

public class HotelDAO implements Serializable{
private List<Hotel> hotels = new ArrayList<Hotel>();
	
	@SuppressWarnings("unchecked")
	public List<Hotel> getHotels() {		
		Session session = (Session) HibernateUtil.getRequestAttribute("session");
		
		//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//System.out.println("Pegando a sessão!");
		
		//Transaction transaction = session.beginTransaction();
		//System.out.println("Iniciando a transação!");
	
		this.hotels = session.createQuery("from Hotel").list();
		System.out.println("Fazendo a consulta!");
		
		//transaction.commit();
		//System.out.println("Comitando a transação!");
		
		return this.hotels;
	}
	
	public void addHotel(Hotel hotel) {
		Session session = (Session) HibernateUtil.getRequestAttribute("session");
		this.hotels = session.createQuery("from Hotel").list();
		System.out.println("Salvando hotel");
		session.save(hotel);
	}
}
