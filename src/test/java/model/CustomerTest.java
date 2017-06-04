package model;

import static org.junit.Assert.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pl.edu.pw.ii.eshop.model.BillingAddress;
import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.ShippingAddress;

/**
 * @author Krzysztof Trybus
 * @version 1.0
 *
 */

public class CustomerTest extends Customer {
	
	private static final long serialVersionUID = 7259919964084234579L;

	@Id
	@GeneratedValue
	private int customerId = 1111;

	@NotEmpty(message = "Imi� nie mo�e by� puste.")
	private String customerFirstName = "Krzysztof";
	
	@NotEmpty(message = "Nazwisko nie mo�e by� puste.")
	private String customerLastName = "Trybus";

	@NotEmpty(message = "Email nie mo�e by� pusty.")
	@Email(message = "niepoprawny format")
	private String customerEmail = "krzysztoftrybustest@gmail.com";

	private String customerPhone = "123 456 789";

	@NotEmpty(message = "Nazwa u�ytkownika nie mo�e by� pusta.")
	private String username = "krzysztof.t";
	@NotEmpty(message = "Has�o nie mo�e by� puste.")
	private String password = "krzysztof123";

	private boolean enabled = true;
	
	@OneToOne
	@JoinColumn(name="billingAddressId")
	private BillingAddress billingAddress;
	
	@OneToOne
	@JoinColumn(name="shippingAddressId")
	private ShippingAddress shippingAddress;
	
	@OneToOne
	@JoinColumn(name="cartId")
	@JsonIgnore
	private Cart cart;
	

	@Test
	public void testGetCustomerId() {
		setCustomerId(customerId);
		assertEquals(customerId, getCustomerId());
		assertFalse("customerId".equals(getCustomerId()));
	}

	@Test
	public void testGetCustomerFirstName() {
		setCustomerFirstName(customerFirstName);
		assertEquals(customerFirstName, getCustomerFirstName());
		assertFalse("Tadeus".equals(getCustomerFirstName()));
	}

	@Test
	public void testGetCustomerLastName() {
		setCustomerLastName(customerLastName);
		assertEquals(customerLastName, getCustomerLastName());
		assertFalse("Tkaczyk".equals(getCustomerLastName()));
	}

	@Test
	public void testGetCustomerEmail() {
		setCustomerEmail(customerEmail);
		assertEquals(customerEmail, getCustomerEmail());
		assertFalse("trybuskrzysztoftest@gmail.com".equals(getCustomerEmail()));
	}

	@Test
	public void testGetCustomerPhone() {
		setCustomerPhone(customerPhone);
		assertEquals(customerPhone, getCustomerPhone());
		assertFalse("customerId".equals(getCustomerPhone()));
	}

	@Test
	public void testGetUsername() {
		setUsername(username);
		assertEquals(username, getUsername());
		assertFalse("krzysztoft".equals(getUsername()));
	}

	@Test
	public void testGetPassword() {
		setPassword(password);
		assertEquals(password, getPassword());
		assertFalse(username.equals(getPassword()));
	}

	@Test
	public void testIsEnabled() {
		setEnabled(enabled);
		assertEquals(enabled, isEnabled());
		assertFalse(!isEnabled());
	}

}
