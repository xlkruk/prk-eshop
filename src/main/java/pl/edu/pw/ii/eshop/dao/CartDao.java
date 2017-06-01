package pl.edu.pw.ii.eshop.dao;

import java.io.IOException;

import pl.edu.pw.ii.eshop.model.Cart;

/**
 * Interfejs dostępu do obiektu {@link Cart} DAO.
 * 
 * @author Łukasz Kruk
 *
 */
public interface CartDao {

	/**
	 * Metoda zwracająca koszyk {@link Cart} o zadanym cartId
	 * 
	 * @param cartId
	 *            id koszyka
	 * @return koszyk klienta {@link Cart}
	 */
	Cart getCartById(int cartId);

	/**
	 * Metoda walidująca koszyk klienta o zadanym cartId.
	 * 
	 * @param cartId
	 *            id koszyka klienta
	 * @return koszyk klienta
	 * @throws IOException
	 */
	Cart validate(int cartId) throws IOException;

	/**
	 * Metoda realizująca utrwalenie zmodyfikowanego koszyka {@link Cart}
	 * 
	 * @param cart
	 */
	void update(Cart cart);

}
