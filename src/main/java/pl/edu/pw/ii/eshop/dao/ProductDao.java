package pl.edu.pw.ii.eshop.dao;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Product;

public interface ProductDao {
	public void addProduct(Product product);

	public Product getProductById(int id);

	public List<Product> getAllProducts();

	public void deleteProduct(int id);
}
