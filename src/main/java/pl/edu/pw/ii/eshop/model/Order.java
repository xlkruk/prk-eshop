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
 * Klasa reprezentuj¹ca encjê ORDERS, zamówienie klienta
 * 
 * @author Agnieszka Œwiderska
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
	 * Konstruktor bezparametryczny. Inicjuje status zamówienia, datê
	 * utworzenia, datê zmiany statusu, listê pozycji zamówienia.
	 */
	public Order() {
		status = Status.NEW.getDescription();
		creationDate = new Date();
		statusChangeDate = new Date();
		orderItems = new ArrayList<>();
	}

	/**
	 * Kokstruktor przyjmuj¹cy koszyk klienta {@link Cart} jako parametr.
	 * Wywo³yje konstruktor bezparametrowy. Wype³nia listê pozycji zamówienia
	 * pozycjami z linii agreguj¹cych koszyka klienta.
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
	 * Metoda zwracaj¹ca status zamówienia
	 * 
	 * @return status zamówienia
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Metoda ustawiaj¹ca status zamówienia
	 * 
	 * @param status
	 *            status zamówienia
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Metoda zwracaj¹ca id zamówienia
	 * 
	 * @return id zamówienia
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * Metoda ustawiaj¹ca id zamówienia
	 * 
	 * @param orderId
	 *            id zamówienia
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * Metoda zwracaj¹ca koszyk klienta, na podstawie, ktorego wykreowano
	 * zamówienia.
	 * 
	 * @return koszyk klienta
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * Metoda ustawiaj¹ca koszyk klienta, na podstawie, ktorego wykreowano
	 * zamówienia.
	 * 
	 * @param cart
	 *            koszyk klienta
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/**
	 * Metoda zwracaj¹ca klienta, dla którego wykreowano zamówienie.
	 * 
	 * @return klient, dla którego wykreowano zamówienie.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Metoda ustawiaj¹ca klienta, dla którego wykreowano zamówienie.
	 * 
	 * @param customer
	 *            klient, dla którego wykreowano zamówienie.
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * MEtoda zwracaj¹ca adres do faktury {@link BillingAddress}
	 * 
	 * @return adres do faktury {@link BillingAddress}
	 */
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	/**
	 * Metoda ustawiaj¹ca adres do faktury {@link BillingAddress}
	 * 
	 * @param billingAddress
	 *            adres do faktury {@link BillingAddress}
	 */
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * Metoda zwracaj¹ca adres dostawy {@link ShippingAddress}
	 * 
	 * @return adres dostawy {@link ShippingAddress}
	 */
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * Metoda ustawiaj¹ca adres dostawy {@link ShippingAddress}
	 * 
	 * @param shippingingAddress
	 */
	public void setShippingAddress(ShippingAddress shippingingAddress) {
		this.shippingAddress = shippingingAddress;
	}

	/**
	 * Metoda zwracaj¹ca datê utworzenia zamówienia
	 * 
	 * @return data utworzenia zamówienia
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Metoda ustawiaj¹ca datê utworzenia zamówienia
	 * 
	 * @param creationDate
	 *            data utworzenia zamówienia
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Metoda zwracaj¹ca datê zmiany statusu zamówienia.
	 * 
	 * @return data zmiany statusu zamówienia.
	 */
	public Date getStatusChangeDate() {
		return statusChangeDate;
	}

	/**
	 * Metoda ustawiaj¹ca datê zmiany statusu zamówienia.
	 * 
	 * @param statusChangeDate
	 *            data zmiany statusu zamówienia.
	 */
	public void setStatusChangeDate(Date statusChangeDate) {
		this.statusChangeDate = statusChangeDate;
	}

	/**
	 * Metoda zwracaj¹ca listê pozycji zamówienia {@link OrderItem}
	 * 
	 * @return lista pozycji zamówienia {@link OrderItem}
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * Metoda ustawiaj¹ca listê pozycji zamówienia {@link OrderItem}
	 * 
	 * @param orderItems
	 *            lista pozycji zamówienia {@link OrderItem}
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
