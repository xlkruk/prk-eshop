package pl.edu.pw.ii.eshop.dao;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.model.ProductInfo;

public interface ProductDao {
	public void addProduct(Product product);

	public Product getProductById(int id);

	public List<Product> getAllProducts();

	public void deleteProduct(int id);
	
	public void addProduct(ProductInfo productInfo);
	
	public void editProduct(ProductInfo productInfo);
}
