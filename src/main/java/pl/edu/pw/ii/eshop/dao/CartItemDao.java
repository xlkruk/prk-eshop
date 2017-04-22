package pl.edu.pw.ii.eshop.dao;

import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.model.CartItem;

public interface CartItemDao {
	void addCartItem(CartItem cartItem);

	void deleteCartItem(CartItem cartItem);

	void deleteAllCartItems(Cart cart);

	CartItem getCartItemByProductId(int productId);
}
