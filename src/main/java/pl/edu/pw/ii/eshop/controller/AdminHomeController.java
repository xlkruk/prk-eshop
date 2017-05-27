package pl.edu.pw.ii.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.edu.pw.ii.eshop.model.Categories;
import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.Order;
import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.model.Status;
import pl.edu.pw.ii.eshop.service.CustomerService;
import pl.edu.pw.ii.eshop.service.OrderService;
import pl.edu.pw.ii.eshop.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private CustomerService customerService;

	@RequestMapping
	public String adminPage() {
		return "admin";
	}

	@RequestMapping("/productInventory")
	public String productInventory(Model model) {
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		return "productInventory";
	}

	@RequestMapping("/productListByCategory/{category}")
	public String productInventory(@PathVariable Categories category, Model model) {
		List<Product> products = productService.getProductListByCategory(category.getDescription());
		model.addAttribute("products", products);
		return "productInventory";
	}

	@RequestMapping("/customer")
	public String customerInfo(Model model) {
		List<Customer> customers = customerService.getAllCustomers();
		model.addAttribute("customers", customers);
		return "customerInfo";
	}

	@RequestMapping("/orderList")
	public String orderList(Model model) {
		List<Order> orders = orderService.getAllOrders();
		model.addAttribute("orders", orders);
		return "orderList";
	}

	@RequestMapping("/orderListByStatus/{status}")
	public String orderListByStatus(@PathVariable Status status, Model model) {
		try {
			List<Order> orders = orderService.getOrdersByStatus(status.getDescription());
			model.addAttribute("orders", orders);
		} catch (Exception e) {
		}
		return "orderList";
	}
}
