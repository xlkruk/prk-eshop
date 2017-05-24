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


@Entity
public class Product implements Serializable{

	private static final long serialVersionUID = -8098965355899698609L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	@NotEmpty(message="Nazwa produktu nie mo¿e byæ pusta.")
	private String name;
	@Column(name = "CATEGORY")
	private String category;
	@Column(name = "DESCRIPTION", length = 10000)
	private String description;
	@Column(name = "PRICE")
	@Min(value=0, message="Cena musi byæ wiêksza lub równa zero.")
	private double price;
	@Column(name = "PRODUCT_CONDITION")
	private String condition;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "STOCK")
	@Min(value=0, message="Liczba sztuk musi byæ wiêksza lub równa zero.")
	private int stock;
	@Column(name = "MANUFACTURER")
	private String manufacturer;
	
	@Column(name = "DISCOUNT")
	@Min(value=0, message="Rabat musi byæ wiêkszy lub równy zero.")
	@Max(value=100, message="Rabat nie mo¿e byæ wiêkszy ni¿ 100%.")
	private int discount;

	@Lob
	@Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
	private byte[] productImage;
	
	//ustawiam FetchType.EAGER aby mieæ pod rêk¹ dla JSONa
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore // potrzebne aby nie zapêtlaæ budowy JSOna
	private List<CartItem> cartItems;

	public Product() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condidiotn) {
		this.condition = condidiotn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public byte[] getProductImage() {
		return productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}
	
	

	public List<CartItem> getCartItems() {
		return cartItems;
	}

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
