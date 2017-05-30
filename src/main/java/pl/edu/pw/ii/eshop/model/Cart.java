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
 * Klasa reprezentuj�ca encj� CART, koszyk klienta sklepu.
 * 
 * @author �ukasz Kruk
 *
 */
@Entity
public class Cart implements Serializable {

	private static final long serialVersionUID = -2776944850978772811L;

	/**
	 * Klucz g��wny
	 */
	@Id
	@GeneratedValue
	private int cartId;

	/**
	 * Koszyk mo�e zawiera� wiele linii agreguj�cych.
	 */
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CartItem> cartItems;

	/**
	 * Koszyk mo�e by� przypisany tylko do jednego klienta.
	 */
	@OneToOne
	@JoinColumn(name = "customerId")
	@JsonIgnore
	private Customer customer;

	/**
	 * Cena ca�kowita, nale�no�� za produkty.
	 */
	private double grantTotal;

	/**
	 * konstruktor bezparametryczny.
	 */
	public Cart() {
	}

	/**
	 * Metoda zwracaj�ca id koszyka.
	 * 
	 * @return id koszyka.
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * Metoda ustawiaj�ca id koszyka
	 * 
	 * @param cartId
	 *            id koszyka.
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/**
	 * Metoda zwracaj�ca list� linii agreguj�cych {@link CartItem}
	 * 
	 * @return lista liniii agreguj�cych w koszyku.
	 */
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	/**
	 * Metoda ustawiaj�ca list� linii agreguj�cych w koszyku.
	 * 
	 * @param cartItems
	 *            lista linii agreguj�cych koszyka.
	 */
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	/**
	 * Metoda zwracaj�ca klienta {@link Customer} przypisanego do koszyka.
	 * 
	 * @return klient {@link Customer}
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Metoda przypisuj�ca klienta do koszyka.
	 * 
	 * @param customer
	 *            klient {@link Customer}
	 * 
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Metoda zwracaj�ca cen� ca�kowit� koszyka.
	 * 
	 * @return cena ca�kowita brutto.
	 */
	public double getGrantTotal() {
		return grantTotal;
	}

	/**
	 * Metoda ustawiaj�ca cen� ca�kowit� koszyka.
	 * 
	 * @param grantTotal
	 *            cena ca�kowita brutto.
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
