package pl.edu.pw.ii.eshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Klasa reprezentuj�ca encj� ORDITEM, pozycje zam�wienia.
 * 
 * @author Agnieszka �widerska
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
	 * Konstruktor parametryczny. Przypisuje zam�wienie {@link Order} do pozycji
	 * zam�wienia. Inicjuje nazw� produktu, ilo�� cen� ca�kowit� za produky na
	 * pozycji zam�wienia, cen� jednostkow� za produkt.
	 * 
	 * @param order
	 *            zam�wienie, kt�rego dotyczy pozycja zam�wienia
	 * @param cartItem
	 *            linia agreguj�ca koszyka skojarzona z pozycj� zam�wienia.
	 */
	public OrderItem(Order order, CartItem cartItem) {
		this.order = order;
		this.productName = cartItem.getProduct().getName();
		this.quantity = cartItem.getQuantity();
		this.totalPrice = cartItem.getTotalPrice();
		this.price = cartItem.getProduct().getPrice();
	}

	/**
	 * Metaoda zwracaj�ca cen� jednostkow� produktu na pozycji zam�wienia.
	 * 
	 * @return cena jednostkow� produktu na pozycji zam�wienia.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Metoda ustawiaj�ca cen� jednostkow� produktu na pozycji zam�wienia.
	 * 
	 * @param price
	 *            cena jednostkow� produktu na pozycji zam�wienia.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Metoda zwracaj�ca id pozycji zam�wienia - klucz g�owny encji.
	 * 
	 * @return id pozycji zam�wienia - klucz g�owny encji.
	 */
	public int getOrderItemId() {
		return orderItemId;
	}

	/**
	 * Metoda ustawiaj�ca id pozycji zam�wienia - klucz g�owny encji.
	 * 
	 * @param orderItemId
	 *            id pozycji zam�wienia - klucz g�owny encji.
	 */
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	/**
	 * Metoda zwracaj�ca zam�wienie {@link Order}, kt�rego dotyczy podana
	 * pozycja.
	 * 
	 * @return zam�wienie {@link Order}, kt�rego dotyczy podana pozycja.
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Metoda ustawiaj�ca zam�wienie {@link Order}, kt�rego dotyczy podana
	 * pozycja.
	 * 
	 * @param order
	 *            zam�wienie {@link Order}, kt�rego dotyczy podana pozycja.
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * Metoda zwracaj�ca nazw� produktu nale��cego do pozycji zam�wienia.
	 * 
	 * @return nazwa produktu nale��cego do pozycji zam�wienia.
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Metoda ustawiaj�ca nazw� produktu nale��cego do pozycji zam�wienia.
	 * 
	 * @param productName
	 *            nazw� produktu nale��cego do pozycji zam�wienia.
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Metoda zwracaj�ca ilo�� produkt�w {@link Product} na danej pozycj
	 * izam�wienia
	 * 
	 * @return ilo�� produkt�w {@link Product} na danej pozycj izam�wienia
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Metoda ustawiaj�ca ilo�� produkt�w {@link Product} na danej pozycj
	 * izam�wienia
	 * 
	 * @param quantity
	 *            ilo�� produkt�w {@link Product} na danej pozycj izam�wienia
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Metoda zwracaj�ca cen� ca�kowit� pozycji zam�wienia
	 * 
	 * @return cena ca�kowit� pozycji zam�wienia
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Metoda ustawiaj�ca cen� ca�kowit� pozycji zam�wienia
	 * 
	 * @param totalPrice
	 *            cena ca�kowit� pozycji zam�wienia
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
