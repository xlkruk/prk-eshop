package pl.edu.pw.ii.eshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Klasa reprezentuj¹ca encjê SHIPPINGADDRESS, adres dostawy.
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

	/**
	 * Konstruktor bezparametryczny.
	 */
	public ShippingAddress() {
	}

	/**
	 * Metoda zwracaj¹ca klucz g³ówny
	 * 
	 * @return klucz g³ówny
	 */
	public int getBillingAddressId() {
		return billingAddressId;
	}

	/**
	 * Metoda ustawiaj¹ca klucz g³ówny
	 * 
	 * @param billingAddressId
	 *            klucz g³ówny
	 */
	public void setBillingAddressId(int billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	/**
	 * Metoda zwracaj¹ca nazwê ulicy.
	 * 
	 * @return nazwa ulicy
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Metoda ustawiaj¹ca nazwê ulicy adresu dostawy
	 * 
	 * @param street
	 *            nazwa ulicy adresu dostawy
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Metoda zwracaj¹ca numer domu/mieszkania adresu dostawy
	 * 
	 * @return numer domu/mieszkania adresu dostawy
	 */
	public String getApartmentNumber() {
		return apartmentNumber;
	}

	/**
	 * Metoda ustawiaj¹ca numer domu/mieszkania adresu dostawy
	 * 
	 * @param apartmentNumber
	 *            numer domu/mieszkania adresu dostawy
	 */
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	/**
	 * Metoda zwracaj¹ca miasto adresu dostawy
	 * 
	 * @return miasto adresu dostawy
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Metoda ustawiaj¹ca miasto adresu dostawy
	 * 
	 * @param city
	 *            miasto adresu dostawy
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Metoda zwracaj¹ca kod pocztowy adresu dostawy
	 * 
	 * @return kod pocztowy adresu dostawy
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Metoda ustawiaj¹ca kod pocztowy adresu dostawy
	 * 
	 * @param zipCode
	 *            kod pocztowy adresu dostawy
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Metoda zwracaj¹ca klienta, którego dotyczy adres dostawy.
	 * 
	 * @return klient {@link Customer} , którego dotyczy adres dostawy.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Metoda ustawiaj¹ca klienta, którego dotyczy adres dostawy.
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
