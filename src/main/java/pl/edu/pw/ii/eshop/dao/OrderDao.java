package pl.edu.pw.ii.eshop.dao;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Order;

public interface OrderDao {
	void addOrder(Order order);

	List<Order> getAllOrders();

	List<Order> getOrdersByStatus(String status);

	List<Order> getOrdersByCustomerId(int customerId);
	
	void updateOrder(Order order);

}
