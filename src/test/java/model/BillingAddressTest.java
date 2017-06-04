package model;

import static org.junit.Assert.*;

/**
 * @author Krzysztof Trybus
 * @version 1.0
 *
 */

import org.junit.Test;
import pl.edu.pw.ii.eshop.model.BillingAddress;

public class BillingAddressTest extends BillingAddress{
	private static final long serialVersionUID = -1558789023364843365L;
    private int billingAddressId = 12345;
    private String street = "1 Maja";
    private String apartmentNumber = "1/2";
    private String city = "Warsaw";
    private String zipCode = "01-234";

	@Test
	public void testGetBillingAddressId() {
		setBillingAddressId(billingAddressId);
		assertEquals(billingAddressId,getBillingAddressId());
		assertFalse("92387".equals(getBillingAddressId()));	
	}

	@Test
	public void testGetStreet() {
		setStreet(street);
		assertEquals(street,getStreet());
		assertFalse("Test Maja".equals(getStreet()));
	}

	@Test
	public void testGetApartmentNumber() {
		setApartmentNumber(apartmentNumber);
		assertEquals(apartmentNumber,getApartmentNumber());	
		assertFalse("9/6".equals(getStreet()));
	}

	@Test
	public void testGetCity() {
		setCity(city);
		assertEquals(city,getCity());
		assertFalse("Warsaw".equals(getStreet()));
	}

	@Test
	public void testGetZipCode() {
		setZipCode(zipCode);
		assertEquals(zipCode,getZipCode());
		assertFalse("02-123".equals(getStreet()));
	}


	@Test
	public void testToString() {
		assertEquals("BillingAddress [billingAddressId=12345, street=1 Maja, apartmentNumber=1/2, city=Warsaw, zipCode=01-234]",
					"BillingAddress [billingAddressId=" + billingAddressId + ", street=" + street + ", apartmentNumber="
					+ apartmentNumber + ", city=" + city + ", zipCode=" + zipCode + "]");
	}

}
