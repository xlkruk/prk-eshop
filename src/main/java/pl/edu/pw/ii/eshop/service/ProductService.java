package pl.edu.pw.ii.eshop.service;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.model.ProductInfo;

/**
 * Interfejs warstwy serwisu, definiuj¹cy metody zwi¹zane z logik¹ biznesow¹
 * zwi¹zan¹ z obs³ug¹ Produktu
 * 
 * @author Krzysztof Trybus
 *
 */

public interface ProductService {
	/**
	 * Metoda zwracajaca listê wszystkich produktów {@link Product}
	 * 
	 * @return lista wszystkich produktów {@link Product}
	 */
	List<Product> getProductList();

	/**
	 * Metoda zwracaj¹ca wszystkie produkty o zadanej kategorii
	 * 
	 * @param category
	 *            kategoria
	 * @return lista produktów o zadanej kategorii.
	 */
	List<Product> getProductListByCategory(String category);

	/**
	 * Metoda zwracaj¹ca produkt {@link Product} o zadanym id
	 * 
	 * @param id
	 *            id produktu.
	 * @return produkt {@link Product}
	 */
	Product getProductById(int id);

	/**
	 * Metoda utrwalaj¹ca nowy produkt {@link Product}
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	void addProduct(Product product);

	/**
	 * Metoda utrwalaj¹ca nowy produkt {@link Product} na podstawie
	 * {@link ProductInfo}
	 * 
	 * @param product
	 *            informacje o produkcie {@link ProductInfo}
	 */
	void addProduct(ProductInfo product);

	/**
	 * Metoda umo¿liwiaj¹ca utrwalenie zmodyfikowanego produktu {@link Product}
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	void editProduct(Product product);

	/**
	 * Metoda umo¿liwiaj¹ca utrwalenie zmodyfikowanego produktu {@link Product}
	 * na podstawie informacji o produkcie {@link ProductInfo}
	 * 
	 * @param product
	 *            informacje o produkcie {@link ProductInfo}
	 */
	void editProduct(ProductInfo product);

	/**
	 * Metoda umo¿liwiaj¹ca usuniêcie produktu
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	void deleteProduct(Product product);
}
