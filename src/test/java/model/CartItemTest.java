package model;

import static org.junit.Assert.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.model.CartItem;

public class CartItemTest extends CartItem{
	private static final long serialVersionUID = 1031671822500452085L;
	@Id
	@GeneratedValue
	private int cartItemId = 1298;

	@ManyToOne
	@JoinColumn(name = "cartId")
	@JsonIgnore // potrzebne aby nie zapêtlaæ budowy JSOna
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;

	private int quantity = 10;
	private double totalPrice = 99.98;

	@Test
	public void testGetCartItemId() {
		setCartItemId(cartItemId);
		assertEquals(cartItemId,getCartItemId());
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
