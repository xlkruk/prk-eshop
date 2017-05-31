package pl.edu.pw.ii.eshop.service;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.Order;

/**
 * Interfejs warstwy serwisu, definiuj�cy metody zwi�zane z logik� biznesow�
 * zwi�zan� z obs�ug� zam�wienia
 * 
 * @author �ukasz Kruk
 *
 */

public interface OrderService {

	/**
	 * Metoda utrwalaj�ca nowe zam�wienie {@link Order}
	 * 
	 * @param order
	 *            zam�wienie
	 */
	void addOrder(Order customerOrder);

	/**
	 * Metoda zwracaj�ca cen� ca�kowit� koszyka
	 * 
	 * @param cartId
	 *            id koszyka klienta
	 * @return cena ca�kowita
	 */
	double getOrderGrandTotal(int cartId);

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
	 * Metoda ustawiaj�cy status zam�wienia na PAYMENT_RECEIVED
	 * 
	 * @param customerOrder
	 *            zam�wienie klienta
	 */
	void setPaymentReceivedStatus(Order customerOrder);

	/**
	 * Metoda ustawiaj�cy status zam�wienia na SENT
	 * 
	 * @param customerOrder
	 *            zam�wienie klienta
	 */
	void setSentStatus(Order customerOrder);

	/**
	 * Metoda ustawiaj�cy status zam�wienia na COMPLETED
	 * 
	 * @param customerOrder
	 *            zam�wienie klienta
	 */
	void setCompletedStaus(Order customerOrder);

	/**
	 * Metoda ustawiaj�cy status zam�wienia na NEW
	 * 
	 * @param customerOrder
	 *            zam�wienie klienta
	 */
	void setNewStaus(Order customerOrder);

	/**
	 * Metoda zwracaj�ca zam�wienie Order o zadanym id
	 * 
	 * @param id
	 *            id zam�wienia
	 * @return zam�wienie {@link Order}
	 */
	Order getOrderById(int id);
}
