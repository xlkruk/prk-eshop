package pl.edu.pw.ii.eshop.dao;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.Order;

/**
 * Interfejs dostępu do obiektu {@link Order} DAO
 * 
 * @author Łukasz Kruk
 *
 */
public interface OrderDao {

	/**
	 * Metoda utrwalająca nowe zamówienie {@link Order}
	 * 
	 * @param order
	 *            zamówienie
	 * @return id wykreowanego zamówienia
	 */
	int addOrder(Order order);

	/**
	 * Metoda zwracająca wszystkie zamówienia
	 * 
	 * @return lista wszystkich zamówień {@link Order}
	 */
	List<Order> getAllOrders();

	/**
	 * Metoda zwracająca zamówienie po zadanym statusie
	 * 
	 * @param status
	 *            status zamówienia
	 * @return lista zamówień {@link Order}
	 */
	List<Order> getOrdersByStatus(String status);

	/**
	 * Metoda zwracająca wszystkie zamówienia złożone przez klienta o zadanym id
	 * 
	 * @param customerId
	 *            id klienta {@link Customer}
	 * @return lista zam�wie� {@link Order}
	 */
	List<Order> getOrdersByCustomerId(int customerId);

	/**
	 * Metoda utrwalająca zmodyfikowane zamówienie {@link Order}
	 * 
	 * @param order
	 *            zamówienie {@link Order}
	 */
	void updateOrder(Order order);

	/**
	 * Metoda zwracająca zamówienie Order o zadanym id
	 * 
	 * @param id
	 *            id zamówienia
	 * @return zamówienie {@link Order}
	 */
	Order getOrderById(int id);

}
