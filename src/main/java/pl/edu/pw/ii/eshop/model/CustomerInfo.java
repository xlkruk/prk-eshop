package pl.edu.pw.ii.eshop.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Klasa pomocnicza reprezentuj�ca informacje o kliencie. Klasa u�yana w
 * warstwie prezentacji.
 * 
 * @author Krzysztof Trybus
 *
 */
public class CustomerInfo {

	private int customerId;

	@NotEmpty(message = "Imi� nie mo�e by� puste.")
	private String customerFirstName;

	@NotEmpty(message = "Nazwisko nie mo�e by� puste.")
	private String customerLastName;

	@NotEmpty(message = "Email nie mo�e by� pusty.")
	@Email(message = "Nieprawid�owy email")
	private String customerEmail;

	private String customerPhone;

	@NotEmpty(message = "Nazwa u�ytkownika nie mo�e by� pusta.")
	private String username;

	private String password;

	private boolean enabled;

	@NotEmpty(message = "Pole nie mo�e by� puste.")
	private String billingStreet;
	@NotEmpty(message = "Pole nie mo�e by� puste.")
	private String billingApartmentNumber;
	@NotEmpty(message = "Pole nie mo�e by� puste.")
	private String billingCity;
	@NotEmpty(message = "Pole nie mo�e by� puste.")
	private String billingZipCode;

	@NotEmpty(message = "Pole nie mo�e by� puste.")
	private String shippingStreet;
	@NotEmpty(message = "Pole nie mo�e by� puste.")
	private String shippingApartmentNumber;
	@NotEmpty(message = "Pole nie mo�e by� puste.")
	private String shippingCity;
	@NotEmpty(message = "Pole nie mo�e by� puste.")
	private String shippingZipCode;

	/**
	 * Konstruktor bezparametryczny.
	 */
	public CustomerInfo() {

	}

	/**
	 * Metoda zwracaj�ca id klienta, kt�rego dotycz� informacje
	 * 
	 * @return id klienta
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Metoda ustawiaj�ca id klienta, kt�rego dotzycz� informacje.
	 * 
	 * @param customerId
	 *            id klienta
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * Metoda zwracajca imi� klienta.
	 * 
	 * @return imi� klienta
	 */
	public String getCustomerFirstName() {
		return customerFirstName;
	}

	/**
	 * Metoda ustawiaj�ca imi� klienta
	 * 
	 * @param customerFirstName
	 *            imi� klienta
	 */
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	/**
	 * Metoda zwracaj�ca nazwisko klienta.
	 * 
	 * @return nazwisko klienta
	 */
	public String getCustomerLastName() {
		return customerLastName;
	}

	/**
	 * Metoda ustawiajaca nazwisko klienta
	 * 
	 * @param customerLastName
	 *            nazwisko klienta.
	 */
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	/**
	 * Metoda zwracaj�ca adres email klienta
	 * 
	 * @return adres email klienta.
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * Metoda ustawiaj�ca adres email klienta
	 * 
	 * @param customerEmail
	 *            adres email klienta
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * Metoda zwracaj�ca numer telefonu klienta
	 * 
	 * @return numer telefonu
	 */
	public String getCustomerPhone() {
		return customerPhone;
	}

	/**
	 * Metoda ustawiaj�ca numer telefonu klienta.
	 * 
	 * @param customerPhone
	 *            numer telefonu klienta.
	 */
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	/**
	 * Metoda zwracaj�ca login klienta
	 * 
	 * @return login klienta
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Metoda ustawiaj�ca login klienta.
	 * 
	 * @param username
	 *            login klienta
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Metoda zwracaj�ca has�o klienta.
	 * 
	 * @return has�o klienta
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Metoda ustawiaj�ca has�o klienta
	 * 
	 * @param password
	 *            has�o klienta
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * MEtoda zwracajac status klienta
	 * 
	 * @return status klienta - true aktywny
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Metoda ustawiaj�ca status klienta
	 * 
	 * @param enabled
	 *            status klienta - true aktywny
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Metoda zwracaj�ca ulic� adresu do faktury
	 * 
	 * @return ulica adresu do faktury
	 */
	public String getBillingStreet() {
		return billingStreet;
	}

	/**
	 * Metoda ustawiaj�ca nazw� ulicy do faktury.
	 * 
	 * @param billingStreet
	 *            nazwa ulicy adresu do faktury.
	 */
	public void setBillingStreet(String billingStreet) {
		this.billingStreet = billingStreet;
	}

	/**
	 * Metoda zwracaj�ca numer domu/mieszkania adresu do faktury
	 * 
	 * @return numer domu/mieszkania adresu do faktury
	 */
	public String getBillingApartmentNumber() {
		return billingApartmentNumber;
	}

	/**
	 * Metoda ustawiaj�ca numer domu/mieszkania adresu do faktury
	 * 
	 * @param billingApartmentNumber
	 *            numer domu/mieszkania adresu do faktury
	 */
	public void setBillingApartmentNumber(String billingApartmentNumber) {
		this.billingApartmentNumber = billingApartmentNumber;
	}

