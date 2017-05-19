package pl.edu.pw.ii.eshop.dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pw.ii.eshop.dao.OrderDao;
import pl.edu.pw.ii.eshop.model.Order;
import pl.edu.pw.ii.eshop.model.Product;


@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addOrder(Order customerOrder) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customerOrder);
		session.flush();
	}

	@Override
	public List<Order> getAllOrders() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ORDERS");
		List<Order> orders = query.list();
		session.flush();
		return orders;
	}

	@Override
	public List<Order> getOrdersByStatus(String status) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ORDERS where status=?");
		query.setString(0, status);
		List<Order> orders = query.list();
		session.flush();
		return orders;
	}

	@Override
	public List<Order> getOrdersByCustomerId(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ORDERS where customerId=?");
		query.setInteger(0, customerId);
		List<Order> orders = query.list();
		session.flush();
		return orders;
	}

	@Override
	public void updateOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(order);
		session.flush();

	}

	@Override
	public Order getOrderById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Order order = (Order) session.get(Order.class, id);
		session.flush();
		return order;
	}

}
