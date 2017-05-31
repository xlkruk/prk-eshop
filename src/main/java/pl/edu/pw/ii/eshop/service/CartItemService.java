package pl.edu.pw.ii.eshop.service;

import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.model.CartItem;

/**
 * Interfejs warstwy serwisu, definiuj�cy metody zwi�zane z logik� biznesow�
 * zwi�zan� z lini� agregacyjn� koszyka
 * 
 * @author �ukasz Kruk
 *
 */
public interface CartItemService {
	/**
	 * Metoda utrwalaj�ca now� lini� agregacyjn� koszyka {@link CartItem}
	 * 
	 * @param cartItem
	 *            linia agregacyjna koszyka
	 */
	void addCartItem(CartItem cartItem);

	/**
	 * Metoda umo�liwienie skasowanie linii agregacyjnej {@link CartItem}
	 * 
	 * @param cartItem
	 *            linia agregacyjna koszyka do usuni�cia.
	 */
	void deleteCartItem(CartItem cartItem);

	/**
	 * Metoda umo�liwiaj�ca usuni�cie wszystkich lini agregacyjnych
	 * {@link CartItem} dla zadanego koszyka {@link Cart}
	 * 
	 * @param cart
	 *            koszyk {@link Cart}
	 */
	void deleteAllCartItems(Cart cart);

	/**
	 * Metoda zwracaj�ca lini� agregacyjn� z produktem o zadanym id
	 * 
	 * @param productId
	 *            id produktu
	 * @return linia agregacyjna {@link CartItem}
	 */
	CartItem getCartItemByProductId(int productId);
}
