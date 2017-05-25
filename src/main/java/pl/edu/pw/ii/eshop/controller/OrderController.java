package pl.edu.pw.ii.eshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.model.CartItem;
import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.Order;
import pl.edu.pw.ii.eshop.model.OrderItem;
import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.service.CartService;
import pl.edu.pw.ii.eshop.service.MailService;
import pl.edu.pw.ii.eshop.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private CartService cartService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private MailService mailService;

	@RequestMapping("{cartId}")
	public String createOrder(@PathVariable("cartId") int cartId) {
		Cart cart = cartService.getCartById(cartId);
		Order customerOrder = new Order(cart);
		customerOrder.setCart(cart);

		Customer customer = cart.getCustomer();
		customerOrder.setCustomer(customer);
		customerOrder.setBillingAddress(customer.getBillingAddress());
		customerOrder.setShippingAddress(customer.getShippingAddress());

		orderService.addOrder(customerOrder);
		return "redirect:/checkout?cartId=" + cartId;
	}

	@RequestMapping("viewOrder/{id}")
	public String viewOrder(@PathVariable int id, Model model) throws Exception {
		Order order = orderService.getOrderById(id);
		model.addAttribute("order", order);

		return "viewOrder";
	}
}
