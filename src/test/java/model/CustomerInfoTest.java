package model;

import static org.junit.Assert.*;

import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;
import pl.edu.pw.ii.eshop.model.CustomerInfo;

public class CustomerInfoTest extends CustomerInfo{
	private int customerId = 9876;

	@NotEmpty(message = "Imiê nie mo¿e byæ puste.")
	private String customerFirstName = "Krzysztof";

	@NotEmpty(message = "Nazwisko nie mo¿e byæ puste.")
	private String customerLastName = "Trybus";

	@NotEmpty(message = "Email nie mo¿e byæ pusty.")
	private String customerEmail = "krzysztoftrybustest@gmail.com";

	private String customerPhone = "123 456 789";

	@NotEmpty(message = "Nazwa u¿ytkownika nie mo¿e byæ pusta.")
	private String username = "krzysztof.t";

	private String password= "krzysztof123";

	private boolean enabled = true;

	@NotEmpty(message = "Pole nie mo¿e byæ puste.")
	private String billingStreet = "1 Maja";
	@NotEmpty(message = "Pole nie mo¿e byæ puste.")
	private String billingApartmentNumber = "1/2";
	@NotEmpty(message = "Pole nie mo¿e byæ puste.")
	private String billingCity = "Warsaw";
	@NotEmpty(message = "Pole nie mo¿e byæ puste.")
	private String billingZipCode = "01-234";

	@NotEmpty(message = "Pole nie mo¿e byæ puste.")
	private String shippingStreet = "1 Maja";
	@NotEmpty(message = "Pole nie mo¿e byæ puste.")
	private String shippingApartmentNumber = "1/2";
	@NotEmpty(message = "Pole nie mo¿e byæ puste.")
	private String shippingCity = "Warsaw";
	@NotEmpty(message = "Pole nie mo¿e byæ puste.")
	private String shippingZipCode = "01-234";

	@Test
	public void testGetCustomerId() {
		setCustomerId(customerId);
		assertEquals(customerId, getCustomerId());
	}

	@Test
	public void testGetCustomerFirstName() {
		setCustomerFirstName(customerFirstName);
		assertEquals(customerFirstName, getCustomerFirstName());
	}

	@Test
	public void testGetCustomerLastName() {
		setCustomerLastName(customerLastName);
		assertEquals(customerLastName, getCustomerLastName());
	}

	@Test
	public void testGetCustomerEmail() {
		setCustomerEmail(customerEmail);
		assertEquals(customerEmail, getCustomerEmail());
	}

	@Test
	public void testGetCustomerPhone() {
		setCustomerPhone(customerPhone);
		assertEquals(customerPhone, getCustomerPhone());
	}

	@Test
	public void testGetUsername() {
		setUsername(username);
		assertEquals(username, getUsername());
	}

	@Test
	public void testGetPassword() {
		setPassword(password);
		assertEquals(password, getPassword());
	}
	
	@Test
	public void testIsEnabled() {
		setEnabled(enabled);
		assertEquals(enabled, isEnabled());
	}

	@Test
	public void testGetBillingStreet() {
		setBillingStreet(billingStreet);
		assertEquals(billingStreet, getBillingStreet());
	}

	@Test
	public void testGetBillingApartmentNumber() {
		setBillingApartmentNumber(billingApartmentNumber);
		assertEquals(billingApartmentNumber, getBillingApartmentNumber());
	}

	@Test
	public void testGetBillingCity() {
		setBillingCity(billingCity);
		assertEquals(billingCity, getBillingCity());
	}

	@Test
	public void testGetBillingZipCode() {
		setBillingZipCode(billingZipCode);
		assertEquals(billingZipCode, getBillingZipCode());
	}

	@Test
	public void testGetShippingStreet() {
		setShippingStreet(shippingStreet);
		assertEquals(shippingStreet, getShippingStreet());
	}

	@Test
	public void testGetShippingApartmentNumber() {
		setShippingApartmentNumber(shippingApartmentNumber);
		assertEquals(shippingApartmentNumber, getShippingApartmentNumber());
	}

	@Test
	public void testGetShippingCity() {
		setShippingCity(shippingCity);
		assertEquals(shippingCity, getShippingCity());
	}

	@Test
	public void testGetShippingZipCode() {
		setShippingZipCode(shippingZipCode);
		assertEquals(shippingZipCode, getShippingZipCode());
	}

}
