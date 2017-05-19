package pl.edu.pw.ii.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.Order;
import pl.edu.pw.ii.eshop.model.Product;
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
	public String customerPage(@PathVariable String username, Model model){
		Customer customer = customerService.getCustomerByUsername(username);
		model.addAttribute("customer", customer);
		return "customer";
	}
	
	
	@RequestMapping("/customerManagement/{id}")
	public String customerManagement(@PathVariable int id, Model model){
		return "customerManagement";
	}
	
	@RequestMapping("/orderList/{id}")
	public String orderList(@PathVariable int id, Model model){
		List<Order> orders = orderService.getOrdersByCustomerId(id);
		model.addAttribute("orders", orders);
		return "customerOrderList";
	}
}
