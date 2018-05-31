package pl.edu.pw.ii.eshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.CustomerInfo;
import pl.edu.pw.ii.eshop.model.Order;
import pl.edu.pw.ii.eshop.service.CustomerService;
import pl.edu.pw.ii.eshop.service.OrderService;

/**
 * Klasa realizująca funkcje kontrolera, który obsługuje zapytania wysyłane
 * poprzez przeglądarkę od użytkowników, związane z obsługą klientów.
 * 
 * @author Łukasz Kruk
 * @version 1.0
 */
@Controller
@RequestMapping("/customer")
public class CustomerHomeController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private OrderService orderService;

	/**
	 * Metoda obsługująca żądanie /customer/{username}. Zwraca nazwę widoku do
	 * wygenerowania w odpowiedzi. Przy pomocy obiektu implementującego
	 * interfejs {@link CustomerService} pobierany jest obiekt {@link Customer}
	 * reprezentujący klienta sklepu. Customer jest dodawany do modelu.
	 * 
	 * @param username
	 *            nazwa użytkownika serwisu, dla którego ma zostaż wygenerowana
	 *            strona.
	 * @param model
	 *            interfejs, Spring dostarcza implementację. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku
	 * @see Customer
	 * @see CustomerService
	 */
	@RequestMapping("{username}")
	public String customerPage(@PathVariable String username, Model model) {
		Customer customer = customerService.getCustomerByUsername(username);
		model.addAttribute("customer", customer);
		return "customer";
	}

	/**
	 * Metoda obsługująca żądanie /customer/editCustomer/{id}. Zwraca nazwę
	 * widoku do wygenerowania w odpowiedzi. Przy pomocy obiektu
	 * implementującego interfejs {@link CustomerService} pobierany jest obiekt
	 * {@link CustomerInfo} reprezentujący informację o kliencie sklepu o
	 * zadanym id. CustomerInfo jest dodawany do modelu.
	 * 
	 * @param id
	 *            id klienta sklepu
	 *
	 * @param model
	 *            interfejs, Spring dostarcza implementację. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku
	 * @see Customer
	 * @see CustomerInfo
	 * @see CustomerService
	 */
	@RequestMapping("/editCustomer/{id}")
	public String editProduct(@PathVariable("id") int id, Model model) {
		Customer customer = customerService.getCustomerById(id);
		CustomerInfo customerInfo = new CustomerInfo(customer);
		model.addAttribute("customer", customerInfo);
		return "editCustomer";
	}

	/**
	 * Metoda obsługująca żądanie /customer/editCustomer typu POST.
	 * Wykorzystuje {@link CustomerService} do utrwalenia modyfikowanego Klienta
	 * sklepu. Modyfikowane dane są walidowane i w przypadku pozytywnej
	 * walidacji (braku błędów walidacji), żądanie jest przekierowywane
	 * doredirect:/customer/{username}. W przeciwnym przypadku zwracana jest
	 * nazwa widoku do wygenerowania w odpowiedzi.
	 * 
	 * @param customer
	 *            Obiekt klasy {@link CustomerInfo}, reprezentujący informacje o
	 *            kliencie sklepu
	 * @param result
	 *            interfejs rozszerzający interfejs umożliwiający rejestrowanie
	 *            błędów, zastosowanie walidatora {@link Valid}.
	 * @param request
	 *            obiekt klasy {@link HttpServletRequest}, reprezentujący
	 *            żądanie HTTP.
	 * @return nazwa widoku
	 */
	@RequestMapping(value = "/editCustomer", method = RequestMethod.POST)
	public String editCustomer(@Valid @ModelAttribute("customer") CustomerInfo customer, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "editCustomer";
		}
		customerService.editCustomer(customer);
		return "redirect:/customer/" + customer.getUsername();

	}

	/**
	 * Metoda obsługująca żądanie /customer/orderList/{id} typu GET.
	 * Wykorzystuje implementację interfejsu {@link OrderService} do pobrania
	 * listy zamówień {@link Order} dla klienta o zadanym id. Lista zamówień
	 * jest dodawana do modelu. Metoda zwraca nazwę widoku do wygenerowania w
	 * odpowiedzi.
	 * 
	 * @param id
	 *            id klienta {@link Customer}, dla którego nalezy pobrać listę
	 *            zamówień.
	 * @param model
	 *            interfejs, Spring dostarcza implementację. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku.
	 */
	@RequestMapping("/orderList/{id}")
	public String orderList(@PathVariable int id, Model model) {
		List<Order> orders = orderService.getOrdersByCustomerId(id);
		model.addAttribute("orders", orders);
		return "customerOrderList";
	}

	/**
	 * Metoda obsługująca żądanie /customer/pay/{id} typu GET. Metoda przy
	 * użyciu implementacji interfejsu {@link OrderService} dla zamówienia o id
	 * przekazanym w parametrach wywołania, zmienia status na
	 * "PAYMENT_RECEIVED". Następnie pobierana jest lista wszystkich zamówień
	 * dla klienta o id zwróconego poprzez wywołanie
	 * order.getCustomer().getCustomerId(). Lista zamówień jest dodawana do
	 * modelu. Żądanie jest przekierowywane do
	 * redirect:/customer/orderList/{customerId}
	 * 
	 * @param id
	 *            id zamówienia do opłacenia
	 * @param model
	 *            interfejs, Spring dostarcza implementację. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku.
	 */
	@RequestMapping("/pay/{id}")
	public String payForOrder(@PathVariable int id, Model model) {
		Order order = orderService.getOrderById(id);
		orderService.setPaymentReceivedStatus(order);

		List<Order> orders = orderService.getOrdersByCustomerId(order.getCustomer().getCustomerId());
		model.addAttribute("orders", orders);
		return "redirect:/customer/orderList/" + order.getCustomer().getCustomerId();
	}
}
