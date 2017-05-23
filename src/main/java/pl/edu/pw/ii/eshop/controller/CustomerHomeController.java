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

@Controller
@RequestMapping("/customer")
public class CustomerHomeController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private OrderService orderService;

	@RequestMapping("{username}")
	public String customerPage(@PathVariable String username, Model model) {
		Customer customer = customerService.getCustomerByUsername(username);
		model.addAttribute("customer", customer);
		return "customer";
	}

	@RequestMapping("/editCustomer/{id}")
	public String editProduct(@PathVariable("id") int id, Model model) {
		Customer customer = customerService.getCustomerById(id);
		CustomerInfo customerInfo = new CustomerInfo(customer);
		System.out.println("@@@@@@@@@@@$$$$$$" + customer.getCustomerId());
		System.out.println("@@@@@@@@@@@$$$$$$" + customerInfo.getCustomerId());
		model.addAttribute("customer", customerInfo);
		return "editCustomer";
	}

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

	/*
	 * @RequestMapping("/customerManagement/{id}") public String
	 * customerManagement(@PathVariable int id, Model model){ Customer customer
	 * = customerService.getCustomerById(id); model.addAttribute("customer",
	 * customer); return "editCustomer"; }
	 */

	@RequestMapping("/orderList/{id}")
	public String orderList(@PathVariable int id, Model model) {
		List<Order> orders = orderService.getOrdersByCustomerId(id);
		model.addAttribute("orders", orders);
		return "customerOrderList";
	}

	@RequestMapping("/pay/{id}")
	public String payForOrder(@PathVariable int id, Model model) {
		Order order = orderService.getOrderById(id);
		orderService.setPaymentReceivedStatus(order);

		List<Order> orders = orderService.getOrdersByCustomerId(id);
		model.addAttribute("orders", orders);
		return "redirect:/customer/orderList/" + order.getCustomer().getCustomerId();
	}
}
