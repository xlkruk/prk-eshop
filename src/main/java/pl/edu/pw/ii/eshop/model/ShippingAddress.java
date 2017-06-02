package pl.edu.pw.ii.eshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Klasa reprezentująca encję SHIPPINGADDRESS, adres dostawy.
 * 
 * @author Krzysztof Trybus
 *
 */
@Entity
public class ShippingAddress implements Serializable {

	private static final long serialVersionUID = 6878764671149014282L;

	@Id
	@GeneratedValue
	private int billingAddressId;
	private String street;
	private String apartmentNumber;
	private String city;
	private String zipCode;

	@OneToOne
	private Customer customer;
	
	@OneToOne
	private Order order;

	/**
	 * Konstruktor bezparametryczny.
	 */
	public ShippingAddress() {
	}
	
	

	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}



	/**
	 * Metoda zwracająca klucz główny
	 * 
	 * @return klucz główny
	 */
	public int getBillingAddressId() {
		return billingAddressId;
	}

	/**
	 * Metoda ustawiająca klucz główny
	 * 
	 * @param billingAddressId
	 *            klucz główny
	 */
	public void setBillingAddressId(int billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	/**
	 * Metoda zwracająca nazwę ulicy.
	 * 
	 * @return nazwa ulicy
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Metoda ustawiająca nazwę ulicy adresu dostawy
	 * 
	 * @param street
	 *            nazwa ulicy adresu dostawy
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Metoda zwracająca numer domu/mieszkania adresu dostawy
	 * 
	 * @return numer domu/mieszkania adresu dostawy
	 */
	public String getApartmentNumber() {
		return apartmentNumber;
	}

	/**
	 * Metoda ustawiająca numer domu/mieszkania adresu dostawy
	 * 
	 * @param apartmentNumber
	 *            numer domu/mieszkania adresu dostawy
	 */
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	/**
	 * Metoda zwracająca miasto adresu dostawy
	 * 
	 * @return miasto adresu dostawy
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Metoda ustawiająca miasto adresu dostawy
	 * 
	 * @param city
	 *            miasto adresu dostawy
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Metoda zwracająca kod pocztowy adresu dostawy
	 * 
	 * @return kod pocztowy adresu dostawy
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Metoda ustawiająca kod pocztowy adresu dostawy
	 * 
	 * @param zipCode
	 *            kod pocztowy adresu dostawy
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Metoda zwracająca klienta, którego dotyczy adres dostawy.
	 * 
	 * @return klient {@link Customer}, którego dotyczy adres dostawy.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Metoda ustawiająca klienta, którego dotyczy adres dostawy.
	 * 
	 * @param customer
	 *            klient {@link Customer}, którego dotyczy adres dostawy.
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "ShippingAddress [billingAddressId=" + billingAddressId + ", street=" + street + ", apartmentNumber="
				+ apartmentNumber + ", city=" + city + ", zipCode=" + zipCode + "]";
	}

}
