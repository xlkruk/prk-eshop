package pl.edu.pw.ii.eshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
 * Klasa realizuj¹ca funkcje kontrolera, który obs³uguje zapytania wysy³ane
 * poprzez przegl¹darkê od u¿ytkowników.
 * 
 * @author Agnieszka Œwiderska
 * @version 1.0
 */
@Controller
public class RegisterController {

	@Autowired
	private CustomerService customerService;

	/**
	 * Metoda obs³uguj¹ca ¿¹danie /register typu GET. Tworzy now¹ instancjê
	 * obieku {@link Customer}, reprezentuj¹cego Klienta sklepu. Nastêpnie
	 * dodaje go do modeku jako atrybut. Metoda zwraca nazwê widoku generowanego
	 * w odpoweidzi.
	 * 
	 * @param model
	 *            interfejs, Spring dostarcza implementacjê. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku.
	 */
	@RequestMapping("/register")
	public String register(Model model) {
		Customer customer = new Customer();

		model.addAttribute("customer", customer);
		return "registerCustomer";
	}

	/**
	 * Metoda obs³uguje ¿¹danie /register typu POST. Dane wprowadzone przez
	 * klienta s¹ walidowane i w przypadku b³êdów, metoda zwraca nazwê widoku
	 * registerCustomer. Walidowane s¹ dane wprowadzoe w formularzu oraz
	 * werifikowana unikalnoœæ adresu email i nazwy u¿ytkownika. W przypadku
	 * pozytywnej weryfikacji, nowy klient {@link Customer} jest utrwalany przy
	 * u¿yciu implementacji interfejsu {@link CustomerService}. Metoda zwraca
	 * nazwê widoku, generowanego w odpowiedzi.
	 * 
	 * @param customer
	 *            nowy klient reprezentowany jako obiekt klasy {@link Customer}
	 * @param result
	 *            interfejs rozszerzaj¹cy interfejs umo¿liwiaj¹cy rejestrowanie
	 *            b³êdów, zastosowanie walidatora {@link Valid}.
	 * @param model
	 *            interfejs, Spring dostarcza implementacjê. Holder dla
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
				model.addAttribute("emailMsg", "Istnieje u¿ytkownik z tym adresem email.");
				return "registerCustomer";
			}

			if (customer.getUsername().equals(cust.getUsername())) {
				model.addAttribute("usernameMsg", "Istnieje u¿ytkownik z takim loginem.");
				return "registerCustomer";
			}
		}
		customerService.addCustomer(customer);

		return "registerSuccess";
	}
}
