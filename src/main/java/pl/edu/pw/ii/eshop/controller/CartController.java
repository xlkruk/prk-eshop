package pl.edu.pw.ii.eshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.model.Categories;
import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.Order;
import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.service.CustomerService;
import pl.edu.pw.ii.eshop.service.OrderService;
import pl.edu.pw.ii.eshop.service.ProductService;

/**
 * Klasa realizuj�ca funkcje kontrolera, kt�ry obs�uguje zapytania wysy�ane
 * poprzez przegl�dark� od u�ytkownik�w.
 * 
 * @author �ukasz Kruk
 * @version 1.0
 */
@Controller
@RequestMapping("/customer/cart")
public class CartController {

	@Autowired
	private CustomerService customerService;

	/**
	 * Metoda obs�uguj�ca ��danie przegl�darki /customer/cart przy pomocy
	 * metody GET. Metoda wykorzystuje implementacj� interfejsu CustomerService
	 * do pobrania id Koszyka u�ytkownika, przekazanego w parametrze wywo�ania
	 * metody. ��danie jest przekierowywane do /customer/cart/{id}.
	 * 
	 * @param user
	 *            obiekt {@link User}
	 * 
	 * @return nazwa widoku.
	 * @see CustomerService
	 * @see User
	 * @see Cart
	 */
	@RequestMapping
	public String getCartRedirect(@AuthenticationPrincipal User user) {
		Customer customer = customerService.getCustomerByUsername(user.getUsername());
		int cartId = customer.getCart().getCartId();
		return "redirect:/customer/cart/" + cartId;
	}

	/**
	 * Metoda obs�uguj�ca ��danie przegl�darki /customer/cart/{cartId}. Metoda
	 * zapisuje id koszyka w modelu. Metoda Zwraca nazw� widoku do wygenerowania
	 * odpowiedzi.
	 * 
	 * @param cartId
	 *            id koszyka do dodania w modelu
	 * @param model
	 *            interfejs, Spring dostarcza implementacj�. Holder dla
	 *            atrybut�w modelu w MVC.
	 * @return nazwa widoku.
	 * @see Cart
	 * @see Model
	 */
	@RequestMapping("/{cartId}")
	public String getCart(@PathVariable(value = "cartId") int cartId, Model model) {
		model.addAttribute("cartId", cartId);
		return "cart";
	}
}
