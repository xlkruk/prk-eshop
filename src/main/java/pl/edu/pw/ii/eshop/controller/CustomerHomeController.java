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
 * Klasa realizuj�ca funkcje kontrolera, kt�ry obs�uguje zapytania wysy�ane
 * poprzez przegl�dark� od u�ytkownik�w, zwi�zane z obs�ug� klient�w.
 * 
 * @author Agnieszka �widerska
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
	 * Metoda obs�uguj�ca ��danie /customer/{username}. Zwraca nazw� widoku do
	 * wygenerowania w odpowiedzi. Przy pomocy obiektu implementuj�cego
	 * interfejs {@link CustomerService} pobierany jest obiekt {@link Customer}
	 * reprezentuj�cy klienta sklepu. Customer jest dodawany do modelu.
	 * 
	 * @param username
	 *            nazwa u�ytkownika serwisu dla, kt�rego ma zosta� wygenerowana
	 *            strona.
	 * @param model
	 *            interfejs, Spring dostarcza implementacj�. Holder dla
	 *            atrybut�w modelu w MVC.
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
	 * Metoda obs�uguj�ca ��danie /customer/editCustomer/{id}. Zwraca nazw�
	 * widoku do wygenerowania w odpowiedzi. Przy pomocy obiektu
	 * implementuj�cego interfejs {@link CustomerService} pobierany jest obiekt
	 * {@link CustomerInfo} reprezentuj�cy informacj� o kliencie sklepu o
	 * zadanym id. CustomerInfo jest dodawany do modelu.
	 * 
	 * @param id
	 *            id klienta sklepu
	 *
	 * @param model
	 *            interfejs, Spring dostarcza implementacj�. Holder dla
	 *            atrybut�w modelu w MVC.
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
	 * Metoda obs�uguj�ca ��danie /customer/editCustomer typu POST.
	 * Wykorzystuje {@link CustomerService} do utrwalenia modyfikowanego Klienta
	 * sklepu. Modyfikowane dane s� walidowane i w przypadku pozytywnej
	 * walidacji (braku b��d�w walidacji), ��danie jest przekierowywane
	 * doredirect:/customer/{username}. W przeciwnym przypadku zwracana jest
	 * nazwa widoku do wygenerowania w odpowiedzi.
	 * 
	 * @param customer
	 *            Obiekt klasy {@link CustomerInfo}, reprezentuj�cy informacje o
	 *            kliencie sklepu
	 * @param result
	 *            interfejs rozszerzaj�cy interfejs umo�liwiaj�cy rejestrowanie
	 *            b��d�w, zastosowanie walidatora {@link Valid}.
	 * @param request
	 *            obiekt klasy {@link HttpServletRequest}, reprezentuj�cy
	 *            rz�danie HTTP.
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
	 * Metoda obs�uguj�ca ��danie /customer/orderList/{id} typu GET.
	 * Wykorzystuje implementacj� interfejsu {@link OrderService} do pobrania
	 * listy zam�wie� {@link Order} dla klienta o zadanym id. Lista zam�wie�
	 * jest dodawana do modelu. Metoda zwraca nazw� widoku do wygenerowania w
	 * odpowiedzi.
	 * 
	 * @param id
	 *            id klienta {@link Customer}, dla k�rego nalezy pobra� list�
	 *            zam�wie�.
	 * @param model
	 *            interfejs, Spring dostarcza implementacj�. Holder dla
	 *            atrybut�w modelu w MVC.
	 * @return nazwa widoku.
	 */
	@RequestMapping("/orderList/{id}")
	public String orderList(@PathVariable int id, Model model) {
		List<Order> orders = orderService.getOrdersByCustomerId(id);
		model.addAttribute("orders", orders);
		return "customerOrderList";
	}

	/**
	 * Metoda obs�uguj�ca ��danie /customer/pay/{id} typu GET. Metoda przy
	 * u�yciu implementacji interfejsu {@link OrderService} dla zam�wienia o id
	 * przekazanym w parametrach wywo�ania, zmienia status na
	 * "PAYMENT_RECEIVED". Nast�pnie pobierana jest lista wszystkich zam�wie�
	 * dla klienta o id zwr�conego poprzez wywo�anie
	 * order.getCustomer().getCustomerId(). Lista zam�wie� jest dodawana do
	 * modelu. Rz�danie jest przekierowywane do
	 * redirect:/customer/orderList/{customerId}
	 * 
	 * @param id
	 *            id zam�wienia do op�acenia
	 * @param model
	 *            interfejs, Spring dostarcza implementacj�. Holder dla
	 *            atrybut�w modelu w MVC.
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
