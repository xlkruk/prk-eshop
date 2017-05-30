package pl.edu.pw.ii.eshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Klasa reprezentuj�ca encj� CARTITEM, lini� agregacyjn� koszyka.
 * 
 * @author �ukasz Kruk
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
	@JsonIgnore // potrzebne aby nie zap�tla� budowy JSOna
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
	 * Metoda zwracaj�ca id linii agregacyjnej.
	 * 
	 * @return id linii agreguj�cej koszyka.
	 */
	public int getCartItemId() {
		return cartItemId;
	}

	/**
	 * Metoda ustawiaj�ca id linii agreguj�cej koszyka.
	 * 
	 * @param cartItemId
	 *            id linii agreguj�cej koszyka.
	 */
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	/**
	 * Metoda zwracaj�ca koszyk {@link Cart}, do kt�rego jest przypisana linia
	 * agregacyjna.
	 * 
	 * @return koszyk {@link Cart}
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * Metoda ustawiaj�ca koszyk {@link Cart}, do kt�rego jest przypisana linia
	 * agregacyjna.
	 * 
	 * @param cart
	 *            koszyk {@link Cart}
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/**
	 * Metoda ustawiaj�ca produkt {@link Product}, kt�rego dotyczy linia
	 * agregacyjna.
	 * 
	 * @return produkt {@link Product}
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Metoda ustawiaj�ca produkt, kt�rego ma dotyczy� ta linia agregacyjna.
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Metoda zwracaj�ca ilo�� produkt�w na danej linii agregacyjnej.
	 * 
	 * @return ilo�� produkt�w.
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Metoda ustawiaj�ca ilo�� produkt�w na danej linii agregacyjnej koszyka.
	 * 
	 * @param quantity
	 *            ilo�� produkt�w {@link Product}.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Metoda zwracaj�ca cen� danej linii agregacyjnej.
	 * 
	 * @return cena linii agregacyjnej.
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Metoda ustawiaj�ca cen� brutto dla linii agregacyjnej.
	 * 
	 * @param totalPrice
	 *            cena produkt�w na linii agregacyjnej.
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
