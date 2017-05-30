package pl.edu.pw.ii.eshop.dao;

import java.io.IOException;

import pl.edu.pw.ii.eshop.model.Cart;

/**
 * Interfejs dostêpu do obiektu {@link Cart} DAO.
 * 
 * @author £ukasz Kruk
 *
 */
public interface CartDao {

	/**
	 * Metoda zwracaj¹ca koszyk {@link Cart} o zadanym cartId
	 * 
	 * @param cartId
	 *            id koszyka
	 * @return koszyk klienta {@link Cart}
	 */
	Cart getCartById(int cartId);

	/**
	 * Metoda waliduj¹ca koszyk klienta o zadanym cartId.
	 * 
	 * @param cartId
	 *            id koszyka klienta
	 * @return koszyk klienta
	 * @throws IOException
	 */
	Cart validate(int cartId) throws IOException;

	/**
	 * Metoda realizuj¹ca utrwalenie zmodyfikowanego koszyka {@link Cart}
	 * 
	 * @param cart
	 */
	void update(Cart cart);

}
