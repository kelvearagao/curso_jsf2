package teste;

import java.util.List;

import model.Order;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import util.HibernateUtil;

public class Teste {
	
	public static void main(String args[]) {
		/*
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria crit = session.createCriteria(Order.class);
		List<Order> orders = crit.list();
		
		for (Order order : orders) {
			System.out.println("Id " + order.getId());
		}
		
		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();*/
		
		Gson gson = new Gson();
		String json = "{\"sun\":false,\"mon\":false,\"tue\":false,\"wed\":false,\"thu\":false,\"fri\":false,\"sat\":false}";
		Days days = gson.fromJson(json, Days.class);
	}
}