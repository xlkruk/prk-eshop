package pl.edu.pw.ii.eshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Klasa reprezentuj¹ca encjê ORDITEM, pozycje zamówienia.
 * 
 * @author Agnieszka Œwiderska
 *
 */
@Entity
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 4284021384759341954L;

	@Id
	@GeneratedValue
	private int orderItemId;

	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;

	private String productName;
	private int quantity;
	private double price;
	private double totalPrice;

	/**
	 * Konstruktor parametryczny. Przypisuje zamówienie {@link Order} do pozycji
	 * zamówienia. Inicjuje nazwê produktu, iloœæ cenê ca³kowit¹ za produky na
	 * pozycji zamówienia, cenê jednostkow¹ za produkt.
	 * 
	 * @param order
	 *            zamówienie, którego dotyczy pozycja zamówienia
	 * @param cartItem
	 *            linia agreguj¹ca koszyka skojarzona z pozycj¹ zamówienia.
	 */
	public OrderItem(Order order, CartItem cartItem) {
		this.order = order;
		this.productName = cartItem.getProduct().getName();
		this.quantity = cartItem.getQuantity();
		this.totalPrice = cartItem.getTotalPrice();
		this.price = cartItem.getProduct().getPrice();
	}

	/**
	 * Metaoda zwracaj¹ca cenê jednostkow¹ produktu na pozycji zamówienia.
	 * 
	 * @return cena jednostkow¹ produktu na pozycji zamówienia.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Metoda ustawiaj¹ca cenê jednostkow¹ produktu na pozycji zamówienia.
	 * 
	 * @param price
	 *            cena jednostkow¹ produktu na pozycji zamówienia.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Metoda zwracaj¹ca id pozycji zamówienia - klucz g³owny encji.
	 * 
	 * @return id pozycji zamówienia - klucz g³owny encji.
	 */
	public int getOrderItemId() {
		return orderItemId;
	}

	/**
	 * Metoda ustawiaj¹ca id pozycji zamówienia - klucz g³owny encji.
	 * 
	 * @param orderItemId
	 *            id pozycji zamówienia - klucz g³owny encji.
	 */
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	/**
	 * Metoda zwracaj¹ca zamówienie {@link Order}, którego dotyczy podana
	 * pozycja.
	 * 
	 * @return zamówienie {@link Order}, którego dotyczy podana pozycja.
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Metoda ustawiaj¹ca zamówienie {@link Order}, którego dotyczy podana
	 * pozycja.
	 * 
	 * @param order
	 *            zamówienie {@link Order}, którego dotyczy podana pozycja.
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * Metoda zwracaj¹ca nazwê produktu nale¿¹cego do pozycji zamówienia.
	 * 
	 * @return nazwa produktu nale¿¹cego do pozycji zamówienia.
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Metoda ustawiaj¹ca nazwê produktu nale¿¹cego do pozycji zamówienia.
	 * 
	 * @param productName
	 *            nazwê produktu nale¿¹cego do pozycji zamówienia.
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Metoda zwracaj¹ca iloœæ produktów {@link Product} na danej pozycj
	 * izamówienia
	 * 
	 * @return iloœæ produktów {@link Product} na danej pozycj izamówienia
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Metoda ustawiaj¹ca iloœæ produktów {@link Product} na danej pozycj
	 * izamówienia
	 * 
	 * @param quantity
	 *            iloœæ produktów {@link Product} na danej pozycj izamówienia
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Metoda zwracaj¹ca cenê ca³kowit¹ pozycji zamówienia
	 * 
	 * @return cena ca³kowit¹ pozycji zamówienia
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Metoda ustawiaj¹ca cenê ca³kowit¹ pozycji zamówienia
	 * 
	 * @param totalPrice
	 *            cena ca³kowit¹ pozycji zamówienia
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * Konstruktor bezparametryczny.
	 */
	public OrderItem() {
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", order=" + order + ", productName=" + productName
				+ ", quantity=" + quantity + ", price=" + price + ", totalPrice=" + totalPrice + "]";
	}

}
