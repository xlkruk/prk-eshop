package pl.edu.pw.ii.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.model.CartItem;
import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.service.CartItemService;
import pl.edu.pw.ii.eshop.service.CartService;
import pl.edu.pw.ii.eshop.service.CustomerService;
import pl.edu.pw.ii.eshop.service.ProductService;

/**
 * Klasa realizuj�ca funkcje kontrolera, kt�ry obs�uguje zapytania wysy�ane
 * poprzez przegl�dark� od u�ytkownik�w.
 * 
 * @author �ukasz Kruk
 * @version 1.0
 */
@Controller
@RequestMapping("/api/cart")
public class CartResources {

	@Autowired
	private CartService cartService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CartItemService cartItemService;

	/**
	 * Metoda obs�uguj�ca ��danie przegl�darki /api/cart/{cartId}. Metoda
	 * wykorzystuje implementacj� interfejsu CartService do pobrania koszyka o
	 * zadanym id reprezentowanego jako obiekt klasy {@link Cart}. Metoda zwraca
	 * koszyk o zadanym id w formacie JSON
	 * 
	 * @param cartId
	 *            id koszyka
	 * @return obiekt klasy {@link Cart} w formacie JSON
	 * @see CartService
	 */
	@RequestMapping("/{cartId}")
	public @ResponseBody Cart getCartById(@PathVariable(value = "cartId") int cartId) {// JSON
																						// dzieki
																						// jackson
																						// dependency
																						// w
																						// pom
		return cartService.getCartById(cartId);
	}

	/**
	 * Metoda obs�uguj�ca ��danie przegl�darki /api/cart/add/{productId} przy
	 * pomocy metody PUT. Metoda wykorzystuje implementacj� interfejsu
	 * CartItemService do dodania produktu o zadanym id do linii agreguj�cej
	 * koszyka. Linia agreguj�ca rozumiana jako element koszyka, kt�ry agreguje
	 * wszytkie produkty tego samego typu. Je�eli istnieje linia agregacyjna
	 * {@link CartItem} dla produktu o productId, to jest on dodawany do niej. W
	 * przeciwnym przypadku jest tworzona nowa linia agregacyjna i produkt
	 * {@link Product} jest dodawany do niej. linia agregacyjna jest utrwalana.
	 * 
	 * @param productId
	 *            id produktu
	 * @see CartService
	 * @see CartItemService
	 */
	@RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value = "productId") int productId, @AuthenticationPrincipal User user) {
		/* pobranie klienta o zadanym username */
		Customer customer = customerService.getCustomerByUsername(user.getUsername());
		Cart cart = customer.getCart();
		Product product = productService.getProductById(productId);
		List<CartItem> cartItems = cart.getCartItems();

		/*
		 * przeliczenie ilo�ci produkt�w oraz ceny ca�kowitej dla linii
		 * agregacyjnych
		 */
		for (int i = 0; i < cartItems.size(); i++) {
			if (product.getId() == cartItems.get(i).getProduct().getId()) {
				CartItem cartItem = cartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(Math.round(((100 - product.getDiscount()) * 100) / 100f * product.getPrice())
						/ 100f * cartItem.getQuantity());
				cartItemService.addCartItem(cartItem);
				return;
			}
		}

		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(
				Math.round(((100 - product.getDiscount()) * 100) / 100f * product.getPrice() * cartItem.getQuantity())
						/ 100f);
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);

	}

	/**
	 * Metoda wykorzystuj�ca implementacj� interfejsu {@link CartItemService} do
	 * usuni�cia linii agregacyjnej koszyka z produktami o zadanym productId
	 * 
	 * @param productId
	 *            id produktu, dla kt�rego ma zosta� usuni�ta linia agregacyjna
	 *            koszyka
	 * @see CartItemService
	 */

	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable(value = "productId") int productId) {
		CartItem cartItem = cartItemService.getCartItemByProductId(productId);
		cartItemService.deleteCartItem(cartItem);
	}

	/**
	 * Metoda realizuj�ca funkcjonalno�� wyczyszczenia koszyka polegaj�c� na
	 * usuni�ciu wszytkich linii agregacyjnych koszyka. Metoda wykorzystuje
	 * implementacj� interfejsu {@link CartItemService} do usuni�cia wszystkich
	 * linii agregacyjnych.
	 * 
	 * @param cartId
	 *            id koszyka do wyczyszczenia.
	 * @see CartItemService
	 */
	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void clearCart(@PathVariable(value = "cartId") int cartId) {
		Cart cart = cartService.getCartById(cartId);
		cartItemService.deleteAllCartItems(cart);
	}

	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "B��dne ��danie")
	public void handleClientErrors(Exception e) {
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Wewn�trzny b��d serwera")
	public void handleServerErrors(Exception e) {
	}

}
