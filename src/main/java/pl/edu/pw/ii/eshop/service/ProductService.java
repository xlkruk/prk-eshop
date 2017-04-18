package pl.edu.pw.ii.eshop.service;

import java.util.List;


import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.model.ProductInfo;


public interface ProductService {

	List<Product> getProductList();

	Product getProductById(int id);

	void addProduct(Product product);
	
	void addProduct(ProductInfo product);

	void editProduct(Product product);
	
	void editProduct(ProductInfo product);
	
	void deleteProduct(Product product);
}
