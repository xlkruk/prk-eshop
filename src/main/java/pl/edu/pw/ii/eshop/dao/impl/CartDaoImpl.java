package pl.edu.pw.ii.eshop.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pl.edu.pw.ii.eshop.dao.CartDao;
import pl.edu.pw.ii.eshop.model.Cart;

@Repository
public class CartDaoImpl implements CartDao {

	private Map<String, Cart> carts;

	public CartDaoImpl() {
		carts = new HashMap<String, Cart>();
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
	public Cart read(String cartId) {
		return carts.get(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		if (!carts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(
					String.format("Nie mo¿na zmodyfikowaæ koszyka, koszyk o id[%] nie istnieje", cart.getCartId()));
		}

		carts.put(cartId, cart);
	}

	@Override
	public void delete(String cartId) {
		if (!carts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(
					String.format("Nie mo¿na usun¹æ koszyka, koszyk o id[%] nie istnieje", cartId));
		}
		carts.remove(cartId);
	}

}
