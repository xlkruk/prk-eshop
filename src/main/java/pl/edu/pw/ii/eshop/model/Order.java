package pl.edu.pw.ii.eshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="ORDERS")
public class Order implements Serializable{

	private static final long serialVersionUID = -3298918499516179338L;
	
	@Id
	@GeneratedValue
	private int orderId;
	
	@OneToOne
	@JoinColumn(name="cartId")
	private Cart cart;
	
	@OneToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="billingAddressId")
	private BillingAddress billingAddress;
	
	@OneToOne
	@JoinColumn(name="shippingingAddressId")
	private ShippingAddress shippingingAddress;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingingAddress() {
		return shippingingAddress;
	}

	public void setShippingingAddress(ShippingAddress shippingingAddress) {
		this.shippingingAddress = shippingingAddress;
	}

	
}
