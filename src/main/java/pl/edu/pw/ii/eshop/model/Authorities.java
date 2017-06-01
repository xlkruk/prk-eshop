package pl.edu.pw.ii.eshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Klasa na potrzeby Spring Security. Przetrzymuje informacje o nazwie
 * użytkownika oraz o przypisanej mu roli
 * 
 * @author Łukasz Kruk
 *
 */

@Entity
public class Authorities {

	@Id
	@GeneratedValue
	private int authoritiesId;
	private String username;
	/**
	 * rola użytkownika
	 */
	private String authority;

	public int getAuthoritiesId() {
		return authoritiesId;
	}

	public void setAuthoritiesId(int authoritiesId) {
		this.authoritiesId = authoritiesId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
