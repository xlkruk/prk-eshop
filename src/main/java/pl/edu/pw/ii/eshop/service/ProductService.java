package pl.edu.pw.ii.eshop.service;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.model.ProductInfo;

/**
 * Interfejs warstwy serwisu, definiujący metody związane z logiką biznesową
 * związaną z obsługą Produktu
 * 
 * @author Łukasz Kruk
 *
 */

public interface ProductService {
	/**
	 * Metoda zwracajaca listę wszystkich produktów {@link Product}
	 * 
	 * @return lista wszystkich produktów {@link Product}
	 */
	List<Product> getProductList();

	/**
	 * Metoda zwracająca wszystkie produkty o zadanej kategorii
	 * 
	 * @param category
	 *            kategoria
	 * @return lista produktów o zadanej kategorii.
	 */
	List<Product> getProductListByCategory(String category);

	/**
	 * Metoda zwracająca produkt {@link Product} o zadanym id
	 * 
	 * @param id
	 *            id produktu.
	 * @return produkt {@link Product}
	 */
	Product getProductById(int id);

	/**
	 * Metoda utrwalająca nowy produkt {@link Product}
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	void addProduct(Product product);

	/**
	 * Metoda utrwalająca nowy produkt {@link Product} na podstawie obiektu reprezentującego informacje o nim
	 * {@link ProductInfo}
	 * 
	 * @param product
	 *            informacje o produkcie {@link ProductInfo}
	 */
	void addProduct(ProductInfo product);

	/**
	 * Metoda umożliwiająca utrwalenie zmodyfikowanego produktu {@link Product}
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	void editProduct(Product product);

	/**
	 * Metoda umożliwiająca utrwalenie zmodyfikowanego produktu {@link Product}
	 * na podstawie informacji o produkcie {@link ProductInfo}
	 * 
	 * @param product
	 *            informacje o produkcie {@link ProductInfo}
	 */
	void editProduct(ProductInfo product);

	/**
	 * Metoda umożliwiająca usunięcie produktu
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	void deleteProduct(Product product);
}
