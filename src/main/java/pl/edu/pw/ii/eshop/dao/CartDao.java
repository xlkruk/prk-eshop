package pl.edu.pw.ii.eshop.dao;

import pl.edu.pw.ii.eshop.model.Cart;

public interface CartDao{

	Cart getCartById(int cartId);
	
	void update(Cart cart);

}
