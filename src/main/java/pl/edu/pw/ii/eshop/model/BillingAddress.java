package pl.edu.pw.ii.eshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Klasa reprezentuj�ca adres do wystawienia faktury za zakup. Jest to encja
 * reprezentowana jako tabela BILLINADDRESS
 * 
 * @author LucaR
 *
 */
@Entity
public class BillingAddress implements Serializable {

	private static final long serialVersionUID = -1558789023364843365L;
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
	 * Konstruktor bezparametrowy
	 */
	public BillingAddress() {
	}

	/**
	 * Metoda zwraca id adresu
	 * 
	 * @return id adresu
	 */
	public int getBillingAddressId() {
		return billingAddressId;
	}

	/**
	 * Metoda ustawia id adresu
	 * 
	 * @param billingAddressId
	 */
	public void setBillingAddressId(int billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	/**
	 * Metoda zwracaj�ca nazw� ulicy
	 * 
	 * @return nazwa ulicy
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Metoda ustawiaj�ca nazw� ulicy
	 * 
	 * @param street
	 *            nazwa ulicy
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Metoda zwracaj�ca numer domu/mieszkania w postaci �a�cucha.
	 * 
	 * @return numer domu/mieszkania
	 */
	public String getApartmentNumber() {
		return apartmentNumber;
	}

	/**
	 * Metoda ustawiaj�ca numer domu/mieszkania.
	 * 
	 * @param apartmentNumber
	 *            numer domu/mieszkania
	 */
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	/**
	 * Metoda pobieraj�ca nazw� miasta.
	 * 
	 * @return nazwma miasta.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Metoda ustawiaj�ca nazw� miasta.
	 * 
	 * @param city
	 *            nazwa miasta.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Metoda zwracaj�ca kod pocztowy w postaci �a�cucha.
	 * 
	 * @return kod pocztowy
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Metoda ustawiaj�ca kod pocztowy.
	 * 
	 * @param zipCode
	 *            kod pocztowy.
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Metoda zwracaj�ca klienta, do kt�rego jest przypisany adres.
	 * 
	 * @return Klient, do kt�rego jest przypisany adres.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Metoda przypisuj�ca klienta {@link Customer} do adresu.
	 * 
	 * @param customer
	 *            klient sklepu.
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "BillingAddress [billingAddressId=" + billingAddressId + ", street=" + street + ", apartmentNumber="
				+ apartmentNumber + ", city=" + city + ", zipCode=" + zipCode + "]";
	}

	
}
