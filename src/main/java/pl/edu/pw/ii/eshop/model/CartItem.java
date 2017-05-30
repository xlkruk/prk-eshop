package pl.edu.pw.ii.eshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Klasa reprezentuj¹ca encjê CARTITEM, liniê agregacyjn¹ koszyka.
 * 
 * @author £ukasz Kruk
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
	@JsonIgnore // potrzebne aby nie zapêtlaæ budowy JSOna
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
	 * Metoda zwracaj¹ca id linii agregacyjnej.
	 * 
	 * @return id linii agreguj¹cej koszyka.
	 */
	public int getCartItemId() {
		return cartItemId;
	}

	/**
	 * Metoda ustawiaj¹ca id linii agreguj¹cej koszyka.
	 * 
	 * @param cartItemId
	 *            id linii agreguj¹cej koszyka.
	 */
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	/**
	 * Metoda zwracaj¹ca koszyk {@link Cart}, do którego jest przypisana linia
	 * agregacyjna.
	 * 
	 * @return koszyk {@link Cart}
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * Metoda ustawiaj¹ca koszyk {@link Cart}, do którego jest przypisana linia
	 * agregacyjna.
	 * 
	 * @param cart
	 *            koszyk {@link Cart}
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/**
	 * Metoda ustawiaj¹ca produkt {@link Product}, którego dotyczy linia
	 * agregacyjna.
	 * 
	 * @return produkt {@link Product}
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Metoda ustawiaj¹ca produkt, którego ma dotyczyæ ta linia agregacyjna.
	 * 
	 * @param product
	 *            produkt {@link Product}
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Metoda zwracaj¹ca iloœæ produktów na danej linii agregacyjnej.
	 * 
	 * @return iloœæ produktów.
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Metoda ustawiaj¹ca iloœæ produktów na danej linii agregacyjnej koszyka.
	 * 
	 * @param quantity
	 *            iloœæ produktów {@link Product}.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Metoda zwracaj¹ca cenê danej linii agregacyjnej.
	 * 
	 * @return cena linii agregacyjnej.
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Metoda ustawiaj¹ca cenê brutto dla linii agregacyjnej.
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
