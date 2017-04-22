package pl.edu.pw.ii.eshop.dao.implementation;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.edu.pw.ii.eshop.dao.CartDao;
import pl.edu.pw.ii.eshop.model.Cart;

@Repository
@Transactional
public class CartDaoImpl implements CartDao{
	
	@Autowired
	private SessionFactory sesionFactory;

	@Override
	public Cart getCartById(int cartId) {
		Session session = sesionFactory.getCurrentSession();
		
		return (Cart) session.get(Cart.class, cartId);
	}

	@Override
	public void update(Cart cart) {
		int cartId = cart.getCartId();
		
		Session session = sesionFactory.getCurrentSession();
		
	}

}
