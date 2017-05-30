package pl.edu.pw.ii.eshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Klasa reprezentująca encję CUSTOMER, klienta sklepu.
 * 
 * @author Krzysztof Trybus
 *
 */
@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 7259919964084234579L;

	@Id
	@GeneratedValue
	private int customerId;

	@NotEmpty(message = "Imię nie może być puste.")
	private String customerFirstName;

	@NotEmpty(message = "Nazwisko nie może być puste.")
	private String customerLastName;

	@NotEmpty(message = "Email nie może być pusty.")
	@Email(message = "niepoprawny format")
	private String customerEmail;

	private String customerPhone;

	@NotEmpty(message = "Nazwa użytkownika nie może być pusta.")
	private String username;
	@NotEmpty(message = "Hasło nie może być puste.")
	private String password;

	private boolean enabled;

	@OneToOne
	@JoinColumn(name = "billingAddressId")
	private BillingAddress billingAddress;

	@OneToOne
	@JoinColumn(name = "shippingAddressId")
	private ShippingAddress shippingAddress;

	@OneToOne
	@JoinColumn(name = "cartId")
	@JsonIgnore
	private Cart cart;

	/**
	 * Konstruktor bezparametryczny. Inicjuje adres do faktury, adres do wysyłki
	 * oraz ustawia klienta jako aktywnego.
	 * 
	 */
	public Customer() {
		billingAddress = new BillingAddress();
		shippingAddress = new ShippingAddress();
		enabled = true;
	}

	/**
	 * Metoda zwracająca id klienta, klucz główny.
	 * 
	 * @return id klienta {@link Customer}
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Metoda ustawiająca id klienta
	 * 
	 * @param customerId
	 *            id klienta
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * Metoda zwracająca imię klienta.
	 * 
	 * @return imię klienta.
	 */
	public String getCustomerFirstName() {
		return customerFirstName;
	}

	/**
	 * Metoda ustawiająca imię klienta.
	 * 
	 * @param customerFirstName
	 *            imię klienta.
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
	 * Metoda ustawiająca nazwisko klienta
	 * 
	 * @param customerLastName
	 *            nazwisko klienta.
	 */
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	/**
	 * Metoda zwracająca adres email klienta.
	 * 
	 * @return adres email klienta.
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * Metoda ustawiająca adres email klienta.
	 * 
	 * @param customerEmail
	 *            adres email klienta.
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * Metoda zwracająca numer telefonu klienta.
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
	 *            numer telefonu.
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
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Metoda zwracajca hasło klienta
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
	 *            hasło klienta.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Metoda testujca czy klient jest aktywny. Obecnnie niewykorzystywana.
	 * 
	 * @return wynik testy=u czy klient jest aktywny.
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Metoda ustawiająca status klienta.
	 * 
	 * @param enabled
	 *            status czy klient jest aktywny.
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Metoda zwracająca adres do faktury klienta
	 * 
	 * @return adres do faktury
	 */
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	/**
	 * Metoda ustawiająca adres do faktury klienta.
	 * 
	 * @param billingAddress
	 *            adres do faktury.
	 */
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * Metoda zwracająca adres do dostawy.
	 * 
	 * @return adres dostawy
	 */
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * Metoda ustawiająca adres dostawy.
	 * 
	 * @param shippingingAddress
	 *            adres dostawy
	 */
	public void setShippingAddress(ShippingAddress shippingingAddress) {
		this.shippingAddress = shippingingAddress;
	}

	/**
	 * Metoda zwracająca koszyk klienta.
	 * 
	 * @return koszyk klienta
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * Metoda ustawiająca koszyk klienta.
	 * 
	 * @param cart
	 *            koszyk {@link Cart} klienta.
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerFirstName=" + customerFirstName + ", customerLastName="
				+ customerLastName + ", customerEmail=" + customerEmail + ", customerPhone=" + customerPhone
				+ ", username=" + username + ", password=" + password + ", enabled=" + enabled + ", billingAddress="
				+ billingAddress + ", shippingAddress=" + shippingAddress + ", cart=" + cart + "]";
	}

	
}
