package pl.edu.pw.ii.eshop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Klasa reprezentuj¹ca encjê PRODUCT, produkt.
 * 
 * @author £ukasz Kruk
 *
 */
@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = -8098965355899698609L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	@NotEmpty(message = "Nazwa produktu nie mo¿e byæ pusta.")
	private String name;
	@Column(name = "CATEGORY")
	private String category;
	@Column(name = "DESCRIPTION", length = 10000)
	private String description;
	@Column(name = "PRICE")
	@Min(value = 0, message = "Cena musi byæ wiêksza lub równa zero.")
	private double price;
	@Column(name = "PRODUCT_CONDITION")
	private String condition;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "STOCK")
	@Min(value = 0, message = "Liczba sztuk musi byæ wiêksza lub równa zero.")
	private int stock;
	@Column(name = "MANUFACTURER")
	private String manufacturer;

	@Column(name = "DISCOUNT")
	@Min(value = 0, message = "Rabat musi byæ wiêkszy lub równy zero.")
	@Max(value = 100, message = "Rabat nie mo¿e byæ wiêkszy ni¿ 100%.")
	private int discount;

	@Lob
	@Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
	private byte[] productImage;

	// ustawiam FetchType.EAGER aby mieæ pod rêk¹ dla JSONa
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore // potrzebne aby nie zapêtlaæ budowy JSOna
	private List<CartItem> cartItems;

	/**
	 * Konstruktor bezparametryczny
	 */
	public Product() {
	}

	/**
	 * Metoda zwracaj¹ca id produktu {@link Product} - klucz g³ówny
	 * 
	 * @return id produktu {@link Product} - klucz g³ówny
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metoda ustawiaj¹ca id produktu {@link Product} - klucz g³ówny
	 * 
	 * @param id
	 *            id produktu {@link Product} - klucz g³ówny
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metoda zwracaj¹ca rabat na cenê produktu.
	 * 
	 * @return rabat na cenê produktu.
	 */
	public int getDiscount() {
		return discount;
	}

	/**
	 * Metoda ustawiaj¹ca rabat na cenê produktu.
	 * 
	 * @param discount
	 *            rabat na cenê produktu.
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	/**
	 * Metoda zwracaj¹ca nazwê produktu.
	 * 
	 * @return nazwa produktu.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metoda ustawiaj¹ca nazwê produktu.
	 * 
	 * @param name
	 *            nazwa produktu.
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
	 *            kategoria produktu
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
	 * Metoda zwracaj¹ca stan produktu - obecnie nieu¿ywana
	 * 
	 * @return stan produktu
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * Metoda ustawiaj¹ca stan produktu.
	 * 
	 * @param condidiotn
	 *            stan produktu
	 */
	public void setCondition(String condidiotn) {
		this.condition = condidiotn;
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
	 *            status produktu
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Metoda pobieraj¹ca stan magazynu - obecnie nieu¿ywane
	 * 
	 * @return stan magazynu.
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * Metoda zwracaj¹ca status magazynu
	 * 
	 * @param stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Metoda zwracaj¹ca producenta produktu.
	 * 
	 * @return producent produktu.
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Metoda ustawiaj¹ca producenta produktu.
	 * 
	 * @param manufacturer
	 *            producent produktu.
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * Metoda zwracaj¹ca obrazek w postaci tablicy bajtów.
	 * 
	 * @return obrazek w postaci tablicy bajtów.
	 */
	public byte[] getProductImage() {
		return productImage;
	}

	/**
	 * Metoda ustawiajaca obrazek w postaci tablicy bajtów.
	 * 
	 * @param productImage
	 *            obrazek w postaci tablicy bajtów.
	 */
	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	/**
	 * Metoda zwracaj¹ca linie agregacyjne koszyka {@link CartItem} , do których
	 * nale¿y produkt.
	 * 
	 * @return lista linii agregacyjnych koszyka, do których nale¿y produkt.
	 */
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	/**
	 * Metoda ustawiaj¹ca linie agregacyjne koszyka, do których nale¿y produkt.
	 * 
	 * @param cartItems
	 *            lista linii agregacyjnych koszyka, do których nale¿y produkt.
	 */
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", description=" + description
				+ ", price=" + price + ", condition=" + condition + ", status=" + status + ", stock=" + stock
				+ ", manufacturer=" + manufacturer + ", discount=" + discount + ", productImage=" + productImage + "]";
	}

}
