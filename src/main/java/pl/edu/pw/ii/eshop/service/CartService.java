package pl.edu.pw.ii.eshop.service;

import pl.edu.pw.ii.eshop.model.Cart;

/**
 * Interfejs warstwy serwisu, definiuj¹cy metody zwi¹zane z logik¹ biznesow¹
 * zwi¹zan¹ z koszykiem klienta
 * 
 * @author £ukasz Kruk
 *
 */

public interface CartService {
	/**
	 * Metoda zwracaj¹ca koszyk {@link Cart} o zadanym cartId
	 * 
	 * @param cartId
	 *            id koszyka
	 * @return koszyk klienta {@link Cart}
	 */
	Cart getCartById(int cartId);

	/**
	 * Metoda realizuj¹ca utrwalenie zmodyfikowanego koszyka {@link Cart}
	 * 
	 * @param cart
	 */
	void update(Cart cart);

}
