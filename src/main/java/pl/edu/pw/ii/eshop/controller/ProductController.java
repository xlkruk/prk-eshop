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
 * Klasa realizuj¹ca funkcje kontrolera, który obs³uguje zapytania wysy³ane
 * poprzez przegl¹darkê od u¿ytkowników.
 * 
 * @author Agnieszka Œwiderska
 * @version 1.0
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * Metoda obs³uguje ¿¹danie /product/productList. Wykorzystuje implementacjê
	 * interfejsu {@link ProductService} do pobrania listy dostêpnych produktów
	 * {@link Product}. Lista produktów jest dodawana do modelu jako atrybut.
	 * Metoda zwraca widok generowany w odpowiedzi
	 * 
	 * @param model
	 *            interfejs, Spring dostarcza implementacjê. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku.
	 */
	@RequestMapping("/productList")
	public String getProducts(Model model) {
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		return "productList";
	}

	/**
	 * Metoda obs³uguje ¿¹danie /product/viewProduct/{id}. Wykorzystuje
	 * implementacjê interfejsu {@link ProductService} do pobrania produktu
	 * {@link Product} o zadanym w parametrach wywo³ania id. Produkt
	 * {@link Product} jest dodawany do modelu jako atrybut. Metoda zwraca widok
	 * generowany w odpowiedzi
	 * 
	 * @param id
	 *            id produktu
	 * @param model
	 *            interfejs, Spring dostarcza implementacjê. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku.
	 */
	@RequestMapping("/viewProduct/{id}")
	public String viewProduct(@PathVariable int id, Model model) throws Exception {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "viewProduct";
	}

	/**
	 * Metoda obs³uguje ¿¹danie /product/productListByCategory/{category}.
	 * Wykorzystuje implementacjê interfejsu {@link ProductService} do pobrania
	 * listy dostêpnych produktów {@link Product} w zadanej kategorii. Lista
	 * produktów jest dodawana do modelu jako atrybut. Metoda zwraca widok
	 * generowany w odpowiedzi
	 * 
	 * @param category
	 *            Typ wyliczeniowy {@link Categories}, zawieraj¹cy kategorie
	 *            produktów.
	 * @param model
	 *            interfejs, Spring dostarcza implementacjê. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku.
	 */
	@RequestMapping("/productListByCategory/{category}")
	public String productListByStatus(@PathVariable Categories category, Model model) {
		List<Product> products = productService.getProductListByCategory(category.getDescription());
		model.addAttribute("products", products);
		return "productList";
	}
}
