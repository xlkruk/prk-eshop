package pl.edu.pw.ii.eshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

	@RequestMapping("/{cartId}")
	public @ResponseBody Cart getCartById(@PathVariable(value = "cartId") int cartId) {// JSON
																						// dzieki
																						// jackson
																						// dependency
																						// w
																						// pom
		return cartService.getCartById(cartId);
	}

	@RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value = "productId") int productId, @AuthenticationPrincipal User user) {
		Customer customer = customerService.getCustomerByUsername(user.getUsername());
		Cart cart = customer.getCart();
		Product product = productService.getProductById(productId);
		List<CartItem> cartItems = cart.getCartItems();

		for (int i = 0; i < cartItems.size(); i++) {
			if (product.getId() == cartItems.get(i).getProduct().getId()) {
				CartItem cartItem = cartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
				cartItemService.addCartItem(cartItem);
				return;
			}
		}

		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);

	}

	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable(value = "productId") int productId) {
		CartItem cartItem = cartItemService.getCartItemByProductId(productId);
		cartItemService.deleteCartItem(cartItem);
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void clearCart(@PathVariable(value = "cartId") int cartId) {
		Cart cart = cartService.getCartById(cartId);
		cartItemService.deleteAllCartItems(cart);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "B³êdne ¿¹danie")
	public void handleClientErrors(Exception e) {
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Wewnêtrzny b³¹d serwera")
	public void handleServerErrors(Exception e) {
	}

}
