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
import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.model.ProductInfo;
import pl.edu.pw.ii.eshop.model.Status;
import pl.edu.pw.ii.eshop.service.CustomerService;
import pl.edu.pw.ii.eshop.service.OrderService;
import pl.edu.pw.ii.eshop.service.ProductService;
/**
 * Klasa realizuj¹ca funkcje kontrolera, który obs³uguje zapytania wysy³ane
 * poprzez przegl¹darkê od u¿ytkowników, zwi¹zane z obs³ug¹ klientów.
 * 
 * @author Agnieszka Œwiderska
 * @version 1.0
 */
@Controller
@RequestMapping("/customer")
public class CustomerHomeController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private OrderService orderService;

	/**
	 * Metoda obs³uguj¹ca ¿¹danie /customer/{username}. Zwraca nazwê widoku do
	 * wygenerowania w odpowiedzi. Przy pomocy obiektu implementuj¹cego
	 * interfejs {@link CustomerService} pobierany jest obiekt {@link Customer}
	 * reprezentuj¹cy klienta sklepu. Customer jest dodawany do modelu.
	 * 
	 * @param username
	 *            nazwa u¿ytkownika serwisu dla, którego ma zostaæ wygenerowana
	 *            strona.
	 * @param model
	 *            interfejs, Spring dostarcza implementacjê. Holder dla
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
	 * Metoda obs³uguj¹ca ¿¹danie /customer/editCustomer/{id}. Zwraca nazwê
	 * widoku do wygenerowania w odpowiedzi. Przy pomocy obiektu
	 * implementuj¹cego interfejs {@link CustomerService} pobierany jest obiekt
	 * {@link CustomerInfo} reprezentuj¹cy informacjê o kliencie sklepu o
	 * zadanym id. CustomerInfo jest dodawany do modelu.
	 * 
	 * @param id
	 *            id klienta sklepu
	 *
	 * @param model
	 *            interfejs, Spring dostarcza implementacjê. Holder dla
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
	 * Metoda obs³uguj¹ca ¿¹danie /customer/editCustomer typu POST.
	 * Wykorzystuje {@link CustomerService} do utrwalenia modyfikowanego Klienta
	 * sklepu. Modyfikowane dane s¹ walidowane i w przypadku pozytywnej
	 * walidacji (braku b³êdów walidacji), ¿¹danie jest przekierowywane
	 * doredirect:/customer/{username}. W przeciwnym przypadku zwracana jest
	 * nazwa widoku do wygenerowania w odpowiedzi.
	 * 
	 * @param customer
	 *            Obiekt klasy {@link CustomerInfo}, reprezentuj¹cy informacje o
	 *            kliencie sklepu
	 * @param result
	 *            interfejs rozszerzaj¹cy interfejs umo¿liwiaj¹cy rejestrowanie
	 *            b³êdów, zastosowanie walidatora {@link Valid}.
	 * @param request
	 *            obiekt klasy {@link HttpServletRequest}, reprezentuj¹cy
	 *            rz¹danie HTTP.
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
	 * Metoda obs³uguj¹ca ¿¹danie /customer/orderList/{id} typu GET.
	 * Wykorzystuje implementacjê interfejsu {@link OrderService} do pobrania
	 * listy zamówieñ {@link Order} dla klienta o zadanym id. Lista zamówieñ
	 * jest dodawana do modelu. Metoda zwraca nazwê widoku do wygenerowania w
	 * odpowiedzi.
	 * 
	 * @param id
	 *            id klienta {@link Customer}, dla kórego nalezy pobraæ listê
	 *            zamówieñ.
	 * @param model
	 *            interfejs, Spring dostarcza implementacjê. Holder dla
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
	 * Metoda obs³uguj¹ca ¿¹danie /customer/pay/{id} typu GET. Metoda przy
	 * u¿yciu implementacji interfejsu {@link OrderService} dla zamówienia o id
	 * przekazanym w parametrach wywo³ania, zmienia status na
	 * "PAYMENT_RECEIVED". Nastêpnie pobierana jest lista wszystkich zamówieñ
	 * dla klienta o id zwróconego poprzez wywo³anie
	 * order.getCustomer().getCustomerId(). Lista zamówieñ jest dodawana do
	 * modelu. Rz¹danie jest przekierowywane do
	 * redirect:/customer/orderList/{customerId}
	 * 
	 * @param id
	 *            id zamówienia do op³acenia
	 * @param model
	 *            interfejs, Spring dostarcza implementacjê. Holder dla
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
