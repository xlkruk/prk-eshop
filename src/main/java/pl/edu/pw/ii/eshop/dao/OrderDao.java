package pl.edu.pw.ii.eshop.dao;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.Order;

/**
 * Interfejs dost�pu do obiektu {@link Order} DAO
 * 
 * @author Krzysztof Trybus
 *
 */
public interface OrderDao {

	/**
	 * Metoda utrwalaj�ca nowe zam�wienie {@link Order}
	 * 
	 * @param order
	 *            zam�wienie
	 */
	void addOrder(Order order);

	/**
	 * Metoda zwracaj�ca wszytkie zam�wienia
	 * 
	 * @return lista wszystkich zam�wie� {@link Order}
	 */
	List<Order> getAllOrders();

	/**
	 * Metoda zwracaj�ca zam�wienie po zadanym statusie
	 * 
	 * @param status
	 * @return lista zam�wie� {@link Order}
	 */
	List<Order> getOrdersByStatus(String status);

	/**
	 * Metoda zwracaj�ca wszytskie zam�wienia z�o�one przez klienta o zadanym id
	 * 
	 * @param customerId
	 *            id klienta {@link Customer}
	 * @return lista zam�wie� {@link Order}
	 */
	List<Order> getOrdersByCustomerId(int customerId);

	/**
	 * Metoda utrwalaj�ca zmodyfikowane zam�wienie {@link Order}
	 * 
	 * @param order
	 *            zam�wienie {@link Order}
	 */
	void updateOrder(Order order);

	/**
	 * Metoda zwracaj�ca zam�wienie Order o zadanym id
	 * 
	 * @param id
	 *            id zam�wienia
	 * @return zam�wienie {@link Order}
	 */
	Order getOrderById(int id);

}
