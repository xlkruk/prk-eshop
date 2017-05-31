package pl.edu.pw.ii.eshop.dao.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.edu.pw.ii.eshop.dao.CartItemDao;
import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.model.CartItem;

/**
 * Klasa implementuj¹ca interfejs {@link CartItemDao}
 * 
 * @author Agnieszka Œwiderska
 *
 */
@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCartItem(CartItem cartItem) {
		// pobranie obiektu Session
		Session session = sessionFactory.getCurrentSession();
		// utrwalene obiektu CartItem w bazie danych
		session.saveOrUpdate(cartItem);
		// wymuszenie wykonania operacji.
		session.flush();

	}

	@Override
	public void deleteCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartItem);
		session.flush();

	}

	@Override
	public void deleteAllCartItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartItems();
		for (CartItem cartItem : cartItems) {
			deleteCartItem(cartItem);
		}

	}

	@Override
	public CartItem getCartItemByProductId(int productId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CartItem where productId=?");
		query.setInteger(0, productId);
		session.flush();
		return (CartItem) query.uniqueResult();
	}

}