	/**
	 * Metoda zwracaj�ca nazw� miasta adresu do faktury
	 * 
	 * @return nazwa miasta adresu do faktury
	 */
	public String getBillingCity() {
		return billingCity;
	}

	/**
	 * Metoda ustawiaj�ca nazw� miasta adresu do faktury
	 * 
	 * @param billingCity
	 *            nazwa miasta adresu do faktury
	 */
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	/**
	 * Metoda zwracaj�ca kod pocztowy adresu do faktury
	 * 
	 * @return kod pocztowy adresu do faktury
	 */
	public String getBillingZipCode() {
		return billingZipCode;
	}

	/**
	 * Metoda ustawiaj�ca kod pocztowy adresu do faktury
	 * 
	 * @param billingZipCode
	 *            kod pocztowy adresu do faktury
	 */
	public void setBillingZipCode(String billingZipCode) {
		this.billingZipCode = billingZipCode;
	}

	/**
	 * Metoda zwracaj�ca nazw� ulicy adresu dostawy
	 * 
	 * @return nazwa ulicy adresu dostawy
	 */
	public String getShippingStreet() {
		return shippingStreet;
	}

	/**
	 * Metoda ustawiaj�ca nazw� ulicy adresu dostawy
	 * 
	 * @param shippingStreet
	 *            nazw� ulicy adresu dostawy
	 */
	public void setShippingStreet(String shippingStreet) {
		this.shippingStreet = shippingStreet;
	}

	/**
	 * Metoda zwracaj�ca numer domu/mieszkania adresu dostawy
	 * 
	 * @return numer domu/mieszkania adresu dostawy
	 */
	public String getShippingApartmentNumber() {
		return shippingApartmentNumber;
	}

	/**
	 * Metoda ustawiaj�ca numer domu/mieszkania adresu dostawy
	 * 
	 * @param shippingApartmentNumber
	 *            numer domu/mieszkania adresu dostawy
	 */
	public void setShippingApartmentNumber(String shippingApartmentNumber) {
		this.shippingApartmentNumber = shippingApartmentNumber;
	}

	/**
	 * Metoda zwracaj�ca miasto dostawy
	 * 
	 * @return miasto dostawy
	 */
	public String getShippingCity() {
		return shippingCity;
	}

	/**
	 * Metoda ustawiaj�ca miasto dostawy
	 * 
	 * @param shippingCity
	 *            miasto dostawy
	 */
	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	/**
	 * Metoda zwracaj�ca kod pocztowy dostawy
	 * 
	 * @return kod pocztowy dostawy
	 */
	public String getShippingZipCode() {
		return shippingZipCode;
	}

	/**
	 * Metoda zwracaj�ca kod pocztowy dostawy
	 * 
	 * @param shippingZipCode
	 *            kod pocztowy dostawy
	 */
	public void setShippingZipCode(String shippingZipCode) {
		this.shippingZipCode = shippingZipCode;
	}

	/**
	 * Metoda ustawiaj�ca atrybuty obiektu {@link CustomerInfo} na podstawie
	 * obiektu {@link Customer}
	 * 
	 * @param customer
	 *            klient {@link Customer}
	 */
	public CustomerInfo(Customer customer) {
		this.customerId = customer.getCustomerId();
		this.customerEmail = customer.getCustomerEmail();
		this.customerFirstName = customer.getCustomerFirstName();
		this.customerLastName = customer.getCustomerLastName();
		this.customerPhone = customer.getCustomerPhone();
		this.enabled = customer.isEnabled();
		this.username = customer.getUsername();
		this.password = customer.getPassword();

		this.billingCity = customer.getBillingAddress().getCity();
		this.billingApartmentNumber = customer.getBillingAddress().getApartmentNumber();
		this.billingStreet = customer.getBillingAddress().getStreet();
		this.billingZipCode = customer.getBillingAddress().getZipCode();

		this.shippingApartmentNumber = customer.getShippingAddress().getApartmentNumber();
		this.shippingCity = customer.getShippingAddress().getCity();
		this.shippingStreet = customer.getShippingAddress().getStreet();
		this.shippingZipCode = customer.getShippingAddress().getZipCode();

	}

	@Override
	public String toString() {
		return "CustomerInfo [customerId=" + customerId + ", customerFirstName=" + customerFirstName
				+ ", customerLastName=" + customerLastName + ", customerEmail=" + customerEmail + ", customerPhone="
				+ customerPhone + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", billingStreet=" + billingStreet + ", billingApartmentNumber=" + billingApartmentNumber
				+ ", billingCity=" + billingCity + ", billingZipCode=" + billingZipCode + ", shippingStreet="
				+ shippingStreet + ", shippingApartmentNumber=" + shippingApartmentNumber + ", shippingCity="
				+ shippingCity + ", shippingZipCode=" + shippingZipCode + "]";
	}

}
