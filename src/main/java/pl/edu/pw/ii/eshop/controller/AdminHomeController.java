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
 * Klasa realizuj�ca funkcje kontrolera, kt�ry obs�uguje zapytania wysy�ane
 * poprzez przegl�dark� od u�ytkownik�w.
 * 
 * @author �ukasz Kruk
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
	 * Metoda obs�uguj�ca ��danie przegl�darki /admin. Zwraca nazw� widoku do
	 * wygenerowania w odpowiedzi. Widoki znajduj� si� w /WEB-INF/views/. Widok
	 * jest stron� *.jsp
	 * 
	 * @return nazwa widoku.
	 */
	@RequestMapping
	public String adminPage() {
		return "admin";
	}

	/**
	 * Metoda obs�uguj�ca ��danie przegl�darki /admin/productInventory. Metoda
	 * wykorzystuje implementacj� interfejsu ProductService do pobrania listy
	 * produkt�w reprezentowanych jako obiekty klasy Product. Lista produkt�w
	 * jest dodawana do modelu. Zwraca nazw� widoku do wygenerowania odpowiedzi.
	 * 
	 * @param model
	 *            interfejs, Spring dostarcza implementacj�. Holder dla
	 *            atrybut�w modelu w MVC.
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
	 * Metoda obs�uguj�ca ��danie przegl�darki
	 * /admin/productListByCategory/{category}. Metoda wykorzystuje
	 * implementacj� interfejsu ProductService do pobrania listy produkt�w z
	 * zadan� kategori�. Produkty reprezentowane jako obiekty klasy Product.
	 * Lista produkt�w jest dodawana do modelu. Metoda Zwraca nazw� widoku do
	 * wygenerowania odpowiedzi.
	 * 
	 * @param category
	 *            Typ wyliczeniowy, definiuj�cy dost�pne kategorie.
	 * @param model
	 *            interfejs, Spring dostarcza implementacj�. Holder dla
	 *            atrybut�w modelu w MVC.
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
	 * Metoda obs�uguj�ca ��danie przegl�darki /admin/customer. Metoda
	 * wykorzystuje implementacj� interfejsu CustomerService do pobrania listy
	 * klient�w sklepu. Klienci s� reprezentowani jako obiekty klasy Customer.
	 * Lista klient�w jest dodawana do modelu.
	 * Metoda zwraca nazw� widoku do wygenerowania odpowiedzi.
	 * 
	 * @param model
	 *            interfejs, Spring dostarcza implementacj�. Holder dla
	 *            atrybut�w modelu w MVC.
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
	 * Metoda obs�uguj�ca ��danie przegl�darki /admin/orderList. Metoda
	 * wykorzystuje implementacj� interfejsu OrderService do pobrania listy
	 * zam�wie� klient�w sklepu. Zam�wienia s� reprezentowane jako obiekty klasy Order.
	 * Lista zam�wie� jest dodawana do modelu.
	 * Metoda zwraca nazw� widoku do wygenerowania odpowiedzi.
	 * 
	 * @param model
	 *            interfejs, Spring dostarcza implementacj�. Holder dla
	 *            atrybut�w modelu w MVC.
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
	 * Metoda obs�uguj�ca ��danie przegl�darki /admin/orderListByStatus. Metoda
	 * wykorzystuje implementacj� interfejsu OrderService do pobrania listy
	 * zam�wie� klient�w sklepu w zadanym statusie. Zam�wienia s� reprezentowane jako obiekty klasy Order.
	 * Lista zam�wie� jest dodawana do modelu.
	 * Metoda zwraca nazw� widoku do wygenerowania odpowiedzi.
	 * 
	 * @param status Typ wyliczeniowy, reprezentuj�cy mo�liwe statusy zam�wie� klient�w.
	 * @param model
	 *            interfejs, Spring dostarcza implementacj�. Holder dla
	 *            atrybut�w modelu w MVC.
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
