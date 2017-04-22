package pl.edu.pw.ii.eshop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.pw.ii.eshop.dao.CartItemDao;
import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.model.CartItem;
import pl.edu.pw.ii.eshop.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemDao cartItemDao;

	@Override
	public void addCartItem(CartItem cartItem) {
		cartItemDao.addCartItem(cartItem);

	}

	@Override
	public void deleteCartItem(CartItem cartItem) {
		cartItemDao.deleteCartItem(cartItem);

	}

	@Override
	public void deleteAllCartItems(Cart cart) {
		cartItemDao.deleteAllCartItems(cart);

	}
	@Override
	public CartItem getCartItemByProductId(int productId) {
		
		return cartItemDao.getCartItemByProductId(productId);
	}
}
