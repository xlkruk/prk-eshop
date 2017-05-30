package pl.edu.pw.ii.eshop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Klasa reprezentuj�ca encj� ORDERS, zam�wienie klienta
 * 
 * @author Agnieszka �widerska
 *
 */
@Entity(name = "ORDERS")
public class Order implements Serializable {

	private static final long serialVersionUID = -3298918499516179338L;

	@Id
	@GeneratedValue
	private int orderId;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "STATUS_CHANGE_DATE")
	private Date statusChangeDate;

	@OneToOne
	@JoinColumn(name = "cartId")
	private Cart cart;

	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	@OneToOne
	@JoinColumn(name = "billingAddressId")
	private BillingAddress billingAddress;

	@OneToOne
	@JoinColumn(name = "shippingingAddressId")
	private ShippingAddress shippingAddress;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderItem> orderItems;

	/**
	 * Konstruktor bezparametryczny. Inicjuje status zam�wienia, dat�
	 * utworzenia, dat� zmiany statusu, list� pozycji zam�wienia.
	 */
	public Order() {
		status = Status.NEW.getDescription();
		creationDate = new Date();
		statusChangeDate = new Date();
		orderItems = new ArrayList<>();
	}

	/**
	 * Kokstruktor przyjmuj�cy koszyk klienta {@link Cart} jako parametr.
	 * Wywo�yje konstruktor bezparametrowy. Wype�nia list� pozycji zam�wienia
	 * pozycjami z linii agreguj�cych koszyka klienta.
	 * 
	 * @param cart
	 */
	public Order(Cart cart) {
		this();
		List<CartItem> cartItems = cart.getCartItems();
		for (CartItem cartItem : cartItems) {
			OrderItem orderItem = new OrderItem(this, cartItem);
			this.orderItems.add(orderItem);
		}
	}

	/**
	 * Metoda zwracaj�ca status zam�wienia
	 * 
	 * @return status zam�wienia
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Metoda ustawiaj�ca status zam�wienia
	 * 
	 * @param status
	 *            status zam�wienia
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Metoda zwracaj�ca id zam�wienia
	 * 
	 * @return id zam�wienia
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * Metoda ustawiaj�ca id zam�wienia
	 * 
	 * @param orderId
	 *            id zam�wienia
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * Metoda zwracaj�ca koszyk klienta, na podstawie, ktorego wykreowano
	 * zam�wienia.
	 * 
	 * @return koszyk klienta
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * Metoda ustawiaj�ca koszyk klienta, na podstawie, ktorego wykreowano
	 * zam�wienia.
	 * 
	 * @param cart
	 *            koszyk klienta
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/**
	 * Metoda zwracaj�ca klienta, dla kt�rego wykreowano zam�wienie.
	 * 
	 * @return klient, dla kt�rego wykreowano zam�wienie.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Metoda ustawiaj�ca klienta, dla kt�rego wykreowano zam�wienie.
	 * 
	 * @param customer
	 *            klient, dla kt�rego wykreowano zam�wienie.
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * MEtoda zwracaj�ca adres do faktury {@link BillingAddress}
	 * 
	 * @return adres do faktury {@link BillingAddress}
	 */
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	/**
	 * Metoda ustawiaj�ca adres do faktury {@link BillingAddress}
	 * 
	 * @param billingAddress
	 *            adres do faktury {@link BillingAddress}
	 */
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * Metoda zwracaj�ca adres dostawy {@link ShippingAddress}
	 * 
	 * @return adres dostawy {@link ShippingAddress}
	 */
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * Metoda ustawiaj�ca adres dostawy {@link ShippingAddress}
	 * 
	 * @param shippingingAddress
	 */
	public void setShippingAddress(ShippingAddress shippingingAddress) {
		this.shippingAddress = shippingingAddress;
	}

	/**
	 * Metoda zwracaj�ca dat� utworzenia zam�wienia
	 * 
	 * @return data utworzenia zam�wienia
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Metoda ustawiaj�ca dat� utworzenia zam�wienia
	 * 
	 * @param creationDate
	 *            data utworzenia zam�wienia
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Metoda zwracaj�ca dat� zmiany statusu zam�wienia.
	 * 
	 * @return data zmiany statusu zam�wienia.
	 */
	public Date getStatusChangeDate() {
		return statusChangeDate;
	}

	/**
	 * Metoda ustawiaj�ca dat� zmiany statusu zam�wienia.
	 * 
	 * @param statusChangeDate
	 *            data zmiany statusu zam�wienia.
	 */
	public void setStatusChangeDate(Date statusChangeDate) {
		this.statusChangeDate = statusChangeDate;
	}

	/**
	 * Metoda zwracaj�ca list� pozycji zam�wienia {@link OrderItem}
	 * 
	 * @return lista pozycji zam�wienia {@link OrderItem}
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * Metoda ustawiaj�ca list� pozycji zam�wienia {@link OrderItem}
	 * 
	 * @param orderItems
	 *            lista pozycji zam�wienia {@link OrderItem}
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", status=" + status + ", creationDate=" + creationDate
				+ ", statusChangeDate=" + statusChangeDate + ", cart=" + cart + ", customer=" + customer
				+ ", billingAddress=" + billingAddress + ", shippingAddress=" + shippingAddress + ", orderItems="
				+ orderItems + "]";
	}

}
