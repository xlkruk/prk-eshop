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
 * Klasa reprezentuj�ca encj� PRODUCT, produkt.
 * 
 * @author �ukasz Kruk
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
	@NotEmpty(message = "Nazwa produktu nie mo�e by� pusta.")
	private String name;
	@Column(name = "CATEGORY")
	private String category;
	@Column(name = "DESCRIPTION", length = 10000)
	private String description;
	@Column(name = "PRICE")
	@Min(value = 0, message = "Cena musi by� wi�ksza lub r�wna zero.")
	private double price;
	@Column(name = "PRODUCT_CONDITION")
	private String condition;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "STOCK")
	@Min(value = 0, message = "Liczba sztuk musi by� wi�ksza lub r�wna zero.")
	private int stock;
	@Column(name = "MANUFACTURER")
	private String manufacturer;

	@Column(name = "DISCOUNT")
	@Min(value = 0, message = "Rabat musi by� wi�kszy lub r�wny zero.")
	@Max(value = 100, message = "Rabat nie mo�e by� wi�kszy ni� 100%.")
	private int discount;

	@Lob
	@Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
	private byte[] productImage;

	// ustawiam FetchType.EAGER aby mie� pod r�k� dla JSONa
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore // potrzebne aby nie zap�tla� budowy JSOna
	private List<CartItem> cartItems;

	/**
	 * Konstruktor bezparametryczny
	 */
	public Product() {
	}

	/**
	 * Metoda zwracaj�ca id produktu {@link Product} - klucz g��wny
	 * 
	 * @return id produktu {@link Product} - klucz g��wny
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metoda ustawiaj�ca id produktu {@link Product} - klucz g��wny
	 * 
	 * @param id
	 *            id produktu {@link Product} - klucz g��wny
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metoda zwracaj�ca rabat na cen� produktu.
	 * 
	 * @return rabat na cen� produktu.
	 */
	public int getDiscount() {
		return discount;
	}

	/**
	 * Metoda ustawiaj�ca rabat na cen� produktu.
	 * 
	 * @param discount
	 *            rabat na cen� produktu.
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	/**
	 * Metoda zwracaj�ca nazw� produktu.
	 * 
	 * @return nazwa produktu.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metoda ustawiaj�ca nazw� produktu.
	 * 
	 * @param name
	 *            nazwa produktu.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metoda zwracaj�ca kategori� produktu
	 * 
	 * @return kategoria produktu
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Metoda ustawiaj�ca kategori� produktu
	 * 
	 * @param category
	 *            kategoria produktu
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Metoda zwracaj�ca opis produktu
	 * 
	 * @return opis produktu
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metoda ustawiaj�ca opis produktu
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Metoda zwracaj�ca cen� produktu
	 * 
	 * @return cena produktu
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Metoda ustawiaj�ca cen� produktu
	 * 
	 * @param price
	 *            cena produktu
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Metoda zwracaj�ca stan produktu - obecnie nieu�ywana
	 * 
	 * @return stan produktu
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * Metoda ustawiaj�ca stan produktu.
	 * 
	 * @param condidiotn
	 *            stan produktu
	 */
	public void setCondition(String condidiotn) {
		this.condition = condidiotn;
	}

	/**
	 * Metoda zwracaj�ca status produktu
	 * 
	 * @return status produktu
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Metoda ustawiaj�ca status produktu
	 * 
	 * @param status
	 *            status produktu
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Metoda pobieraj�ca stan magazynu - obecnie nieu�ywane
	 * 
	 * @return stan magazynu.
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * Metoda zwracaj�ca status magazynu
	 * 
	 * @param stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Metoda zwracaj�ca producenta produktu.
	 * 
	 * @return producent produktu.
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Metoda ustawiaj�ca producenta produktu.
	 * 
	 * @param manufacturer
	 *            producent produktu.
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * Metoda zwracaj�ca obrazek w postaci tablicy bajt�w.
	 * 
	 * @return obrazek w postaci tablicy bajt�w.
	 */
	public byte[] getProductImage() {
		return productImage;
	}

	/**
	 * Metoda ustawiajaca obrazek w postaci tablicy bajt�w.
	 * 
	 * @param productImage
	 *            obrazek w postaci tablicy bajt�w.
	 */
	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	/**
	 * Metoda zwracaj�ca linie agregacyjne koszyka {@link CartItem} , do kt�rych
	 * nale�y produkt.
	 * 
	 * @return lista linii agregacyjnych koszyka, do kt�rych nale�y produkt.
	 */
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	/**
	 * Metoda ustawiaj�ca linie agregacyjne koszyka, do kt�rych nale�y produkt.
	 * 
	 * @param cartItems
	 *            lista linii agregacyjnych koszyka, do kt�rych nale�y produkt.
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
