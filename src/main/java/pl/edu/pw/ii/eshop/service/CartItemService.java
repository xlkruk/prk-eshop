package pl.edu.pw.ii.eshop.service;

import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.model.CartItem;

/**
 * Interfejs warstwy serwisu, definiuj¹cy metody zwi¹zane z logik¹ biznesow¹
 * zwi¹zan¹ z lini¹ agregacyjn¹ koszyka
 * 
 * @author £ukasz Kruk
 *
 */
public interface CartItemService {
	/**
	 * Metoda utrwalaj¹ca now¹ liniê agregacyjn¹ koszyka {@link CartItem}
	 * 
	 * @param cartItem
	 *            linia agregacyjna koszyka
	 */
	void addCartItem(CartItem cartItem);

	/**
	 * Metoda umo¿liwienie skasowanie linii agregacyjnej {@link CartItem}
	 * 
	 * @param cartItem
	 *            linia agregacyjna koszyka do usuniêcia.
	 */
	void deleteCartItem(CartItem cartItem);

	/**
	 * Metoda umo¿liwiaj¹ca usuniêcie wszystkich lini agregacyjnych
	 * {@link CartItem} dla zadanego koszyka {@link Cart}
	 * 
	 * @param cart
	 *            koszyk {@link Cart}
	 */
	void deleteAllCartItems(Cart cart);

	/**
	 * Metoda zwracaj¹ca liniê agregacyjn¹ z produktem o zadanym id
	 * 
	 * @param productId
	 *            id produktu
	 * @return linia agregacyjna {@link CartItem}
	 */
	CartItem getCartItemByProductId(int productId);
}
