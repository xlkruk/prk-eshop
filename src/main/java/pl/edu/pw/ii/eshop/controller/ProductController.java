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

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/productList")
	public String getProducts(Model model) {
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		return "productList";
	}

	@RequestMapping("/viewProduct/{id}")
	public String viewProduct(@PathVariable int id, Model model) throws Exception {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "viewProduct";
	}
	
	@RequestMapping("/productListByCategory/{category}")
	public String orderListByStatus(@PathVariable Categories category, Model model){
		List<Product> products = productService.getProductListByCategory(category.getDescription());
		model.addAttribute("products", products);
		return "productList";
	}
}
