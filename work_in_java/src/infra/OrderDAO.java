package infra;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import model.Order;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class OrderDAO {
	private List<Order> pedidos = new ArrayList<Order>();
	
	@SuppressWarnings("unchecked")
	public List<Order> getOrders() {		
		Session session = (Session) HibernateUtil.getRequestAttribute("session");
		
		//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//System.out.println("Pegando a sessão!");
		
		//Transaction transaction = session.beginTransaction();
		//System.out.println("Iniciando a transação!");
	
		this.pedidos = session.createQuery("from Order").list();
		System.out.println("Fazendo a consulta!");
		
		//transaction.commit();
		//System.out.println("Comitando a transação!");
		
		return pedidos;
	}
}
