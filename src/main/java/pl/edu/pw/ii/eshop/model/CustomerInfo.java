package pl.edu.pw.ii.eshop.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Klasa pomocnicza reprezentująca informacje o kliencie. Klasa użyana w
 * warstwie prezentacji.
 * 
 * @author Krzysztof Trybus
 *
 */
public class CustomerInfo {

	private int customerId;

	@NotEmpty(message = "Imię nie może być puste.")
	private String customerFirstName;

	@NotEmpty(message = "Nazwisko nie może być puste.")
	private String customerLastName;

	@NotEmpty(message = "Email nie może być pusty.")
	@Email(message = "Nieprawidłowy email")
	private String customerEmail;

	private String customerPhone;

	@NotEmpty(message = "Nazwa użytkownika nie może być pusta.")
	private String username;

	private String password;

	private boolean enabled;

	@NotEmpty(message = "Pole nie może być puste.")
	private String billingStreet;
	@NotEmpty(message = "Pole nie może być puste.")
	private String billingApartmentNumber;
	@NotEmpty(message = "Pole nie może być puste.")
	private String billingCity;
	@NotEmpty(message = "Pole nie może być puste.")
	private String billingZipCode;

	@NotEmpty(message = "Pole nie może być puste.")
	private String shippingStreet;
	@NotEmpty(message = "Pole nie może być puste.")
	private String shippingApartmentNumber;
	@NotEmpty(message = "Pole nie może być puste.")
	private String shippingCity;
	@NotEmpty(message = "Pole nie może być puste.")
	private String shippingZipCode;

	/**
	 * Konstruktor bezparametryczny.
	 */
	public CustomerInfo() {

	}

	/**
	 * Metoda zwracająca id klienta, którego dotyczą informacje
	 * 
	 * @return id klienta
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Metoda ustawiająca id klienta, którego dotyczą informacje.
	 * 
	 * @param customerId
	 *            id klienta
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * Metoda zwracajca imię klienta.
	 * 
	 * @return imię klienta
	 */
	public String getCustomerFirstName() {
		return customerFirstName;
	}

	/**
	 * Metoda ustawiająca imię klienta
	 * 
	 * @param customerFirstName
	 *            imię klienta
	 */
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	/**
	 * Metoda zwracająca nazwisko klienta.
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
	 * Metoda zwracająca adres email klienta
	 * 
	 * @return adres email klienta.
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * Metoda ustawiająca adres email klienta
	 * 
	 * @param customerEmail
	 *            adres email klienta
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * Metoda zwracająca numer telefonu klienta
	 * 
	 * @return numer telefonu
	 */
	public String getCustomerPhone() {
		return customerPhone;
	}

	/**
	 * Metoda ustawiająca numer telefonu klienta.
	 * 
	 * @param customerPhone
	 *            numer telefonu klienta.
	 */
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	/**
	 * Metoda zwracająca login klienta
	 * 
	 * @return login klienta
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Metoda ustawiająca login klienta.
	 * 
	 * @param username
	 *            login klienta
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Metoda zwracająca hasło klienta.
	 * 
	 * @return hasło klienta
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Metoda ustawiająca hasło klienta
	 * 
	 * @param password
	 *            hasło klienta
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Metoda zwracajaca status klienta
	 * 
	 * @return status klienta - true aktywny
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Metoda ustawiająca status klienta
	 * 
	 * @param enabled
	 *            status klienta - true aktywny
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Metoda zwracająca ulicę adresu do faktury
	 * 
	 * @return ulica adresu do faktury
	 */
	public String getBillingStreet() {
		return billingStreet;
	}

	/**
	 * Metoda ustawiająca nzawę ulicy do faktury.
	 * 
	 * @param billingStreet
	 *            nazwa ulicy adresu do faktury.
	 */
	public void setBillingStreet(String billingStreet) {
		this.billingStreet = billingStreet;
	}

	/**
	 * Metoda zwracająca numer domu/mieszkania adresu do faktury
	 * 
	 * @return numer domu/mieszkania adresu do faktury
	 */
	public String getBillingApartmentNumber() {
		return billingApartmentNumber;
	}

	/**
	 * Metoda ustawiająca numer domu/mieszkania adresu do faktury
	 * 
	 * @param billingApartmentNumber
	 *            numer domu/mieszkania adresu do faktury
	 */
	public void setBillingApartmentNumber(String billingApartmentNumber) {
		this.billingApartmentNumber = billingApartmentNumber;
	}

	/**
	 * Metoda zwracająca nzawę miasta adresu do faktury
	 * 
	 * @return nazwa miasta adresu do faktury
	 */
	public String getBillingCity() {
		return billingCity;
	}

	/**
	 * Metoda ustawiająca nzawę miasta adresu do faktury
	 * 
	 * @param billingCity
	 *            nazwa miasta adresu do faktury
	 */
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	/**
	 * Metoda zwracająca kod pocztowy adresu do faktury
	 * 
	 * @return kod pocztowy adresu do faktury
	 */
	public String getBillingZipCode() {
		return billingZipCode;
	}

	/**
	 * Metoda ustawiająca kod pocztowy adresu do faktury
	 * 
	 * @param billingZipCode
	 *            kod pocztowy adresu do faktury
	 */
	public void setBillingZipCode(String billingZipCode) {
		this.billingZipCode = billingZipCode;
	}

	/**
	 * Metoda zwracająca nzawę ulicy adresu dostawy
	 * 
	 * @return nazwa ulicy adresu dostawy
	 */
	public String getShippingStreet() {
		return shippingStreet;
	}

	/**
	 * Metoda ustawiająca nzawę ulicy adresu dostawy
	 * 
	 * @param shippingStreet
	 *            nzawę ulicy adresu dostawy
	 */
	public void setShippingStreet(String shippingStreet) {
		this.shippingStreet = shippingStreet;
	}

	/**
	 * Metoda zwracająca numer domu/mieszkania adresu dostawy
	 * 
	 * @return numer domu/mieszkania adresu dostawy
	 */
	public String getShippingApartmentNumber() {
		return shippingApartmentNumber;
	}

	/**
	 * Metoda ustawiająca numer domu/mieszkania adresu dostawy
	 * 
	 * @param shippingApartmentNumber
	 *            numer domu/mieszkania adresu dostawy
	 */
	public void setShippingApartmentNumber(String shippingApartmentNumber) {
		this.shippingApartmentNumber = shippingApartmentNumber;
	}

	/**
	 * Metoda zwracająca miasto dostawy
	 * 
	 * @return miasto dostawy
	 */
	public String getShippingCity() {
		return shippingCity;
	}

	/**
	 * Metoda ustawiająca miasto dostawy
	 * 
	 * @param shippingCity
	 *            miasto dostawy
	 */
	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	/**
	 * Metoda zwracająca kod pocztowy dostawy
	 * 
	 * @return kod pocztowy dostawy
	 */
	public String getShippingZipCode() {
		return shippingZipCode;
	}

	/**
	 * Metoda zwracająca kod pocztowy dostawy
	 * 
	 * @param shippingZipCode
	 *            kod pocztowy dostawy
	 */
	public void setShippingZipCode(String shippingZipCode) {
		this.shippingZipCode = shippingZipCode;
	}

	/**
	 * Metoda ustawiająca atrybuty obiektu {@link CustomerInfo} na podstawie
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
