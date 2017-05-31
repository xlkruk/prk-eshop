package pl.edu.pw.ii.eshop.dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pw.ii.eshop.dao.CustomerDao;
import pl.edu.pw.ii.eshop.model.Authorities;
import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.model.Users;

/**
 * Klasa implementuj¹ca interfejs {@link CustomerDao}
 * 
 * @author Krzysztof Trybus
 *
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCustomer(Customer customer) {
		// pobranie obiektu Session
		Session session = sessionFactory.getCurrentSession();
		// przypisanie klienta do odresów dostawy i do faktury
		customer.getBillingAddress().setCustomer(customer);
		customer.getShippingAddress().setCustomer(customer);
		// utrwalenie zmian
		session.saveOrUpdate(customer);
		session.saveOrUpdate(customer.getBillingAddress());
		session.saveOrUpdate(customer.getShippingAddress());

		// utworzenie nowego u¿ytkownika oraz ustawienie atrybutów
		Users user = new Users();
		user.setUsername(customer.getUsername());
		user.setPassword(customer.getPassword());
		user.setEnabled(true);
		user.setCustomerId(customer.getCustomerId());

		// Utworzenie nowego wpisu z rolami oraz ustawienie z roli u¿ytkownika
		Authorities authority = new Authorities();
		authority.setUsername(customer.getUsername());
		authority.setAuthority("ROLE_USER");

		// utrwalenie u¿ytkownika oraz jego roli
		session.saveOrUpdate(user);
		session.saveOrUpdate(authority);

		// utworzenie koszyka klienta
		Cart cart = new Cart();
		// przypisanie klienta do koszyka - relacja 1 do 1
		cart.setCustomer(customer);
		// przypisanie koszyka do klienta - relacja 1 do 1
		customer.setCart(cart);
		// utrwalenie zmian
		session.saveOrUpdate(customer);
		session.saveOrUpdate(cart);

		session.flush();
	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Customer) session.get(Customer.class, id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// pobranie obiektu Session
		Session session = sessionFactory.getCurrentSession();
		// utworzenie zapytania
		Query query = session.createQuery("from Customer");
		// pobranie listy klientów
		List<Customer> customers = query.list();
		return customers;
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		// utworzenie zapytania o klienta o zadanym username
		Query query = session.createQuery("from Customer where username=?");
		// ustawienie parametru zapytania
		query.setString(0, username);

		return (Customer) query.uniqueResult();
	}

	@Override
	public void editCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		//utrwalenie zmodyfikowanego klienta oraz jego adresów dostawy i do faktury
		session.saveOrUpdate(customer);
		session.saveOrUpdate(customer.getBillingAddress());
		session.saveOrUpdate(customer.getShippingAddress());
		session.flush();

	}

}
