package pl.edu.pw.ii.eshop.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class ProductInfo {

	private int id;
	@NotEmpty(message="Nazwa produktu nie mo¿e byæ pusta.")
	private String name;

	private String category;

	private String description;

	@Min(value=0, message="Cena musi byæ wiêksza lub równa zero.")
	@DecimalMax(value = "99999.99", message = "Cena nie mo¿e byæ wiêksza ni¿ 99999.99 PLN")
	private double price;

	private String condition;

	private String status;
	@Min(value=0, message="Liczba sztuk musi byæ wiêksza lub równa zero.")
	private int stock;

	private String manufacturer;
	@Min(value=0, message="Rabat musi byæ wiêksza lub równy zero.")
	@Max(value=100, message="Rabat nie mo¿e byæ wiêkszy ni¿ 100%.")
	private int discount;

	private MultipartFile productImage;
	
	private byte[] productImageAsArray;
	
	public byte[] getProductImageAsArray() {
		return productImageAsArray;
	}
	
	public void setProductImageAsArray(byte[] productImageAsArray) {
		this.productImageAsArray = productImageAsArray;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setCondition(String condition) {
		this.condition = condition;
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

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	

}
