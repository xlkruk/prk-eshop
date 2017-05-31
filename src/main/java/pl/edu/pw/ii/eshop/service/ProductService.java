package pl.edu.pw.ii.eshop.service;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Product;
import pl.edu.pw.ii.eshop.model.ProductInfo;

/**
 * Interfejs warstwy serwisu, definiuj�cy metody zwi�zane z logik� biznesow�
 * zwi�zan� z obs�ug� Produktu
 * 
 * @author Krzysztof Trybus
 *
 */

public interface ProductService {
	/**
	 * Metoda zwracajaca list� wszystkich produkt�w {@link Product}
	 * 
	 * @return lista wszystkich produkt�w {@link Product}
	 */
	List<Product> getProductList();

	/**
	 * Metoda zwracaj�ca wszystkie produkty o zadanej kategorii
	 * 
	 * @param category
	 *            kategoria
	 * @return lista produkt�w o zadanej kategorii.
	 */
	List<Product> getProductListByCategory(String category);

	/**
	 * Metoda zwracaj�ca produkt {@link Product} o zadanym id
	 * 
	 * @param id
	 *            id produktu.
	 * @return produkt {@link Product}
	 */
	Product getProductById(int id);

	/**
	 * Metoda utrwalaj�ca nowy produkt {@link Product}
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	void addProduct(Product product);

	/**
	 * Metoda utrwalaj�ca nowy produkt {@link Product} na podstawie
	 * {@link ProductInfo}
	 * 
	 * @param product
	 *            informacje o produkcie {@link ProductInfo}
	 */
	void addProduct(ProductInfo product);

	/**
	 * Metoda umo�liwiaj�ca utrwalenie zmodyfikowanego produktu {@link Product}
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	void editProduct(Product product);

	/**
	 * Metoda umo�liwiaj�ca utrwalenie zmodyfikowanego produktu {@link Product}
	 * na podstawie informacji o produkcie {@link ProductInfo}
	 * 
	 * @param product
	 *            informacje o produkcie {@link ProductInfo}
	 */
	void editProduct(ProductInfo product);

	/**
	 * Metoda umo�liwiaj�ca usuni�cie produktu
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	void deleteProduct(Product product);
}
