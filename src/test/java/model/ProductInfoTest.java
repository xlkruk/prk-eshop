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

/**
 * @author Krzysztof Trybus
 * @version 1.0
 *
 */

public class ProductInfoTest extends ProductInfo{
private static final long serialVersionUID = -8098965355899698609L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id = 234521;
	@Column(name = "NAME")
	@NotEmpty(message="Nazwa produktu nie mo�e by� pusta.")
	private String name = "Tapczan";
	@Column(name = "CATEGORY")
	private String category = "MEBLE";
	@Column(name = "DESCRIPTION", length = 10000)
	private String description = "opis produktu 1234567890";
	@Column(name = "PRICE")
	@Min(value=0, message="Cena musi by� wi�ksza lub r�wna zero.")
	private double price = 784.86;
	@Column(name = "PRODUCT_CONDITION")
	private String condition = "W MAGAZYNIE";
	@Column(name = "STATUS")
	private String status = "NOWY";
	@Column(name = "STOCK")
	@Min(value=0, message="Liczba sztuk musi by� wi�ksza lub r�wna zero.")
	private int stock = 99;
	@Column(name = "MANUFACTURER")
	private String manufacturer = "Test Sp.z o.o.";
	
	@Column(name = "DISCOUNT")
	@Min(value=0, message="Rabat musi by� wi�kszy lub r�wny zero.")
	@Max(value=100, message="Rabat nie mo�e by� wi�kszy ni� 100%.")
	private int discount = 56;

	@Lob
	@Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
	private byte[] productImage;
	
	//ustawiam FetchType.EAGER aby mie� pod r�k� dla JSONa
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore // potrzebne aby nie zap�tla� budowy JSOna
	private List<CartItem> cartItems;

	@Test
	public void testGetId() {
		setId(id);
		assertEquals(id,getId());
		assertFalse("".equals(getId()));
	}

	@Test
	public void testGetName() {
		setName(name);
		assertEquals(name, getName());
		assertFalse(category.equals(getName()));
	}

	@Test
	public void testGetCategory() {
		setCategory(category);
		assertEquals(category, getCategory());
		assertFalse(name.equals(getCategory()));
	}

	@Test
	public void testGetDescription() {
		setDescription(description);
		assertEquals(description,getDescription());
		assertFalse("description".equals(getDescription()));
	}

	@Test
	public void testGetPrice() {
		setPrice(price);
		assertEquals(price,getPrice(),0.01);
		assertFalse("784.86".equals(getPrice()));
	}

	@Test
	public void testGetCondition() {
		setCondition(condition);
		assertEquals(condition,getCondition());
		assertFalse("UŻYWANY".equals(getCondition()));
	}

	@Test
	public void testGetStatus() {
		setStatus(status);
		assertEquals(status,getStatus());
		assertFalse("NIEDOSTEPNY".equals(getStatus()));
	}

	@Test
	public void testGetStock() {
		setStock(stock);
		assertEquals(stock,getStock());
		assertFalse("NIEDOSTEPNY".equals(getStatus()));
	}

	@Test
	public void testGetManufacturer() {
		setManufacturer(manufacturer);
		assertEquals(manufacturer,getManufacturer());
		assertFalse("manufacturer".equals(getManufacturer()));
	}

	@Test
	public void testGetDiscount() {
		setDiscount(discount);
		assertEquals(discount,getDiscount());
		assertFalse("33".equals(getDiscount()));
	}
}
