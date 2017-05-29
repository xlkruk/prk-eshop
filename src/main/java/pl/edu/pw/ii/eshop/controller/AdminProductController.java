package pl.edu.pw.ii.eshop.controller;

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

import pl.edu.pw.ii.eshop.model.Categories;
import pl.edu.pw.ii.eshop.model.Order;
import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.model.ProductInfo;
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
public class AdminProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	/**
	 * Metoda obs³uguj¹ca ¿¹danie przegl¹darki /admin/product/addProduct.
	 * Zwraca nazwê widoku do wygenerowania odpowiedzi.
	 * 
	 * @param model
	 *            interfejs, Spring dostarcza implementacjê. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku.
	 * @see Product
	 * @see Model
	 */
	@RequestMapping("/product/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		product.setCategory(Categories.CERAMICS.getDescription());

		model.addAttribute("product", product);

		return "addProduct";
	}

	/**
	 * Metoda obs³uguj¹ca ¿¹danie przegl¹darki /admin/product/addProduct przy
	 * pomocy metody POST. Metoda wykorzystuje implementacjê interfejsu
	 * ProductService do utrwalenia nowego produktu reprezentowanego jako obiekt
	 * klasy Product. W przypadku udanego pobrania produktu do edycji, ¿¹danie
	 * jest przekierowywane do /admin/productInventory. W przeciwnym wypadku
	 * zwracany jest widok addProduct
	 * 
	 * @param product
	 *            obiekt klasy {@link ProductInfo}. typ opakowuj¹cy obiekty
	 *            klasy {@link Product}. Przechowuje informacje o produkcie.
	 * @param result
	 *            interfejs rozszerzaj¹cy interfejs umo¿liwiaj¹cy rejestrowanie
	 *            b³êdów, zastosowanie walidatora {@link Valid}.
	 * @param request
	 *            obiekt klasy {@link HttpServletRequest}, reprezentuj¹cy
	 *            rz¹danie HTTP.
	 * @return nazwa widoku.
	 * @see Product
	 * @see BindingResult
	 * @see HttpServletRequest
	 * @see ProductService
	 */
	@RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute("product") ProductInfo product, BindingResult result,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "addProduct";
		}

		try {
			productService.addProduct(product);
		} catch (Exception e) {
			return "addProduct";
		}
		return "redirect:/admin/productInventory";
	}

	/**
	 * Metoda obs³uguj¹ca ¿¹danie przegl¹darki GET /admin/editProduct/{id}.
	 * Metoda wykorzystuje implementacjê interfejsu ProductService do pobrania
	 * produktu o zadanym id. Produkt reprezentowany jako obiekt klasy Product.
	 * Produkt produktów jest dodawany do modelu. Metoda zwraca nazwê widoku do
	 * wygenerowania odpowiedzi.
	 * 
	 * @param id
	 *            id produktu do edycji
	 * @param model
	 *            interfejs, Spring dostarcza implementacjê. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku.
	 * @see Product
	 * @see Model
	 * @see ProductService
	 */
	@RequestMapping("/product/editProduct/{id}")
	public String editProduct(@PathVariable("id") int id, Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute(product);
		return "editProduct";
	}

	/**
	 * Metoda obs³uguj¹ca ¿¹danie przegl¹darki /admin/product/editProduct przy
	 * pomocy metody POST. Metoda wykorzystuje implementacjê interfejsu
	 * ProductService do utrwalenia modyfikowanego produktu reprezentowanego
	 * jako obiekt klasy Product. W przypadku braku b³êdów walidacji, product
	 * jest utrwalany i ¿¹danie jest przekierowywane do /order/viewOrder/{id}.
	 * 
	 * @param order
	 *            obiekt klasy {@link Order}. Encja reprezentuj¹ca zamówienie
	 *            klienta
	 * @param result
	 *            interfejs rozszerzaj¹cy interfejs umo¿liwiaj¹cy rejestrowanie
	 *            b³êdów, zastosowanie walidatora {@link Valid}.
	 * @param request
	 *            obiekt klasy {@link HttpServletRequest}, reprezentuj¹cy
	 *            rz¹danie HTTP.
	 * @return nazwa widoku.
	 * @see Product
	 * @see BindingResult
	 * @see HttpServletRequest
	 * @see ProductService
	 */
	@RequestMapping(value = "/product/editProduct", method = RequestMethod.POST)
	public String editProduct(@Valid @ModelAttribute("product") ProductInfo product, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "editProduct";
		}

		productService.editProduct(product);
		return "redirect:/admin/productInventory";

	}

	/**
	 * Metoda obs³uguj¹ca ¿¹danie przegl¹darki
	 * /admin/product/deleteProduct/{id} przy pomocy metody GET. Metoda
	 * wykorzystuje implementacjê interfejsu ProductService do usuniêcia
	 * produktu o zadanym id, reprezentowanego jako obiekt klasy Product.
	 * ¿¹danie jest przekierowywane do /admin/productInventory.
	 * 
	 * @param id
	 *            id produktu do usuniêcia
	 * @param request
	 *            obiekt klasy {@link HttpServletRequest}, reprezentuj¹cy
	 *            rz¹danie HTTP.
	 * @return nazwa widoku.
	 * @see Product
	 * @see HttpServletRequest
	 * @see ProductService
	 */
	@RequestMapping("/product/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {

		productService.deleteProduct(productService.getProductById(id));

		return "redirect:/admin/productInventory";
	}

	/**
	 * Metoda obs³uguj¹ca ¿¹danie przegl¹darki /admin/order/changeStatus przy
	 * pomocy metody POST. Metoda wykorzystuje implementacjê interfejsu
	 * OrderService do zmiany statusu zamówienia reprezentowanego jako obiekt
	 * klasy {@link Order}. ¯¹danie jest przekierowywane do
	 * /admin/productInventory. W przeciwnym wypadku zwracany jest widok
	 * editProduct
	 * 
	 * @param order
	 *            obiekt klasy {@link Order}. Encaj reprezentuj¹ca zamówienie
	 *            klienta
	 * @param result
	 *            interfejs rozszerzaj¹cy interfejs umo¿liwiaj¹cy rejestrowanie
	 *            b³êdów, zastosowanie walidatora {@link Valid}.
	 * @param request
	 *            obiekt klasy {@link HttpServletRequest}, reprezentuj¹cy
	 *            rz¹danie HTTP.
	 * @return nazwa widoku.
	 * @see Order
	 * @see BindingResult
	 * @see HttpServletRequest
	 * @see OrderService
	 */
	@RequestMapping(value = "/order/changeStatus", method = RequestMethod.POST)
	public String changeOrderStatus(@Valid @ModelAttribute("order") Order order, BindingResult result,
			HttpServletRequest request) {
		Order ord = orderService.getOrderById(order.getOrderId());
		String status = order.getStatus();

		switch (status) {
		case "NEW":
			orderService.setNewStaus(ord);
			break;
		case "PAYED":
			orderService.setPaymentReceivedStatus(ord);
			break;
		case "SENT":
			orderService.setSentStatus(ord);
			break;
		case "COMPLETED":
			orderService.setCompletedStaus(ord);
			break;
		default:
			break;
		}
		return "redirect:/order/viewOrder/" + order.getOrderId();
	}
}
