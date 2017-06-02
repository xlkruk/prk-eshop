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
 * Klasa reprezentująca encję PRODUCT, produkt.
 * 
 * @author Łukasz Kruk
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
	@NotEmpty(message = "Nazwa produktu nie może byż pusta.")
	private String name;
	@Column(name = "CATEGORY")
	private String category;
	@Column(name = "DESCRIPTION", length = 10000)
	private String description;
	@Column(name = "PRICE")
	@Min(value = 0, message = "Cena musi byż większa lub równa zero.")
	private double price;
	@Column(name = "PRODUCT_CONDITION")
	private String condition;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "STOCK")
	@Min(value = 0, message = "Liczba sztuk musi być większa lub równa zero.")
	private int stock;
	@Column(name = "MANUFACTURER")
	private String manufacturer;

	@Column(name = "DISCOUNT")
	@Min(value = 0, message = "Rabat musi być większy lub równy zero.")
	@Max(value = 100, message = "Rabat nie może być większy ni� 100%.")
	private int discount;

	@Lob
	@Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
	private byte[] productImage;

	// ustawiam FetchType.EAGER aby mieć pod ręką dla JSONa
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore // potrzebne aby nie zapętlać budowy JSOna
	private List<CartItem> cartItems;

	/**
	 * Konstruktor bezparametryczny
	 */
	public Product() {
	}

	/**
	 * Metoda zwracająca id produktu {@link Product} - klucz główny
	 * 
	 * @return id produktu {@link Product} - klucz główny
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metoda ustawiająca id produktu {@link Product} - klucz główny
	 * 
	 * @param id
	 *            id produktu {@link Product} - klucz główny
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metoda zwracająca rabat na cenę produktu.
	 * 
	 * @return rabat na cenę produktu.
	 */
	public int getDiscount() {
		return discount;
	}

	/**
	 * Metoda ustawiająca rabat na cenę produktu.
	 * 
	 * @param discount
	 *            rabat na cenę produktu.
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	/**
	 * Metoda zwracająca nazwę produktu.
	 * 
	 * @return nazwa produktu.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metoda ustawiająca nazwę produktu.
	 * 
	 * @param name
	 *            nazwa produktu.
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
	 *            kategoria produktu
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
	 *            opis
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
	 * Metoda zwracająca stan produktu - obecnie nieużywana
	 * 
	 * @return stan produktu
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * Metoda ustawiająca stan produktu.
	 * 
	 * @param condidiotn
	 *            stan produktu
	 */
	public void setCondition(String condidiotn) {
		this.condition = condidiotn;
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
	 *            status produktu
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Metoda zwracająca stan magazynu - obecnie nieużywane
	 * 
	 * @return stan magazynu.
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * Metoda zwracająca status magazynu
	 * 
	 * @param stock
	 *            stan magazynu - obecnie nieużywane.
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Metoda zwracająca producenta produktu.
	 * 
	 * @return producent produktu.
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Metoda ustawiająca producenta produktu.
	 * 
	 * @param manufacturer
	 *            producent produktu.
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * Metoda zwracająca obrazek w postaci tablicy bajtów.
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
	 * Metoda zwracająca linie agregacyjne koszyka {@link CartItem} , do których
	 * należy produkt.
	 * 
	 * @return lista linii agregacyjnych koszyka, do których należy produkt.
	 */
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	/**
	 * Metoda ustawiająca linie agregacyjne koszyka, do których należy produkt.
	 * 
	 * @param cartItems
	 *            lista linii agregacyjnych koszyka, do których należy produkt.
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
