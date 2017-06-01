package pl.edu.pw.ii.eshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Klasa reprezentująca encję CARTITEM, linię agregacyjną koszyka.
 * 
 * @author Łukasz Kruk
 *
 */
@Entity
public class CartItem implements Serializable {

	private static final long serialVersionUID = 1031671822500452085L;

	@Id
	@GeneratedValue
	private int cartItemId;

	@ManyToOne
	@JoinColumn(name = "cartId")
	@JsonIgnore // potrzebne aby nie zapętlać budowy JSOna
	private Cart cart;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;

	private int quantity;
	private double totalPrice;

	/**
	 * Konstruktor bezparametryczny.
	 */
	public CartItem() {
	}

	/**
	 * Metoda zwracająca id linii agregacyjnej.
	 * 
	 * @return id linii agregującej koszyka.
	 */
	public int getCartItemId() {
		return cartItemId;
	}

	/**
	 * Metoda ustawiająca id linii agregującej koszyka.
	 * 
	 * @param cartItemId
	 *            id linii agregującej koszyka.
	 */
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	/**
	 * Metoda zwracająca koszyk {@link Cart}, do którego jest przypisana linia
	 * agregacyjna.
	 * 
	 * @return koszyk {@link Cart}
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * Metoda ustawiająca koszyk {@link Cart}, do którego jest przypisana linia
	 * agregacyjna.
	 * 
	 * @param cart
	 *            koszyk {@link Cart}
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/**
	 * Metoda ustawiająca produkt {@link Product}, którego dotyczy linia
	 * agregacyjna.
	 * 
	 * @return produkt {@link Product}
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Metoda ustawiająca produkt, którego ma dotyczyć ta linia agregacyjna.
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Metoda zwracająca ilość produktów na danej linii agregacyjnej.
	 * 
	 * @return ilość produktów.
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Metoda ustawiająca ilość produktów na danej linii agregacyjnej koszyka.
	 * 
	 * @param quantity
	 *            ilość produktów {@link Product}.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Metoda zwracająca cenę danej linii agregacyjnej.
	 * 
	 * @return cena linii agregacyjnej.
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Metoda ustawiająca cenę brutto dla linii agregacyjnej.
	 * 
	 * @param totalPrice
	 *            cena produktów na linii agregacyjnej.
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", cart=" + cart + ", product=" + product + ", quantity="
				+ quantity + ", totalPrice=" + totalPrice + "]";
	}

	
}
