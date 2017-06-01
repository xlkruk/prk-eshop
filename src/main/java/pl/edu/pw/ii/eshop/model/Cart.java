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
 * Klasa reprezentująa encję CART, koszyk klienta sklepu.
 * 
 * @author Łukasz Kruk
 *
 */
@Entity
public class Cart implements Serializable {

	private static final long serialVersionUID = -2776944850978772811L;

	/**
	 * Klucz główny
	 */
	@Id
	@GeneratedValue
	private int cartId;

	/**
	 * Koszyk może zawieraćwiele linii agregujących.
	 */
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CartItem> cartItems;

	/**
	 * Koszyk może być przypisany tylko do jednego klienta.
	 */
	@OneToOne
	@JoinColumn(name = "customerId")
	@JsonIgnore
	private Customer customer;

	/**
	 * Cena całkowita, należność za produkty.
	 */
	private double grantTotal;

	/**
	 * konstruktor bezparametryczny.
	 */
	public Cart() {
	}

	/**
	 * Metoda zwracająca id koszyka.
	 * 
	 * @return id koszyka.
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * Metoda ustawiająca id koszyka
	 * 
	 * @param cartId
	 *            id koszyka.
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/**
	 * Metoda zwracająca listę linii agregujących {@link CartItem}
	 * 
	 * @return lista linii agregujących w koszyku.
	 */
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	/**
	 * Metoda ustawiająca listę linii agregujących w koszyku.
	 * 
	 * @param cartItems
	 *            lista linii agregujących koszyka.
	 */
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	/**
	 * Metoda zwracająca klienta {@link Customer} przypisanego do koszyka.
	 * 
	 * @return klient {@link Customer}
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Metoda przypisująca klienta do koszyka.
	 * 
	 * @param customer
	 *            klient {@link Customer}
	 * 
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Metoda zwracająca cenę całkowitą koszyka.
	 * 
	 * @return cena całkowita brutto.
	 */
	public double getGrantTotal() {
		return grantTotal;
	}

	/**
	 * Metoda ustawiająca cenę całkowitą koszyka.
	 * 
	 * @param grantTotal
	 *            cena całkowita brutto.
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
