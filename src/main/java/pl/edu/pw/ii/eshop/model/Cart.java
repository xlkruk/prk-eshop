package pl.edu.pw.ii.eshop.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private String CartId;
	private Map<Integer, CartItem> cartItems;
	private double grandTotal;

	public Cart() {
		cartItems = new HashMap<Integer, CartItem>();
		grandTotal = 0;
	}

	public Cart(String id) {
		this();
		this.CartId = id;
	}

	public String getCartId() {
		return CartId;
	}

	public void setCartId(String cartId) {
		CartId = cartId;
	}

	public Map<Integer, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<Integer, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public void addCartItem(CartItem cartItem) {
		int productId = cartItem.getProduct().getId();
		if (cartItems.containsKey(productId)) {
			CartItem existingCartItem = cartItems.get(productId);
			existingCartItem.setQuantity(existingCartItem.getQuantity() + cartItem.getQuantity());
			cartItems.put(productId, existingCartItem);
		} else {
			cartItems.put(productId, cartItem);
		}

		updateGrantTotal();
	}

	public void removeCartItem(CartItem cartItem) {
		int productId = cartItem.getProduct().getId();
		cartItems.remove(productId);
		updateGrantTotal();
	}

	public void updateGrantTotal() {
		grandTotal = 0;
		for (CartItem cartItem : cartItems.values()) {
			grandTotal=grandTotal+cartItem.getTotalPrice();
		}
	};
	
	
}
