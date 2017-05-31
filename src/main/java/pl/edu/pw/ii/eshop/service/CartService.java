package pl.edu.pw.ii.eshop.service;

import pl.edu.pw.ii.eshop.model.Cart;

/**
 * Interfejs warstwy serwisu, definiuj�cy metody zwi�zane z logik� biznesow�
 * zwi�zan� z koszykiem klienta
 * 
 * @author �ukasz Kruk
 *
 */

public interface CartService {
	/**
	 * Metoda zwracaj�ca koszyk {@link Cart} o zadanym cartId
	 * 
	 * @param cartId
	 *            id koszyka
	 * @return koszyk klienta {@link Cart}
	 */
	Cart getCartById(int cartId);

	/**
	 * Metoda realizuj�ca utrwalenie zmodyfikowanego koszyka {@link Cart}
	 * 
	 * @param cart
	 */
	void update(Cart cart);

}
