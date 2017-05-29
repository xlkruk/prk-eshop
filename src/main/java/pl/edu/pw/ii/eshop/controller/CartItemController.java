package pl.edu.pw.ii.eshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.service.CustomerService;

/**
 * Klasa realizuj¹ca funkcje kontrolera, który obs³uguje zapytania wysy³ane
 * poprzez przegl¹darkê od u¿ytkowników.
 * 
 * @author £ukasz Kruk
 * @version 1.0
 */

@Controller
@RequestMapping("/cart")
public class CartItemController {

	/**
	 * Metoda obs³uguj¹ca ¿¹danie przegl¹darki /cart przy pomocy metody GET. id
	 * koszyka jes uto¿samiane z id sesji. ¯¹danie jest przekierowywane do
	 * /cart/{id}.
	 * 
	 * @param request
	 *            obiekt {@link HttpServletRequest}
	 * 
	 * @return nazwa widoku.
	 * @see HttpServletRequest
	 */
	@RequestMapping
	public String get(HttpServletRequest request) {
		return "redirect:/cart/" + request.getSession(true).getId();
	}

	/**
	 * Metoda obs³uguj¹ca ¿¹danie przegl¹darki /cart/{cartId}. Metoda
	 * zapisuje id koszyka w modelu. Metoda zwraca nazwê widoku do wygenerowania
	 * odpowiedzi.
	 * 
	 * @param cartId
	 *            id koszyka do dodania w modelu
	 * @param model
	 *            interfejs, Spring dostarcza implementacjê. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku.
	 * @see Cart
	 * @see Model
	 */
	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public String getCart(@PathVariable(value = "cartId") String cartId, Model model) {
		model.addAttribute("cartId", cartId);

		return "cart";
	}
}
