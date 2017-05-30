package pl.edu.pw.ii.eshop.dao;

import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.model.CartItem;

/**
 * Interfejs dostêpu do obiektu {@link CartItemDao} DAO.
 * 
 * @author £ukasz Kruk
 *
 */
public interface CartItemDao {

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
