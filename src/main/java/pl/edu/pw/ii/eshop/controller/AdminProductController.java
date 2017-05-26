package pl.edu.pw.ii.eshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.pw.ii.eshop.model.Order;
import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.model.ProductInfo;
import pl.edu.pw.ii.eshop.model.Status;
import pl.edu.pw.ii.eshop.service.OrderService;
import pl.edu.pw.ii.eshop.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@RequestMapping("/product/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		product.setCategory("ceramika");
		product.setCondition("Nowy");
		product.setStatus("Aktywny");

		model.addAttribute("product", product);

		return "addProduct";
	}

	@RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute("product") ProductInfo product, BindingResult result,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "addProduct";
		}

		productService.addProduct(product);
		return "redirect:/admin/productInventory";
	}

	@RequestMapping("/product/editProduct/{id}")
	public String editProduct(@PathVariable("id") int id, Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute(product);
		return "editProduct";
	}

	@RequestMapping(value = "/product/editProduct", method = RequestMethod.POST)
	public String editProduct(@Valid @ModelAttribute("product") ProductInfo product, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "editProduct";
		}

		productService.editProduct(product);
		return "redirect:/admin/productInventory";

	}

	@RequestMapping("/product/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {

		productService.deleteProduct(productService.getProductById(id));

		return "redirect:/admin/productInventory";
	}

	@RequestMapping(value = "/order/changeStatus", method = RequestMethod.POST)
	public String changeOrderStatus(@Valid @ModelAttribute("order") Order order, BindingResult result,
			HttpServletRequest request) {
		Order ord = orderService.getOrderById(order.getOrderId());
		String status = order.getStatus();

		switch (status) {
		case "NOWY":
			orderService.setNewStaus(ord);
			break;
		case "ZAP£ACONE":
			orderService.setPaymentReceivedStatus(ord);
			break;
		case "WYS£ANE":
			orderService.setSentStatus(ord);
			break;
		case "ZAKOÑCZONE":
			orderService.setCompletedStaus(ord);
			break;
		default:
			break;
		}
		return "redirect:/order/viewOrder/" + order.getOrderId();
	}
}
