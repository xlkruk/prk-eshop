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
 * Klasa realizująca funkcje kontrolera, który obsługuje zapytania wysyłane
 * poprzez przeglądarkę od użytkowników, związane zamówieniami.
 * 
 * @author Łukasz Kruk
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
	 * Metoda obsługująca żądanie /order/{cartId}. Metoda tworzy nowe zamówienie
	 * {@link Order}. Metoda przy wykorzystaniu implementacji interfejsu
	 * {@link CartService} pobiera koszyk {@link Cart} o zadanym cartId.
	 * Nastepnie tworzy nowe zamówienie {@link Order}, do którego przypisuje
	 * koszyk klienta. Następnie pobiera Klienta {@link Customer} z instancji
	 * Koszyka {@link Cart}. Informacje pobrane z obiektu klienta
	 * {@link Customer}, są ustawiane jako atrybuty zamówienia. Zamówienie jest
	 * utrwalane przy pomocy {@link OrderService}. Żądanie jest przekierowywane
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

		int orderId = orderService.addOrder(customerOrder);
		return "redirect:/checkout?cartId=" + cartId + "&orderId=" + orderId;
	}

	/**
	 * Metoda obsługująca żądanie /order/viewOrder/{id} typu GET. Przy użyciu
	 * implementacji interfejsu {@link OrderService} pobierane jest zamówienie
	 * {@link Order} od id przekazanym w parametrach wywołania. Następnie
	 * zamówienie order jest zapisywane jako atrybut modelu {@link Model}
	 * 
	 * @param id
	 *            id zamówienia {@link Order}
	 * @param model
	 *            interfejs, Spring dostarcza implementację. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku.
	 * @throws Exception metoda może rzucić wyjątek.
	 */
	@RequestMapping("viewOrder/{id}")
	public String viewOrder(@PathVariable int id, Model model) throws Exception {
		Order order = orderService.getOrderById(id);
		model.addAttribute("order", order);

		return "viewOrder";
	}
}
