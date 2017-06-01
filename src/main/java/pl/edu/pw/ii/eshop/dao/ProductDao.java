package pl.edu.pw.ii.eshop.dao;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Product;

/**
 * Interfejs dostępu do obiektu {@link Product} DAO
 * 
 * @author Agnieszka Świderska
 *
 */
public interface ProductDao {
	/**
	 * Metoda utrwalająca nowy produkt {@link Product}
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	public void addProduct(Product product);

	/**
	 * Metoda zwracająca produkt {@link Product} o zadanym id
	 * 
	 * @param id
	 *            id produktu.
	 * @return produkt {@link Product}
	 */
	public Product getProductById(int id);

	/**
	 * Metoda zwracajaca listę wszystkich produktów {@link Product}
	 * 
	 * @return lista wszystkich produktów {@link Product}
	 */
	public List<Product> getAllProducts();

	/**
	 * Metoda zwracająca wszystkie produkty o zadanej kategorii
	 * 
	 * @param category
	 *            kategoria
	 * @return lista produktów o zadanej kategorii.
	 */
	public List<Product> getProductsByCategory(String category);

	/**
	 * Metoda umożliwiająca usunięcie produktu
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	public void deleteProduct(Product product);

	/**
	 * Metoda umożliwiająca utrwalenie zmodyfikowanego produktu {@link Product}
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	public void editProduct(Product product);
}
