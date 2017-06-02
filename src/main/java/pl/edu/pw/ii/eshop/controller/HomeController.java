package pl.edu.pw.ii.eshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import pl.edu.pw.ii.eshop.dao.ProductDao;
import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.service.ProductService;

/**
 * Klasa realizująca funkcje kontrolera, który obsługuje zapytania wysyłane
 * poprzez przeglądarkę od użytkowników.
 * 
 * @author Krzysztof Trybus
 * @version 1.0
 */
@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	/**
	 * Metoda obsługująca żądanie / typu GET. zwraca nazwę widoku do
	 * wygenerowania
	 * 
	 * @return nazwa widoku.
	 */
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	/**
	 * Metoda obsługująca żądanie /contact typu GET. zwraca nazwę widoku do
	 * wygenerowania
	 * 
	 * @return nazwa widoku
	 */
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}

	/**
	 * Metoda obsługująca żądanie /productList typu GET. Przy pomocy obiektu
	 * implementującego interfejs {@link ProductService} pobiera listę
	 * wszystkich produktów, reprezentowanych jako obiekty typu {@link Product}.
	 * List produktów jest zapisywana w modelu. Metoda zwraca nazwę widoku do
	 * wygenerowania w odpowiedzi.
	 * 
	 * @param model
	 *            interfejs, Spring dostarcza implementację. Holder dla
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
	 * Metoda obsługująca żądanie /productList/viewProduct/{id} typu GET. Przy
	 * pomocy implementacji interfejsu {@link ProductService} pobiera produkt
	 * {@link Product} o zadanym id i umieszcza go w modelu {@link Model}.
	 * Zwraca nazwę widoku do wygenerowania w odpowiedzi.
	 * 
	 * @param id
	 *            id produktu {@link Product}
	 * @param model
	 *            interfejs, Spring dostarcza implementację. Holder dla
	 *            atrybutów modelu w MVC.
	 * @return nazwa widoku.
	 * @throws IOException
	 *             ,etota może wyrzucić wujątek {@link IOException}
	 */
	@RequestMapping("/productList/viewProduct/{id}")
	public String viewProduct(@PathVariable int id, Model model) throws IOException {
		Product product = productService.getProductById(id);
		model.addAttribute(product);
		return "viewProduct";
	}

	/**
	 * Metoda obsługująca żądanie /productImage typu GET. Przy pomocy
	 * implementacji interfejsu {@link ProductService} produkt {@link Product} o
	 * zadanym id. Następnie pobiera obrazek z produktu i umieszcza go w
	 * odpowiedzi {@link HttpServletResponse}
	 * 
	 * @param request
	 *            obiekt rządania {@link HttpServletRequest}
	 * @param response
	 *            obiekt odpowiedzi {@link HttpServletResponse}
	 * @param model
	 *            interfejs, Spring dostarcza implementację. Holder dla
	 *            atrybutów modelu w MVC.
	 * @param id
	 *            id produktu, dla którego ma zostać pobrany obrazek.
	 * @throws IOException
	 *             metoda może rzucić wyjątek.
	 */
	@RequestMapping(value = { "/productImage" }, method = RequestMethod.GET)
	public void productImage(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("id") int id) throws IOException {
		Product product = null;
		if (id > 0) {
			product = this.productService.getProductById(id);
		}

		if (product != null && product.getProductImage() != null) {
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.getOutputStream().write(product.getProductImage());
		}
		response.getOutputStream().close();
	}

}
