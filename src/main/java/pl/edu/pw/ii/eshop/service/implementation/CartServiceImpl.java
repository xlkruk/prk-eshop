package pl.edu.pw.ii.eshop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.pw.ii.eshop.dao.CartDao;
import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.model.CartItem;
import pl.edu.pw.ii.eshop.service.CartService;

/**
 * Klasa implementująca interfejs {@link CartService}. wykorzystuje
 * implementację interfejsu {@link CartDao} do komunikacji z warstwą dostępu do
 * danych.
 * 
 * @author Krzysztof Trybus
 *
 */

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;

	@Override
	public Cart getCartById(int cartId) {
		return cartDao.getCartById(cartId);
	}

	@Override
	public void update(Cart cart) {
		cartDao.update(cart);

	}

}
