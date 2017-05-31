package pl.edu.pw.ii.eshop.service;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.Order;

/**
 * Interfejs warstwy serwisu, definiuj¹cy metody zwi¹zane z logik¹ biznesow¹
 * zwi¹zan¹ z obs³ug¹ zamówienia
 * 
 * @author £ukasz Kruk
 *
 */

public interface OrderService {

	/**
	 * Metoda utrwalaj¹ca nowe zamówienie {@link Order}
	 * 
	 * @param order
	 *            zamówienie
	 */
	void addOrder(Order customerOrder);

	/**
	 * Metoda zwracaj¹ca cenê ca³kowit¹ koszyka
	 * 
	 * @param cartId
	 *            id koszyka klienta
	 * @return cena ca³kowita
	 */
	double getOrderGrandTotal(int cartId);

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
	 * Metoda ustawiaj¹cy status zamówienia na PAYMENT_RECEIVED
	 * 
	 * @param customerOrder
	 *            zamówienie klienta
	 */
	void setPaymentReceivedStatus(Order customerOrder);

	/**
	 * Metoda ustawiaj¹cy status zamówienia na SENT
	 * 
	 * @param customerOrder
	 *            zamówienie klienta
	 */
	void setSentStatus(Order customerOrder);

	/**
	 * Metoda ustawiaj¹cy status zamówienia na COMPLETED
	 * 
	 * @param customerOrder
	 *            zamówienie klienta
	 */
	void setCompletedStaus(Order customerOrder);

	/**
	 * Metoda ustawiaj¹cy status zamówienia na NEW
	 * 
	 * @param customerOrder
	 *            zamówienie klienta
	 */
	void setNewStaus(Order customerOrder);

	/**
	 * Metoda zwracaj¹ca zamówienie Order o zadanym id
	 * 
	 * @param id
	 *            id zamówienia
	 * @return zamówienie {@link Order}
	 */
	Order getOrderById(int id);
}
