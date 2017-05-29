package pl.edu.pw.ii.eshop.controller;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.edu.pw.ii.eshop.model.Order;
import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.service.ProductService;
import pl.edu.pw.ii.eshop.model.Categories;

/**
 * Klasa realizuj�ca funkcje kontrolera, kt�ry obs�uguje zapytania wysy�ane
 * poprzez przegl�dark� od u�ytkownik�w.
 * 
 * @author Agnieszka �widerska
 * @version 1.0
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * Metoda obs�uguje ��danie /product/productList. Wykorzystuje implementacj�
	 * interfejsu {@link ProductService} do pobrania listy dost�pnych produkt�w
	 * {@link Product}. Lista produkt�w jest dodawana do modelu jako atrybut.
	 * Metoda zwraca widok generowany w odpowiedzi
	 * 
	 * @param model
	 *            interfejs, Spring dostarcza implementacj�. Holder dla
	 *            atrybut�w modelu w MVC.
	 * @return nazwa widoku.
	 */
	@RequestMapping("/productList")
	public String getProducts(Model model) {
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		return "productList";
	}

	/**
	 * Metoda obs�uguje ��danie /product/viewProduct/{id}. Wykorzystuje
	 * implementacj� interfejsu {@link ProductService} do pobrania produktu
	 * {@link Product} o zadanym w parametrach wywo�ania id. Produkt
	 * {@link Product} jest dodawany do modelu jako atrybut. Metoda zwraca widok
	 * generowany w odpowiedzi
	 * 
	 * @param id
	 *            id produktu
	 * @param model
	 *            interfejs, Spring dostarcza implementacj�. Holder dla
	 *            atrybut�w modelu w MVC.
	 * @return nazwa widoku.
	 */
	@RequestMapping("/viewProduct/{id}")
	public String viewProduct(@PathVariable int id, Model model) throws Exception {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "viewProduct";
	}

	/**
	 * Metoda obs�uguje ��danie /product/productListByCategory/{category}.
	 * Wykorzystuje implementacj� interfejsu {@link ProductService} do pobrania
	 * listy dost�pnych produkt�w {@link Product} w zadanej kategorii. Lista
	 * produkt�w jest dodawana do modelu jako atrybut. Metoda zwraca widok
	 * generowany w odpowiedzi
	 * 
	 * @param category
	 *            Typ wyliczeniowy {@link Categories}, zawieraj�cy kategorie
	 *            produkt�w.
	 * @param model
	 *            interfejs, Spring dostarcza implementacj�. Holder dla
	 *            atrybut�w modelu w MVC.
	 * @return nazwa widoku.
	 */
	@RequestMapping("/productListByCategory/{category}")
	public String productListByStatus(@PathVariable Categories category, Model model) {
		List<Product> products = productService.getProductListByCategory(category.getDescription());
		model.addAttribute("products", products);
		return "productList";
	}
}
