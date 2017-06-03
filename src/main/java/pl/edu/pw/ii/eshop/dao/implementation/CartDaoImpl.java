package pl.edu.pw.ii.eshop.dao.implementation;

import java.io.IOException;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.edu.pw.ii.eshop.dao.CartDao;
import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.service.OrderService;

/**
 * Klasa implementująca interfejs {@link CartDao}.
 * 
 * @author Łukasz Kruk
 *
 */
@Repository
@Transactional
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sesionFactory;

	@Autowired
	private OrderService orderService;

	@Override
	public Cart getCartById(int cartId) {
		Session session = sesionFactory.getCurrentSession();

		return (Cart) session.get(Cart.class, cartId);
	}

	/**
	 * Metoda umożliwiająca utrwalenie modyfikowanego koszyka {@link Cart}.
	 * Metoda wykorzystująca implementację interfejsu {@link OrderService} do
	 * pobrania ceny całkowitej zamówienia.
	 * 
	 * @param cart
	 *            koszyk {@link Cart}
	 */
	@Override
	public void update(Cart cart) {
		int cartId = cart.getCartId();
		double grandTotal = orderService.getOrderGrandTotal(cartId);
		cart.setGrantTotal(grandTotal);

		Session session = sesionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
	}

	/**
	 * Metoda walidująca czy koszyk o danym id istnieje. Jeżeli tak, to zwraca
	 * koszyk {@link Cart}, w przeciwnym wypadku rzucany jest wyjątek
	 * IOException
	 * 
	 * @param cartId
	 *            id koszyka {@link Cart}
	 * @return koszyk {@link Cart}
	 */
	@Override
	public Cart validate(int cartId) throws IOException {
		Cart cart = getCartById(cartId);
		if (cart == null || cart.getCartItems().size() == 0) {
			throw new IOException(cartId + "");
		}
		update(cart);
		return cart;
	}

}
