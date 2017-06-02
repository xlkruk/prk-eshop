package pl.edu.pw.ii.eshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Klasa reprezentująca adres do wystawienia faktury za zakup. Jest to encja
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
	
	@OneToOne
	private Order order;

	/**
	 * Konstruktor bezparametrowy
	 */
	public BillingAddress() {
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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
	 * Metoda zwracająca nazwę ulicy
	 * 
	 * @return nazwa ulicy
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Metoda ustawiająca nazwę ulicy
	 * 
	 * @param street
	 *            nazwa ulicy
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Metoda zwracająca numer domu/mieszkania w postaci łańcucha.
	 * 
	 * @return numer domu/mieszkania
	 */
	public String getApartmentNumber() {
		return apartmentNumber;
	}

	/**
	 * Metoda ustawiająca numer domu/mieszkania.
	 * 
	 * @param apartmentNumber
	 *            numer domu/mieszkania
	 */
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	/**
	 * Metoda pobierają nazwę miasta.
	 * 
	 * @return nazwma miasta.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Metoda ustawiająca nazwę miasta.
	 * 
	 * @param city
	 *            nazwa miasta.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Metoda zwracająca kod pocztowy w postaci łańcucha.
	 * 
	 * @return kod pocztowy
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Metoda ustawiająca kod pocztowy.
	 * 
	 * @param zipCode
	 *            kod pocztowy.
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Metoda zwracająca klienta, do którego jest przypisany adres.
	 * 
	 * @return Klient, do którego jest przypisany adres.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Metoda przypisująca klienta {@link Customer} do adresu.
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
