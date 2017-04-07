package pl.edu.pw.ii.eshop.dao.impl;

import java.util.HashMap;
import java.util.Map;

import pl.edu.pw.ii.eshop.dao.CartDao;
import pl.edu.pw.ii.eshop.model.Cart;

public class CartDaoImpl implements CartDao {

	private Map<Integer, Cart> carts;

	public CartDaoImpl() {
		carts = new HashMap<Integer, Cart>();
	}

	@Override
	public Cart create(Cart cart) {
		if (carts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(
					String.format("Nie mo¿na utworzyæ koszyka, koszyk o id[%] ju¿ istnieje", cart.getCartId()));
		}

		carts.put(cart.getCartId(), cart);
		return cart;
	}

	@Override
	public Cart read(Integer cartId) {
		return carts.get(cartId);
	}

	@Override
	public void update(Integer cartId, Cart cart) {
		if (!carts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(
					String.format("Nie mo¿na zmodyfikowaæ koszyka, koszyk o id[%] nie istnieje", cart.getCartId()));
		}

		carts.put(cartId, cart);
	}

	@Override
	public void delete(Integer cartId) {
		if (!carts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(
					String.format("Nie mo¿na usun¹æ koszyka, koszyk o id[%] nie istnieje", cartId));
		}
		carts.remove(cartId);
	}

}
