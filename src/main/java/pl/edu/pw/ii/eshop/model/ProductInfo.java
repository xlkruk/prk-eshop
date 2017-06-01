package pl.edu.pw.ii.eshop.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 * Klasa pomocnicza, reprezentująca informacje o produkcie. Używana w warstwie
 * serwisu oraz prezentacji.
 * 
 * @author Łukasz Kruk
 *
 */
public class ProductInfo {

	private int id;
	@NotEmpty(message = "Nazwa produktu nie może być pusta.")
	private String name;

	private String category;

	private String description;

	@Min(value = 0, message = "Cena musi być większa lub równa zero.")
	@DecimalMax(value = "99999.99", message = "Cena nie może być większa niż 99999.99 PLN")
	private double price;

	private String condition;

	private String status;
	@Min(value = 0, message = "Liczba sztuk musi być większa lub równa zero.")
	private int stock;

	private String manufacturer;
	@Min(value = 0, message = "Rabat musi być większa lub równy zero.")
	@Max(value = 100, message = "Rabat nie może być większy niż 100%.")
	private int discount;

	private MultipartFile productImage;

	private byte[] productImageAsArray;

	/**
	 * Metoda zwracająca obrazek jako tablicę bajtów
	 * 
	 * @return obrazek jako tablicę bajtów
	 */
	public byte[] getProductImageAsArray() {
		return productImageAsArray;
	}

	/**
	 * Metoda ustawiająca obrazek jako tablicę bajtów
	 * 
	 * @param productImageAsArray
	 *            obrazek jako tablicę bajtów
	 */
	public void setProductImageAsArray(byte[] productImageAsArray) {
		this.productImageAsArray = productImageAsArray;
	}

	/**
	 * Metoda zwracająca id produktu
	 * 
	 * @return id produktu
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metoda ustawiająca id produktu
	 * 
	 * @param id
	 *            id produktu
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metoda zwracająca nazwę produktu
	 * 
	 * @return nazwa produktu
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metoda ustawiająca nazwę produktu
	 * 
	 * @param name
	 *            nazwa produktu
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metoda zwracająca kategorię produktu
	 * 
	 * @return kategoria produktu
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Metoda ustawiająca kategorię produktu
	 * 
	 * @param category
	 *            kategoria produktu.
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Metoda zwracająca opis produktu
	 * 
	 * @return opis produktu
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metoda ustawiająca opis produktu
	 * 
	 * @param description
	 *            opis produktu
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Metoda zwracająca cenę produktu
	 * 
	 * @return cena produktu
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Metoda ustawiająca cenę produktu
	 * 
	 * @param price
	 *            cena produktu
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Metoda zwracająca stan produktu
	 * 
	 * @return stan produktu
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * Metoda ustawiająca stan produktu
	 * 
	 * @param condition
	 *            stan produktu
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * Metoda zwracająca status produktu
	 * 
	 * @return status produktu
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Metoda ustawiająca status produktu
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Metoda zwracająca stan magazynu.
	 * 
	 * @return stan magazynu.
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * Metoda ustawiająca stan magazynu.
	 * 
	 * @param stock
	 *            stan magazynu.
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Metoda zwracająca producenta produktu
	 * 
	 * @return producent produktu
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Metoda ustawiająca producenta produktu
	 * 
	 * @param manufacturer
	 *            producent produktu
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * Metoda zwracająca rabat
	 * 
	 * @return rabat
	 */
	public int getDiscount() {
		return discount;
	}

	/**
	 * Metoda ustawiająca rabat
	 * 
	 * @param discount
	 *            rabat
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	/**
	 * Metoda zwracająca obrazek jako obiekt {@link MultipartFile}
	 * 
	 * @return obrazek jako obiekt {@link MultipartFile}
	 */
	public MultipartFile getProductImage() {
		return productImage;
	}

	/**
	 * Metoda ustawiająca obrazek jako obiekt {@link MultipartFile}
	 * 
	 * @param productImage
	 *            obrazek jako obiekt {@link MultipartFile}
	 */
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

}
