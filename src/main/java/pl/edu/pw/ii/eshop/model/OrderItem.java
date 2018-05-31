package pl.edu.pw.ii.eshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Klasa reprezentująca encją ORDITEM, pozycje zamówienia.
 * 
 * @author Łukasz Kruk
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
	 * zamówienia. Inicjuje nazwę produktu, ilość, cenę całkowitą za produky na
	 * pozycji zamówienia, cenę jednostkową za produkt.
	 * 
	 * @param order
	 *            zamówienie, którego dotyczy pozycja zamówienia
	 * @param cartItem
	 *            linia agregująca koszyka skojarzona z pozycją zamówienia.
	 */
	public OrderItem(Order order, CartItem cartItem) {
		this.order = order;
		this.productName = cartItem.getProduct().getName();
		this.quantity = cartItem.getQuantity();
		this.totalPrice = cartItem.getTotalPrice();
		this.price = cartItem.getProduct().getPrice();
	}

	/**
	 * Metaoda zwracająca cenę jednostkową produktu na pozycji zamówienia.
	 * 
	 * @return cena jednostkową produktu na pozycji zamówienia.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Metoda ustawiająca cenę jednostkową produktu na pozycji zamówienia.
	 * 
	 * @param price
	 *            cena jednostkową produktu na pozycji zamówienia.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Metoda zwracająca id pozycji zamówienia - klucz główny encji.
	 * 
	 * @return id pozycji zamówienia - klucz główny encji.
	 */
	public int getOrderItemId() {
		return orderItemId;
	}

	/**
	 * Metoda ustawiająca id pozycji zamówienia - klucz główny encji.
	 * 
	 * @param orderItemId
	 *            id pozycji zamówienia - klucz główny encji.
	 */
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	/**
	 * Metoda zwracająca zamówienie {@link Order}, którego dotyczy podana
	 * pozycja.
	 * 
	 * @return zamówienie {@link Order}, którego dotyczy podana pozycja.
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Metoda ustawiająca zamówienie {@link Order}, którego dotyczy podana
	 * pozycja.
	 * 
	 * @param order
	 *            zamówienie {@link Order}, którego dotyczy podana pozycja.
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * Metoda zwracająca nazwę produktu należącego do pozycji zamówienia.
	 * 
	 * @return nazwa produktu należącego do pozycji zamówienia.
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Metoda ustawiająca nazwę produktu należącego do pozycji zamówienia.
	 * 
	 * @param productName
	 *            nazwę produktu należącego do pozycji zamówienia.
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Metoda zwracająca ilość produktów {@link Product} na danej pozycji zamówienia
	 * 
	 * @return ilość produktów {@link Product} na danej pozycji zamówienia
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Metoda ustawiająca ilość produktów {@link Product} na danej pozycji zamówienia
	 * 
	 * @param quantity
	 *            ilość produktów {@link Product} na danej pozycji zamówienia
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Metoda zwracająca cenę całkowitą pozycji zamówienia
	 * 
	 * @return cena całkowitą pozycji zamówienia
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Metoda ustawiająca cenę całkowitą pozycji zamówienia
	 * 
	 * @param totalPrice
	 *            cena całkowitą pozycji zamówienia
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
