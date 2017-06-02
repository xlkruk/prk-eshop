package model;

import static org.junit.Assert.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.junit.Test;

import pl.edu.pw.ii.eshop.model.Order;
import pl.edu.pw.ii.eshop.model.OrderItem;

public class OrderItemTest extends OrderItem{
	private static final long serialVersionUID = 4284021384759341954L;

	@Id
	@GeneratedValue
	private int orderItemId = 9238;

	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;

	private String productName = "Kanapa";
	private int quantity = 3;
	private double price = 299.98;
	private double totalPrice = 899.94;

	@Test
	public void testGetPrice() {
		setPrice(price);
		assertEquals(price,getPrice(),0.01);
	}

	@Test
	public void testGetOrderItemId() {
		setOrderItemId(orderItemId);
		assertEquals(orderItemId, getOrderItemId());
	}

	@Test
	public void testGetProductName() {
		setProductName(productName);
		assertEquals(productName, getProductName());
	}

	@Test
	public void testGetQuantity() {
		setQuantity(quantity);
		assertEquals(quantity, getQuantity());
	}

	@Test
	public void testGetTotalPrice() {
		setTotalPrice(totalPrice);
		assertEquals(totalPrice, getTotalPrice(),0.01);
	}
}
