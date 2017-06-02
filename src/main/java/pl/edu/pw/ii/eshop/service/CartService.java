package pl.edu.pw.ii.eshop.service;

import pl.edu.pw.ii.eshop.model.Cart;

/**
 * Interfejs warstwy serwisu, definiujący metody związane z logiką biznesową
 * związaną z koszykiem klienta
 * 
 * @author Łukasz Kruk
 *
 */

public interface CartService {
	/**
	 * Metoda zwracająca koszyk {@link Cart} o zadanym cartId
	 * 
	 * @param cartId
	 *            id koszyka
	 * @return koszyk klienta {@link Cart}
	 */
	Cart getCartById(int cartId);

	/**
	 * Metoda realizująca utrwalenie zmodyfikowanego koszyka {@link Cart}
	 * 
	 * @param cart
	 *            koszyk klienta {@link Cart}
	 */
	void update(Cart cart);

}
