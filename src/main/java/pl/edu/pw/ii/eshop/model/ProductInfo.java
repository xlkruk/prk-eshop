package pl.edu.pw.ii.eshop.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 * Klasa pomocnicza, reprezentuj¹ca informacje o produkcie. U¿ywana w warstwie
 * serwisu oraz prezentacji.
 * 
 * @author £ukasz Kruk
 *
 */
public class ProductInfo {

	private int id;
	@NotEmpty(message = "Nazwa produktu nie mo¿e byæ pusta.")
	private String name;

	private String category;

	private String description;

	@Min(value = 0, message = "Cena musi byæ wiêksza lub równa zero.")
	@DecimalMax(value = "99999.99", message = "Cena nie mo¿e byæ wiêksza ni¿ 99999.99 PLN")
	private double price;

	private String condition;

	private String status;
	@Min(value = 0, message = "Liczba sztuk musi byæ wiêksza lub równa zero.")
	private int stock;

	private String manufacturer;
	@Min(value = 0, message = "Rabat musi byæ wiêksza lub równy zero.")
	@Max(value = 100, message = "Rabat nie mo¿e byæ wiêkszy ni¿ 100%.")
	private int discount;

	private MultipartFile productImage;

	private byte[] productImageAsArray;

	/**
	 * Metoda zwracaj¹ca obrazek jako tablicê bajtów
	 * 
	 * @return obrazek jako tablicê bajtów
	 */
	public byte[] getProductImageAsArray() {
		return productImageAsArray;
	}

	/**
	 * Metoda ustawiaj¹ca obrazek jako tablicê bajtów
	 * 
	 * @param productImageAsArray
	 *            obrazek jako tablicê bajtów
	 */
	public void setProductImageAsArray(byte[] productImageAsArray) {
		this.productImageAsArray = productImageAsArray;
	}

	/**
	 * Metoda zwracaj¹ca id produktu
	 * 
	 * @return id produktu
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metoda ustawiaj¹ca id produktu
	 * 
	 * @param id
	 *            id produktu
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metoda zwracaj¹ca nazwê produktu
	 * 
	 * @return nazwa produktu
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metoda ustawiaj¹ca nazwê produktu
	 * 
	 * @param name
	 *            nazwa produktu
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metoda zwracaj¹ca kategoriê produktu
	 * 
	 * @return kategoria produktu
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Metoda ustawiaj¹ca kategoriê produktu
	 * 
	 * @param category
	 *            kategoria produktu.
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Metoda zwracaj¹ca opis produktu
	 * 
	 * @return opis produktu
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metoda ustawiaj¹ca opis produktu
	 * 
	 * @param description
	 *            opis produktu
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Metoda zwracaj¹ca cenê produktu
	 * 
	 * @return cena produktu
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Metoda ustawiaj¹ca cenê produktu
	 * 
	 * @param price
	 *            cena produktu
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Metoda zwracaj¹ca stan produktu
	 * 
	 * @return stan produktu
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * Metoda ustawiaj¹ca stan produktu
	 * 
	 * @param condition
	 *            stan produktu
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * Metoda zwracaj¹ca status produktu
	 * 
	 * @return status produktu
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Metoda ustawiaj¹ca status produktu
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Metoda zwracaj¹ca stan magazynu.
	 * 
	 * @return stan magazynu.
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * Metoda ustawiaj¹ca stan magazynu.
	 * 
	 * @param stock
	 *            stan magazynu.
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Metoda zwracaj¹ca producenta produktu
	 * 
	 * @return producent produktu
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Metoda ustawiaj¹ca producenta produktu
	 * 
	 * @param manufacturer
	 *            producent produktu
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * Metoda zwracaj¹ca rabat
	 * 
	 * @return rabat
	 */
	public int getDiscount() {
		return discount;
	}

	/**
	 * Metoda ustawiaj¹ca rabat
	 * 
	 * @param discount
	 *            rabat
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	/**
	 * Metoda zwracaj¹ca obrazek jako obiekt {@link MultipartFile}
	 * 
	 * @return obrazek jako obiekt {@link MultipartFile}
	 */
	public MultipartFile getProductImage() {
		return productImage;
	}

	/**
	 * Metoda ustawiaj¹ca obrazek jako obiekt {@link MultipartFile}
	 * 
	 * @param productImage
	 *            obrazek jako obiekt {@link MultipartFile}
	 */
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

}
