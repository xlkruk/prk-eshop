package model;

import static org.junit.Assert.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import pl.edu.pw.ii.eshop.model.ShippingAddress;

import org.junit.Test;

public class ShippingAddressTest extends ShippingAddress{
	
	private static final long serialVersionUID = 6878764671149014282L;
	
	@Id
    @GeneratedValue
    private int billingAddressId = 923822224;
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
		setBillingAddressId(billingAddressId);
		assertEquals(billingAddressId,getBillingAddressId());
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
		assertEquals("ShippingAddress [billingAddressId=923822224, street=1 Maja, apartmentNumber=1/2, city=Warsaw, zipCode=01-234]","ShippingAddress [billingAddressId=" + billingAddressId + ", street=" + street + ", apartmentNumber="
						+ apartmentNumber + ", city=" + city + ", zipCode=" + zipCode + "]");
	}

}
