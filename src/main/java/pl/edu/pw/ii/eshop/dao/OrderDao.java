package pl.edu.pw.ii.eshop.dao;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.Order;

/**
 * Interfejs dostêpu do obiektu {@link Order} DAO
 * 
 * @author Krzysztof Trybus
 *
 */
public interface OrderDao {

	/**
	 * Metoda utrwalaj¹ca nowe zamówienie {@link Order}
	 * 
	 * @param order
	 *            zamówienie
	 */
	void addOrder(Order order);

	/**
	 * Metoda zwracaj¹ca wszytkie zamówienia
	 * 
	 * @return lista wszystkich zamówieñ {@link Order}
	 */
	List<Order> getAllOrders();

	/**
	 * Metoda zwracaj¹ca zamówienie po zadanym statusie
	 * 
	 * @param status
	 * @return lista zamówieñ {@link Order}
	 */
	List<Order> getOrdersByStatus(String status);

	/**
	 * Metoda zwracaj¹ca wszytskie zamówienia z³o¿one przez klienta o zadanym id
	 * 
	 * @param customerId
	 *            id klienta {@link Customer}
	 * @return lista zamówieñ {@link Order}
	 */
	List<Order> getOrdersByCustomerId(int customerId);

	/**
	 * Metoda utrwalaj¹ca zmodyfikowane zamówienie {@link Order}
	 * 
	 * @param order
	 *            zamówienie {@link Order}
	 */
	void updateOrder(Order order);

	/**
	 * Metoda zwracaj¹ca zamówienie Order o zadanym id
	 * 
	 * @param id
	 *            id zamówienia
	 * @return zamówienie {@link Order}
	 */
	Order getOrderById(int id);

}
