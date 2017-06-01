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

/**
 * Klasa realizująca funkcje kontrolera, który obsługuje zapytania wysyłane
 * poprzez przeglądarkę od użytkowników.
 * 
 * @author Łukasz Kruk
 * @version 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminHomeController {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private CustomerService customerService;

	/**
	 * Metoda obsługująca żądanie przeglądarki /admin. Zwraca nazwę widoku do
	 * wygenerowania w odpowiedzi. Widoki znajdują się w /WEB-INF/views/. Widok
	 * jest stroną *.jsp
	 * 
	 * @return nazwa widoku.
	 */
	@RequestMapping
	public String adminPage() {
		return "admin";
	}

	/**
	 * Metoda obsługująca żądanie przeglądarki /admin/productInventory. Metoda
	 * wykorzystuje implementację interfejsu ProductService do pobrania listy
	 * produktów reprezentowanych jako obiekty klasy Product. Lista produktów
	 * jest dodawana do modelu. Zwraca nazwę widoku do wygenerowania odpowiedzi.
	 * 
	 * @param model
	 *            interfejs, Spring dostarcza implementację. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku.
	 * @see Product
	 * @see Model 
	 * @see ProductService 
	 */
	@RequestMapping("/productInventory")
	public String productInventory(Model model) {
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		return "productInventory";
	}

	/**
	 * Metoda obsługująca żądanie przeglądarki
	 * /admin/productListByCategory/{category}. Metoda wykorzystuje
	 * implementację interfejsu ProductService do pobrania listy produktów z
	 * zadaną kategorią. Produkty reprezentowane jako obiekty klasy Product.
	 * Lista produktów jest dodawana do modelu. Metoda Zwraca nazwę widoku do
	 * wygenerowania odpowiedzi.
	 * 
	 * @param category
	 *            Typ wyliczeniowy, definiujący dostępne kategorie.
	 * @param model
	 *            interfejs, Spring dostarcza implementację. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku.
	 * @see Product
	 * @see Model
	 * @see ProductService
	 * @see Categories
	 */
	@RequestMapping("/productListByCategory/{category}")
	public String productInventory(@PathVariable Categories category, Model model) {
		List<Product> products = productService.getProductListByCategory(category.getDescription());
		model.addAttribute("products", products);
		return "productInventory";
	}

	/**
	 * Metoda obsługująca żądanie przeglądarki /admin/customer. Metoda
	 * wykorzystuje implementację interfejsu CustomerService do pobrania listy
	 * klientów sklepu. Klienci są reprezentowani jako obiekty klasy Customer.
	 * Lista klientów jest dodawana do modelu.
	 * Metoda zwraca nazwę widoku do wygenerowania odpowiedzi.
	 * 
	 * @param model
	 *            interfejs, Spring dostarcza implementację. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku.
	 * @see Customer 
	 * @see Model
	 * @see CustomerService
	 */
	@RequestMapping("/customer")
	public String customerInfo(Model model) {
		List<Customer> customers = customerService.getAllCustomers();
		model.addAttribute("customers", customers);
		return "customerInfo";
	}

	/**
	 * Metoda obsługująca żądanie przeglądarki /admin/orderList. Metoda
	 * wykorzystuje implementację interfejsu OrderService do pobrania listy
	 * zamówień klientów sklepu. Zamówienia są reprezentowane jako obiekty klasy Order.
	 * Lista zamówień jest dodawana do modelu.
	 * Metoda zwraca nazwę widoku do wygenerowania odpowiedzi.
	 * 
	 * @param model
	 *            interfejs, Spring dostarcza implementację. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku.
	 * @see Order 
	 * @see Model
	 * @see OrderService
	 */
	@RequestMapping("/orderList")
	public String orderList(Model model) {
		List<Order> orders = orderService.getAllOrders();
		model.addAttribute("orders", orders);
		return "orderList";
	}

	/**
	 * Metoda obsługująca żądanie przeglądarki /admin/orderListByStatus. Metoda
	 * wykorzystuje implementację interfejsu OrderService do pobrania listy
	 * zamówień klientów sklepu w zadanym statusie. Zamówienia są reprezentowane jako obiekty klasy Order.
	 * Lista zamówień jest dodawana do modelu.
	 * Metoda zwraca nazwę widoku do wygenerowania odpowiedzi.
	 * 
	 * @param status Typ wyliczeniowy, reprezentujący możliwe statusy zamówień klientów.
	 * @param model
	 *            interfejs, Spring dostarcza implementację. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku.
	 * @see Order 
	 * @see Model
	 * @see OrderService
	 * @see Status
	 */
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
