package model;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pl.edu.pw.ii.eshop.model.CartItem;
import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.Cart;

/**
 * @author Krzysztof Trybus
 * @version 1.0
 *
 */

public class CartTest extends Cart {
	private static final long serialVersionUID = -2776944850978772811L;
	private int cartId = 12345;

	private double grantTotal = 50.98;
	
	public void testGetCartId() {
		setCartId(cartId);
		assertEquals(cartId, getCartId());
		assertFalse("4321".equals(getCartId()));
	}

	@Test
	public void testGetGrantTotal() {
		setGrantTotal(grantTotal);
		assertEquals(grantTotal, getGrantTotal(),0.01);
		assertFalse("50.97".equals(getGrantTotal()));
	}

}
