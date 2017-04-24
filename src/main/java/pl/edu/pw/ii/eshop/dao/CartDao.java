package pl.edu.pw.ii.eshop.dao;

import java.io.IOException;

import pl.edu.pw.ii.eshop.model.Cart;

public interface CartDao{

	Cart getCartById(int cartId);
	
	Cart validate(int cartId) throws IOException;
	
	void update(Cart cart);

}
