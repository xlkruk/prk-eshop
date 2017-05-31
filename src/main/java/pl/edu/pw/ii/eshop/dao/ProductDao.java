package pl.edu.pw.ii.eshop.dao;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Product;

/**
 * Interfejs dost�pu do obiektu {@link Product} DAO
 * 
 * @author Agnieszka �widerska
 *
 */
public interface ProductDao {
	/**
	 * Metoda utrwalaj�ca nowy produkt {@link Product}
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	public void addProduct(Product product);

	/**
	 * Metoda zwracaj�ca produkt {@link Product} o zadanym id
	 * 
	 * @param id
	 *            id produktu.
	 * @return produkt {@link Product}
	 */
	public Product getProductById(int id);

	/**
	 * Metoda zwracajaca list� wszystkich produkt�w {@link Product}
	 * 
	 * @return lista wszystkich produkt�w {@link Product}
	 */
	public List<Product> getAllProducts();

	/**
	 * Metoda zwracaj�ca wszystkie produkty o zadanej kategorii
	 * 
	 * @param category
	 *            kategoria
	 * @return lista produkt�w o zadanej kategorii.
	 */
	public List<Product> getProductsByCategory(String category);

	/**
	 * Metoda umo�liwiaj�ca usuni�cie produktu
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	public void deleteProduct(Product product);

	/**
	 * Metoda umo�liwiaj�ca utrwalenie zmodyfikowanego produktu {@link Product}
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	public void editProduct(Product product);
}
