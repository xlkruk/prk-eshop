package pl.edu.pw.ii.eshop.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pl.edu.pw.ii.eshop.dao.ProductDao;
import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.model.ProductInfo;

@Controller
public class HomeController {

	private Path path;

	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/productList")
	public String getProducts(Model model) {
		List<Product> products = productDao.getAllProducts();
		// Product product = productList.get(0);
		model.addAttribute("products", products);

		return "productList";
	}

	@RequestMapping("/productList/viewProduct/{id}")
	public String viewProduct(@PathVariable int id, Model model) throws IOException {
		Product product = productDao.getProductById(id);
		model.addAttribute(product);
		return "viewProduct";
	}

	@RequestMapping("/admin")
	public String adminPage() {
		return "admin";
	}

	@RequestMapping("/admin/productInventory")
	public String productInventory(Model model) {
		List<Product> products = productDao.getAllProducts();
		model.addAttribute("products", products);
		return "productInventory";
	}

	@RequestMapping("/admin/productInventory/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		product.setCategory("Kategoria 3");
		product.setCondition("Nowy");
		product.setStatus("aktywny");

		model.addAttribute("product", product);

		return "addProduct";
	}

	@RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product") ProductInfo product, HttpServletRequest request) {

		MultipartFile productImage = product.getProductImage();

		if (productImage != null && !productImage.isEmpty()) {
			try {
				product.setProductImageAsArray(productImage.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed", e);
			}
		}
		productDao.addProduct(product);
		return "redirect:/admin/productInventory";
	}

	@RequestMapping("/admin/productInventory/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + id + ".png");

		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		productDao.deleteProduct(id);

		return "redirect:/admin/productInventory";
	}

	@RequestMapping(value = { "/productImage" }, method = RequestMethod.GET)
	public void productImage(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("id") int id) throws IOException {
		Product product = null;
		if (id > 0) {
			product = this.productDao.getProductById(id);
		}
		if (product != null && product.getProductImage() != null) {
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.getOutputStream().write(product.getProductImage());
		}
		response.getOutputStream().close();
	}

	@RequestMapping("/admin/productInventory/editProduct/{id}")
	public String editProduct(@PathVariable("id") int id, Model model) {
		Product product = productDao.getProductById(id);
		model.addAttribute(product);

		return "editProduct";
	}

	@RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute("product") ProductInfo product, HttpServletRequest request) {
		MultipartFile productImage = product.getProductImage();
		if (productImage != null && !productImage.isEmpty()) {
			try {
				product.setProductImageAsArray(productImage.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed", e);
			}
		}
		productDao.editProduct(product);
		return "redirect:/admin/productInventory";

	}

}
