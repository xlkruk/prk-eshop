package model;

import static org.junit.Assert.*;

import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;
import pl.edu.pw.ii.eshop.model.CustomerInfo;

/**
 * @author Krzysztof Trybus
 * @version 1.0
 *
 */

public class CustomerInfoTest extends CustomerInfo{
	private int customerId = 9876;

	@NotEmpty(message = "Imi� nie mo�e by� puste.")
	private String customerFirstName = "Krzysztof";

	@NotEmpty(message = "Nazwisko nie mo�e by� puste.")
	private String customerLastName = "Trybus";

	@NotEmpty(message = "Email nie mo�e by� pusty.")
	private String customerEmail = "krzysztoftrybustest@gmail.com";

	private String customerPhone = "123 456 789";

	@NotEmpty(message = "Nazwa u�ytkownika nie mo�e by� pusta.")
	private String username = "krzysztof.t";

	private String password= "krzysztof123";

	private boolean enabled = true;
	private boolean disabled = false;

	@NotEmpty(message = "Pole nie mo�e by� puste.")
	private String billingStreet = "1 Maja";
	@NotEmpty(message = "Pole nie mo�e by� puste.")
	private String billingApartmentNumber = "1/2";
	@NotEmpty(message = "Pole nie mo�e by� puste.")
	private String billingCity = "Warsaw";
	@NotEmpty(message = "Pole nie mo�e by� puste.")
	private String billingZipCode = "01-234";

	@NotEmpty(message = "Pole nie mo�e by� puste.")
	private String shippingStreet = "1 Maja";
	@NotEmpty(message = "Pole nie mo�e by� puste.")
	private String shippingApartmentNumber = "1/2";
	@NotEmpty(message = "Pole nie mo�e by� puste.")
	private String shippingCity = "Warsaw";
	@NotEmpty(message = "Pole nie mo�e by� puste.")
	private String shippingZipCode = "01-234";

	@Test
	public void testGetCustomerId() {
		setCustomerId(customerId);
		assertEquals(customerId, getCustomerId());
		assertFalse("43535".equals(getCustomerId()));
	}

	@Test
	public void testGetCustomerFirstName() {
		setCustomerFirstName(customerFirstName);
		assertEquals(customerFirstName, getCustomerFirstName());
		assertFalse("Marek".equals(getCustomerFirstName()));
	}

	@Test
	public void testGetCustomerLastName() {
		setCustomerLastName(customerLastName);
		assertEquals(customerLastName, getCustomerLastName());
		assertFalse("Trybuss".equals(getCustomerLastName()));
	}

	@Test
	public void testGetCustomerEmail() {
		setCustomerEmail(customerEmail);
		assertEquals(customerEmail, getCustomerEmail());
		assertFalse("krzysztoftrybustest.gmail.com".equals(getCustomerEmail()));
	}

	@Test
	public void testGetCustomerPhone() {
		setCustomerPhone(customerPhone);
		assertEquals(customerPhone, getCustomerPhone());
		assertFalse("123 456 89".equals(getCustomerPhone()));
	}

	@Test
	public void testGetUsername() {
		setUsername(username);
		assertEquals(username, getUsername());
		assertFalse(password.equals(getUsername()));
	}

	@Test
	public void testGetPassword() {
		setPassword(password);
		assertEquals(password, getPassword());
		assertFalse(username.equals(getUsername()));
	}
	
	@Test
	public void testIsEnabled() {
		setEnabled(enabled);
		assertEquals(enabled, isEnabled());
		assertFalse(!isEnabled());
	}

	@Test
	public void testGetBillingStreet() {
		setBillingStreet(billingStreet);
		assertEquals(billingStreet, getBillingStreet());
		assertFalse("billingStreet".equals(getBillingStreet()));
	}

	@Test
	public void testGetBillingApartmentNumber() {
		setBillingApartmentNumber(billingApartmentNumber);
		assertEquals(billingApartmentNumber, getBillingApartmentNumber());
		assertFalse("billingApartmentNumber".equals(getBillingApartmentNumber()));
	}

	@Test
	public void testGetBillingCity() {
		setBillingCity(billingCity);
		assertEquals(billingCity, getBillingCity());
		assertFalse("Warszawa".equals(getBillingCity()));
	}

	@Test
	public void testGetBillingZipCode() {
		setBillingZipCode(billingZipCode);
		assertEquals(billingZipCode, getBillingZipCode());
		assertFalse("01234".equals(getBillingZipCode()));
	}

	@Test
	public void testGetShippingStreet() {
		setShippingStreet(shippingStreet);
		assertEquals(shippingStreet, getShippingStreet());
		assertFalse("Maja".equals(getBillingCity()));
	}

	@Test
	public void testGetShippingApartmentNumber() {
		setShippingApartmentNumber(shippingApartmentNumber);
		assertEquals(shippingApartmentNumber, getShippingApartmentNumber());
		assertFalse("12".equals(getShippingApartmentNumber()));
	}

	@Test
	public void testGetShippingCity() {
		setShippingCity(shippingCity);
		assertEquals(shippingCity, getShippingCity());
		assertFalse("Warszawa".equals(getBillingCity()));
	}

	@Test
	public void testGetShippingZipCode() {
		setShippingZipCode(shippingZipCode);
		assertEquals(shippingZipCode, getShippingZipCode());
		assertFalse("00-111".equals(getBillingCity()));
	}

}
