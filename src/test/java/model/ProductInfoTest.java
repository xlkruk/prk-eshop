package model;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pl.edu.pw.ii.eshop.model.CartItem;
import pl.edu.pw.ii.eshop.model.ProductInfo;

public class ProductInfoTest extends ProductInfo{
private static final long serialVersionUID = -8098965355899698609L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id = 234521;
	@Column(name = "NAME")
	@NotEmpty(message="Nazwa produktu nie może być pusta.")
	private String name = "Tapczan";
	@Column(name = "CATEGORY")
	private String category = "MEBLE";
	@Column(name = "DESCRIPTION", length = 10000)
	private String description = "opis produktu 1234567890";
	@Column(name = "PRICE")
	@Min(value=0, message="Cena musi być większa lub równa zero.")
	private double price = 784.80;
	@Column(name = "PRODUCT_CONDITION")
	private String condition = "W MAGAZYNIE";
	@Column(name = "STATUS")
	private String status = "NOWY";
	@Column(name = "STOCK")
	@Min(value=0, message="Liczba sztuk musi być większa lub równa zero.")
	private int stock = 99;
	@Column(name = "MANUFACTURER")
	private String manufacturer = "Test Sp.z o.o.";
	
	@Column(name = "DISCOUNT")
	@Min(value=0, message="Rabat musi być większy lub równy zero.")
	@Max(value=100, message="Rabat nie może być większy niż 100%.")
	private int discount = 56;

	@Lob
	@Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
	private byte[] productImage;
	
	//ustawiam FetchType.EAGER aby mieć pod ręką dla JSONa
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore // potrzebne aby nie zapętlać budowy JSOna
	private List<CartItem> cartItems;

	@Test
	public void testGetId() {
		setId(id);
		assertEquals(id,getId());
	}

	@Test
	public void testGetName() {
		setName(name);
		assertEquals(name, getName());
	}

	@Test
	public void testGetCategory() {
		setCategory(category);
		assertEquals(category, getCategory());
	}

	@Test
	public void testGetDescription() {
		setDescription(description);
		assertEquals(description,getDescription());
	}

	@Test
	public void testGetPrice() {
		setPrice(price);
		assertEquals(price,getPrice(),0.01);
	}

	@Test
	public void testGetCondition() {
		setCondition(condition);
		assertEquals(condition,getCondition());
	}

	@Test
	public void testGetStatus() {
		setStatus(status);
		assertEquals(status,getStatus());
	}

	@Test
	public void testGetStock() {
		setStock(stock);
		assertEquals(stock,getStock());
	}

	@Test
	public void testGetManufacturer() {
		setManufacturer(manufacturer);
		assertEquals(manufacturer,getManufacturer());
	}

	@Test
	public void testGetDiscount() {
		setDiscount(discount);
		assertEquals(discount,getDiscount());
	}
}
