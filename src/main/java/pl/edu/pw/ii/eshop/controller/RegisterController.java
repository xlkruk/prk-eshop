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
 * Klasa realizuj�ca funkcje kontrolera, kt�ry obs�uguje zapytania wysy�ane
 * poprzez przegl�dark� od u�ytkownik�w.
 * 
 * @author Agnieszka �widerska
 * @version 1.0
 */
@Controller
public class RegisterController {

	@Autowired
	private CustomerService customerService;

	/**
	 * Metoda obs�uguj�ca ��danie /register typu GET. Tworzy now� instancj�
	 * obieku {@link Customer}, reprezentuj�cego Klienta sklepu. Nast�pnie
	 * dodaje go do modeku jako atrybut. Metoda zwraca nazw� widoku generowanego
	 * w odpoweidzi.
	 * 
	 * @param model
	 *            interfejs, Spring dostarcza implementacj�. Holder dla
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
	 * Metoda obs�uguje ��danie /register typu POST. Dane wprowadzone przez
	 * klienta s� walidowane i w przypadku b��d�w, metoda zwraca nazw� widoku
	 * registerCustomer. Walidowane s� dane wprowadzoe w formularzu oraz
	 * werifikowana unikalno�� adresu email i nazwy u�ytkownika. W przypadku
	 * pozytywnej weryfikacji, nowy klient {@link Customer} jest utrwalany przy
	 * u�yciu implementacji interfejsu {@link CustomerService}. Metoda zwraca
	 * nazw� widoku, generowanego w odpowiedzi.
	 * 
	 * @param customer
	 *            nowy klient reprezentowany jako obiekt klasy {@link Customer}
	 * @param result
	 *            interfejs rozszerzaj�cy interfejs umo�liwiaj�cy rejestrowanie
	 *            b��d�w, zastosowanie walidatora {@link Valid}.
	 * @param model
	 *            interfejs, Spring dostarcza implementacj�. Holder dla
	 *            atrybut�w modelu w MVC.
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
				model.addAttribute("emailMsg", "Istnieje u�ytkownik z tym adresem email.");
				return "registerCustomer";
			}

			if (customer.getUsername().equals(cust.getUsername())) {
				model.addAttribute("usernameMsg", "Istnieje u�ytkownik z takim loginem.");
				return "registerCustomer";
			}
		}
		customerService.addCustomer(customer);

		return "registerSuccess";
	}
}
