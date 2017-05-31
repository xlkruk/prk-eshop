package pl.edu.pw.ii.eshop.dao;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Product;

/**
 * Interfejs dostêpu do obiektu {@link Product} DAO
 * 
 * @author Agnieszka Œwiderska
 *
 */
public interface ProductDao {
	/**
	 * Metoda utrwalaj¹ca nowy produkt {@link Product}
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	public void addProduct(Product product);

	/**
	 * Metoda zwracaj¹ca produkt {@link Product} o zadanym id
	 * 
	 * @param id
	 *            id produktu.
	 * @return produkt {@link Product}
	 */
	public Product getProductById(int id);

	/**
	 * Metoda zwracajaca listê wszystkich produktów {@link Product}
	 * 
	 * @return lista wszystkich produktów {@link Product}
	 */
	public List<Product> getAllProducts();

	/**
	 * Metoda zwracaj¹ca wszystkie produkty o zadanej kategorii
	 * 
	 * @param category
	 *            kategoria
	 * @return lista produktów o zadanej kategorii.
	 */
	public List<Product> getProductsByCategory(String category);

	/**
	 * Metoda umo¿liwiaj¹ca usuniêcie produktu
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	public void deleteProduct(Product product);

	/**
	 * Metoda umo¿liwiaj¹ca utrwalenie zmodyfikowanego produktu {@link Product}
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	public void editProduct(Product product);
}
