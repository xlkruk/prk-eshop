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

@Controller
public class RegisterController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/register")
	public String register(Model model) {
		Customer customer = new Customer();

		model.addAttribute("customer", customer);
		return "registerCustomer";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "registerCustomer";
		}
		
		List<Customer> customers = customerService.getAllCustomers();
		for(Customer cust : customers){
			if(customer.getCustomerEmail().equals(cust.getCustomerEmail())){
				model.addAttribute("emailMsg", "Istnieje u¿ytkownik z tym adresem email.");
				return "registerCustomer";
			}
			
			if(customer.getUsername().equals(cust.getUsername())){
				model.addAttribute("usernameMsg", "Istnieje u¿ytkownik z takim loginem.");
				return "registerCustomer";
			}
		}
		customerService.addCustomer(customer);

		return "registerSuccess";
	}
}
