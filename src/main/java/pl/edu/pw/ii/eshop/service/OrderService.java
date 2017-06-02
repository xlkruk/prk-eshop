package pl.edu.pw.ii.eshop.service;

import java.util.List;

import pl.edu.pw.ii.eshop.model.BillingAddress;
import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.Order;

/**
 * Interfejs warstwy serwisu, definiujący metody związane z logiką biznesową
 * związaną z obsługą zamówienia
 * 
 * @author ąukasz Kruk
 *
 */

public interface OrderService {

	/**
	 * Metoda utrwalająca nowe zamówienie {@link Order}
	 * 
	 * @param order
	 *            zamówienie
	 * @return id utworzonego zamówienia
	 */
	int addOrder(Order order);

	/**
	 * Metoda zwracająca cenę całkowitą koszyka
	 * 
	 * @param cartId
	 *            id koszyka klienta
	 * @return cena całkowita
	 */
	double getOrderGrandTotal(int cartId);

	/**
	 * Metoda zwracająca wszytkie zamówienia
	 * 
	 * @return lista wszystkich zamówień {@link Order}
	 */
	List<Order> getAllOrders();

	/**
	 * Metoda zwracająca zamówienie o zadanym statusie
	 * 
	 * @param status
	 *            status zamówienia.
	 * @return lista zamówień {@link Order}
	 */
	List<Order> getOrdersByStatus(String status);

	/**
	 * Metoda zwracająca wszytskie zamówienia złożone przez klienta o zadanym id
	 * 
	 * @param customerId
	 *            id klienta {@link Customer}
	 * @return lista zamówień {@link Order}
	 */
	List<Order> getOrdersByCustomerId(int customerId);

	/**
	 * Metoda ustawiający status zamówienia na PAYMENT_RECEIVED
	 * 
	 * @param customerOrder
	 *            zamówienie klienta
	 */
	void setPaymentReceivedStatus(Order customerOrder);

	/**
	 * Metoda ustawiający status zamówienia na SENT
	 * 
	 * @param customerOrder
	 *            zamówienie klienta
	 */
	void setSentStatus(Order customerOrder);

	/**
	 * Metoda ustawiający status zamówienia na COMPLETED
	 * 
	 * @param customerOrder
	 *            zamówienie klienta
	 */
	void setCompletedStaus(Order customerOrder);

	/**
	 * Metoda ustawiający status zamówienia na NEW
	 * 
	 * @param customerOrder
	 *            zamówienie klienta
	 */
	void setNewStaus(Order customerOrder);

	/**
	 * Metoda zwracająca zamówienie Order o zadanym id
	 * 
	 * @param id
	 *            id zamówienia
	 * @return zamówienie {@link Order}
	 */
	Order getOrderById(int id);

	/**
	 * Metoda aktualizująca adres do faktury
	 * 
	 * @param order
	 *            zamówienie klienta
	 */
	void updateBillingAddress(Order order);

	/**
	 * Metoda aktualizująca adres do faktury
	 * 
	 * @param order
	 *            zamówienie klienta.
	 */
	void updateShippingAddress(Order order);

}
