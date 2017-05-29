package pl.edu.pw.ii.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.Order;
import pl.edu.pw.ii.eshop.service.CartService;
import pl.edu.pw.ii.eshop.service.OrderService;

/**
 * Klasa realizuj�ca funkcje kontrolera, kt�ry obs�uguje zapytania wysy�ane
 * poprzez przegl�dark� od u�ytkownik�w, zwi�zane zam�wieniami.
 * 
 * @author Krzysztof Trybus
 * @version 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private CartService cartService;

	@Autowired
	private OrderService orderService;

	/**
	 * Metoda obs�uguj�ca ��danie /order/{cartId}. Metoda tworzy nowe zam�wienie
	 * {@link Order}. Metoda przy wykorzystaniu implementacji interfejsu
	 * {@link CartService} pobiera koszyk {@link Cart} o zadanym cartId.
	 * Nastepnie tworzy nowe zam�wienie {@link Order}, do kt�rego przypisuje
	 * koszyk klienta. Nast�pnie pobiera Klienta {@link Customer} za instancji
	 * Koszyka {@link Cart}. Informacje pobrane z obiektu klienta
	 * {@link Customer}, s� ustawiane jako atrybuty zam�wienia. Zam�wienie jest
	 * utrwalane przy pomocy {@link OrderService}. ��danie jest przekierowywane
	 * do redirect:/checkout?cartId={cartId}
	 * 
	 * @param cartId
	 *            id koszyka {@link Cart}
	 * @return nazwa widoku
	 */
	@RequestMapping("{cartId}")
	public String createOrder(@PathVariable("cartId") int cartId) {
		Cart cart = cartService.getCartById(cartId);
		Order customerOrder = new Order(cart);
		customerOrder.setCart(cart);

		Customer customer = cart.getCustomer();
		customerOrder.setCustomer(customer);
		customerOrder.setBillingAddress(customer.getBillingAddress());
		customerOrder.setShippingAddress(customer.getShippingAddress());

		orderService.addOrder(customerOrder);
		return "redirect:/checkout?cartId=" + cartId;
	}

	/**
	 * Metoda obs�uguj�ca ��danie /order/viewOrder/{id} typu GET. Przy u�yciu
	 * implementacji interfejsu {@link OrderService} bobierane jest zam�wienie
	 * {@link Order} od id przekazanym w parametrach wywo�ania. Nast�pnie
	 * zam�wienie order jest zapisywane jako atrybut modelu {@link Model}
	 * 
	 * @param id
	 *            id zam�wienia {@link Order}
	 * @param model
	 *            interfejs, Spring dostarcza implementacj�. Holder dla
	 *            atrybut�w modelu w MVC.
	 * @return nazwa widoku.
	 * @throws Exception
	 */
	@RequestMapping("viewOrder/{id}")
	public String viewOrder(@PathVariable int id, Model model) throws Exception {
		Order order = orderService.getOrderById(id);
		model.addAttribute("order", order);

		return "viewOrder";
	}
}
