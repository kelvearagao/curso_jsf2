package controle;

import infra.OrderDAO;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Order;

@ManagedBean
@SessionScoped
public class OrderBean {
	public List<Order> orders = new ArrayList<Order>();
	private Order order;
	private OrderDAO orderDAO = new OrderDAO();

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getOrders() {
		return orderDAO.getOrders();
	}
	
	public List<Order> getTeste() {
		
		this.orders = orderDAO.getOrders();
		
		return orders;
	}
}
