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
 * Klasa realizuj¹ca funkcje kontrolera, który obs³uguje zapytania wysy³ane
 * poprzez przegl¹darkê od u¿ytkowników.
 * 
 * @author £ukasz Kruk
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
	 * Metoda obs³uguj¹ca ¿¹danie przegl¹darki /admin. Zwraca nazwê widoku do
	 * wygenerowania w odpowiedzi. Widoki znajduj¹ siê w /WEB-INF/views/. Widok
	 * jest stron¹ *.jsp
	 * 
	 * @return nazwa widoku.
	 */
	@RequestMapping
	public String adminPage() {
		return "admin";
	}

	/**
	 * Metoda obs³uguj¹ca ¿¹danie przegl¹darki /admin/productInventory. Metoda
	 * wykorzystuje implementacjê interfejsu ProductService do pobrania listy
	 * produktów reprezentowanych jako obiekty klasy Product. Lista produktów
	 * jest dodawana do modelu. Zwraca nazwê widoku do wygenerowania odpowiedzi.
	 * 
	 * @param model
	 *            interfejs, Spring dostarcza implementacjê. Holder dla
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
	 * Metoda obs³uguj¹ca ¿¹danie przegl¹darki
	 * /admin/productListByCategory/{category}. Metoda wykorzystuje
	 * implementacjê interfejsu ProductService do pobrania listy produktów z
	 * zadan¹ kategori¹. Produkty reprezentowane jako obiekty klasy Product.
	 * Lista produktów jest dodawana do modelu. Metoda Zwraca nazwê widoku do
	 * wygenerowania odpowiedzi.
	 * 
	 * @param category
	 *            Typ wyliczeniowy, definiuj¹cy dostêpne kategorie.
	 * @param model
	 *            interfejs, Spring dostarcza implementacjê. Holder dla
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
	 * Metoda obs³uguj¹ca ¿¹danie przegl¹darki /admin/customer. Metoda
	 * wykorzystuje implementacjê interfejsu CustomerService do pobrania listy
	 * klientów sklepu. Klienci s¹ reprezentowani jako obiekty klasy Customer.
	 * Lista klientów jest dodawana do modelu.
	 * Metoda zwraca nazwê widoku do wygenerowania odpowiedzi.
	 * 
	 * @param model
	 *            interfejs, Spring dostarcza implementacjê. Holder dla
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
	 * Metoda obs³uguj¹ca ¿¹danie przegl¹darki /admin/orderList. Metoda
	 * wykorzystuje implementacjê interfejsu OrderService do pobrania listy
	 * zamówieñ klientów sklepu. Zamówienia s¹ reprezentowane jako obiekty klasy Order.
	 * Lista zamówieñ jest dodawana do modelu.
	 * Metoda zwraca nazwê widoku do wygenerowania odpowiedzi.
	 * 
	 * @param model
	 *            interfejs, Spring dostarcza implementacjê. Holder dla
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
	 * Metoda obs³uguj¹ca ¿¹danie przegl¹darki /admin/orderListByStatus. Metoda
	 * wykorzystuje implementacjê interfejsu OrderService do pobrania listy
	 * zamówieñ klientów sklepu w zadanym statusie. Zamówienia s¹ reprezentowane jako obiekty klasy Order.
	 * Lista zamówieñ jest dodawana do modelu.
	 * Metoda zwraca nazwê widoku do wygenerowania odpowiedzi.
	 * 
	 * @param status Typ wyliczeniowy, reprezentuj¹cy mo¿liwe statusy zamówieñ klientów.
	 * @param model
	 *            interfejs, Spring dostarcza implementacjê. Holder dla
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
