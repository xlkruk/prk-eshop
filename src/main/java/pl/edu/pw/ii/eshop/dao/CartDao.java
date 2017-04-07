package pl.edu.pw.ii.eshop.dao;

import pl.edu.pw.ii.eshop.model.Cart;

public interface CartDao {

	Cart create(Cart cart);

	Cart read(Integer cartId);

	void update(Integer cartId, Cart cart);

	void delete(Integer cartId);

}
