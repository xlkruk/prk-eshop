package pl.edu.pw.ii.eshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.service.CustomerService;

/**
 * Klasa realizująca funkcje kontrolera, który obsługuje zapytania wysyłane
 * poprzez przeglądarkę od użytkowników.
 * 
 * @author Agnieszka Świderska
 * @version 1.0
 */
@Controller
public class RegisterController {

	@Autowired
	private CustomerService customerService;

	/**
	 * Metoda obsługująca żądanie /register typu GET. Tworzy nową instancję
	 * obieku {@link Customer}, reprezentującego Klienta sklepu. Następnie
	 * dodaje go do modeku jako atrybut. Metoda zwraca nazwę widoku generowanego
	 * w odpoweidzi.
	 * 
	 * @param model
	 *            interfejs, Spring dostarcza implementację. Holder dla
	 *            atrybut�w modelu w MVC.
	 * @return nazwa widoku.
	 */
	@RequestMapping("/register")
	public String register(Model model) {
		Customer customer = new Customer();

		model.addAttribute("customer", customer);
		return "registerCustomer";
	}

	/**
	 * Metoda obsąuguje żądanie /register typu POST. Dane wprowadzone przez
	 * klienta są walidowane i w przypadku błędów, metoda zwraca nazwę widoku
	 * registerCustomer. Walidowane są dane wprowadzoe w formularzu oraz
	 * werifikowana unikalność adresu email i nazwy użytkownika. W przypadku
	 * pozytywnej weryfikacji, nowy klient {@link Customer} jest utrwalany przy
	 * użyciu implementacji interfejsu {@link CustomerService}. Metoda zwraca
	 * nazwę widoku, generowanego w odpowiedzi.
	 * 
	 * @param customer
	 *            nowy klient reprezentowany jako obiekt klasy {@link Customer}
	 * @param result
	 *            interfejs rozszerzający interfejs umożliwiający rejestrowanie
	 *            błędów, zastosowanie walidatora {@link Valid}.
	 * @param model
	 *            interfejs, Spring dostarcza implementację. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku.
	 * @see Customer
	 * @see BindingResult
	 * @see Model
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "registerCustomer";
		}

		List<Customer> customers = customerService.getAllCustomers();
		for (Customer cust : customers) {
			if (customer.getCustomerEmail().equals(cust.getCustomerEmail())) {
				model.addAttribute("emailMsg", "Istnieje użytkownik z tym adresem email.");
				return "registerCustomer";
			}

			if (customer.getUsername().equals(cust.getUsername())) {
				model.addAttribute("usernameMsg", "Istnieje użytkownik z takim loginem.");
				return "registerCustomer";
			}
		}
		customerService.addCustomer(customer);

		return "registerSuccess";
	}
}
