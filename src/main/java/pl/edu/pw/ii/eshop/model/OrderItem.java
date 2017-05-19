package pl.edu.pw.ii.eshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	public OrderItem(Order order, CartItem cartItem) {
		this.order=order;
		this.productName = cartItem.getProduct().getName();
		this.quantity=cartItem.getQuantity();
		this.totalPrice=cartItem.getTotalPrice();
		this.price=cartItem.getProduct().getPrice();
	}
	
	

	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public OrderItem() {
	}

}
