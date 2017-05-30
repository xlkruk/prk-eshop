package pl.edu.pw.ii.eshop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Klasa reprezentuj¹ca encjê CART, koszyk klienta sklepu.
 * 
 * @author £ukasz Kruk
 *
 */
@Entity
public class Cart implements Serializable {

	private static final long serialVersionUID = -2776944850978772811L;

	/**
	 * Klucz g³ówny
	 */
	@Id
	@GeneratedValue
	private int cartId;

	/**
	 * Koszyk mo¿e zawieraæ wiele linii agreguj¹cych.
	 */
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CartItem> cartItems;

	/**
	 * Koszyk mo¿e byæ przypisany tylko do jednego klienta.
	 */
	@OneToOne
	@JoinColumn(name = "customerId")
	@JsonIgnore
	private Customer customer;

	/**
	 * Cena ca³kowita, nale¿noœæ za produkty.
	 */
	private double grantTotal;

	/**
	 * konstruktor bezparametryczny.
	 */
	public Cart() {
	}

	/**
	 * Metoda zwracaj¹ca id koszyka.
	 * 
	 * @return id koszyka.
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * Metoda ustawiaj¹ca id koszyka
	 * 
	 * @param cartId
	 *            id koszyka.
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/**
	 * Metoda zwracaj¹ca listê linii agreguj¹cych {@link CartItem}
	 * 
	 * @return lista liniii agreguj¹cych w koszyku.
	 */
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	/**
	 * Metoda ustawiaj¹ca listê linii agreguj¹cych w koszyku.
	 * 
	 * @param cartItems
	 *            lista linii agreguj¹cych koszyka.
	 */
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	/**
	 * Metoda zwracaj¹ca klienta {@link Customer} przypisanego do koszyka.
	 * 
	 * @return klient {@link Customer}
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Metoda przypisuj¹ca klienta do koszyka.
	 * 
	 * @param customer
	 *            klient {@link Customer}
	 * 
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Metoda zwracaj¹ca cenê ca³kowit¹ koszyka.
	 * 
	 * @return cena ca³kowita brutto.
	 */
	public double getGrantTotal() {
		return grantTotal;
	}

	/**
	 * Metoda ustawiaj¹ca cenê ca³kowit¹ koszyka.
	 * 
	 * @param grantTotal
	 *            cena ca³kowita brutto.
	 */
	public void setGrantTotal(double grantTotal) {
		this.grantTotal = grantTotal;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartItems=" + cartItems + ", customer=" + customer + ", grantTotal="
				+ grantTotal + "]";
	}

	
}
