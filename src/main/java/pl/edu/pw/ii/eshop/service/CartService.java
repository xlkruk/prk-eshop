package pl.edu.pw.ii.eshop.service;

import pl.edu.pw.ii.eshop.model.Cart;


public interface CartService {

	Cart getCartById(int cartId);

	void update(Cart cart);

}
