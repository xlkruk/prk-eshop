package pl.edu.pw.ii.eshop.service;

import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.model.CartItem;

/**
 * Interfejs warstwy serwisu, definiujący metody związane z logiką biznesową
 * związaną z linią agregacyjną koszyka
 * 
 * @author Łukasz Kruk
 *
 */
public interface CartItemService {
	/**
	 * Metoda utrwalająca nową linię agregacyjną koszyka {@link CartItem}
	 * 
	 * @param cartItem
	 *            linia agregacyjna koszyka
	 */
	void addCartItem(CartItem cartItem);

	/**
	 * Metoda umożliwia skasowanie linii agregacyjnej {@link CartItem}
	 * 
	 * @param cartItem
	 *            linia agregacyjna koszyka do usunięcia.
	 */
	void deleteCartItem(CartItem cartItem);

	/**
	 * Metoda umożliwiająca usunięcie wszystkich lini agregacyjnych
	 * {@link CartItem} dla zadanego koszyka {@link Cart}
	 * 
	 * @param cart
	 *            koszyk {@link Cart}
	 */
	void deleteAllCartItems(Cart cart);

	/**
	 * Metoda zwracająca linię agregacyjną z produktem o zadanym id
	 * 
	 * @param productId
	 *            id produktu
	 * @return linia agregacyjna {@link CartItem}
	 */
	CartItem getCartItemByProductId(int productId);
}
