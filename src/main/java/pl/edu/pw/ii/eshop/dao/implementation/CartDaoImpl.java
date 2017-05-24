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

	@Override
	public void update(Cart cart) {
		int cartId = cart.getCartId();
		double grandTotal=orderService.getOrderGrandTotal(cartId);
		cart.setGrantTotal(grandTotal);

		Session session = sesionFactory.getCurrentSession();
session.saveOrUpdate(cart);
	}

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
