package model;

import static org.junit.Assert.*;

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
	}

	@Test
	public void testGetStreet() {
		setStreet(street);
		assertEquals(street,getStreet());	
	}

	@Test
	public void testGetApartmentNumber() {
		setApartmentNumber(apartmentNumber);
		assertEquals(apartmentNumber,getApartmentNumber());	
	}

	@Test
	public void testGetCity() {
		setCity(city);
		assertEquals(city,getCity());	
	}

	@Test
	public void testGetZipCode() {
		setZipCode(zipCode);
		assertEquals(zipCode,getZipCode());
	}


	@Test
	public void testToString() {
		assertEquals("BillingAddress [billingAddressId=12345, street=1 Maja, apartmentNumber=1/2, city=Warsaw, zipCode=01-234]",
					"BillingAddress [billingAddressId=" + billingAddressId + ", street=" + street + ", apartmentNumber="
					+ apartmentNumber + ", city=" + city + ", zipCode=" + zipCode + "]");
	}

}
