package pl.edu.pw.ii.eshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Klasa reprezentuj�ca encj� SHIPPINGADDRESS, adres dostawy.
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
	 * Metoda zwracaj�ca klucz g��wny
	 * 
	 * @return klucz g��wny
	 */
	public int getBillingAddressId() {
		return billingAddressId;
	}

	/**
	 * Metoda ustawiaj�ca klucz g��wny
	 * 
	 * @param billingAddressId
	 *            klucz g��wny
	 */
	public void setBillingAddressId(int billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	/**
	 * Metoda zwracaj�ca nazw� ulicy.
	 * 
	 * @return nazwa ulicy
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Metoda ustawiaj�ca nazw� ulicy adresu dostawy
	 * 
	 * @param street
	 *            nazwa ulicy adresu dostawy
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Metoda zwracaj�ca numer domu/mieszkania adresu dostawy
	 * 
	 * @return numer domu/mieszkania adresu dostawy
	 */
	public String getApartmentNumber() {
		return apartmentNumber;
	}

	/**
	 * Metoda ustawiaj�ca numer domu/mieszkania adresu dostawy
	 * 
	 * @param apartmentNumber
	 *            numer domu/mieszkania adresu dostawy
	 */
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	/**
	 * Metoda zwracaj�ca miasto adresu dostawy
	 * 
	 * @return miasto adresu dostawy
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Metoda ustawiaj�ca miasto adresu dostawy
	 * 
	 * @param city
	 *            miasto adresu dostawy
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Metoda zwracaj�ca kod pocztowy adresu dostawy
	 * 
	 * @return kod pocztowy adresu dostawy
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Metoda ustawiaj�ca kod pocztowy adresu dostawy
	 * 
	 * @param zipCode
	 *            kod pocztowy adresu dostawy
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Metoda zwracaj�ca klienta, kt�rego dotyczy adres dostawy.
	 * 
	 * @return klient {@link Customer} , kt�rego dotyczy adres dostawy.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Metoda ustawiaj�ca klienta, kt�rego dotyczy adres dostawy.
	 * 
	 * @param customer
	 *            klient {@link Customer}, kt�rego dotyczy adres dostawy.
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
