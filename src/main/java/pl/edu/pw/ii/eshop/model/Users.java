package pl.edu.pw.ii.eshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Klasa reprezentująca encję USERS, użytkowników systemu. Na potrzeby Spring
 * Security
 * 
 * @author Łukasz Kruk
 *
 */

@Entity
public class Users {

	@Id
	@GeneratedValue
	private int usersId;
	private String username;
	private String password;
	private boolean enabled;
	private int customerId;

	/**
	 * Metoda zwracająca id użytkownika
	 * 
	 * @return id użytkownika
	 */
	public int getUsersId() {
		return usersId;
	}

	/**
	 * Metoda ustawiająca id użytkownika
	 * 
	 * @param usersId
	 *            id użytkownika
	 */
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	/**
	 * Metoda zwracająca nazwę użytkowinika
	 * 
	 * @return nazwa użytkowinika
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Metoda ustawiająca nazwę użytkowinika
	 * 
	 * @param username
	 *            nazwa użytkowinika
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Metoda zwracająca hasło użytkownika
	 * 
	 * @return hasło użytkownika
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Metoda ustawiająca hasło użytkownika
	 * 
	 * @param password
	 *            hasło użytkownika
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Metoda testująca status użytkownika
	 * 
	 * @return status użytkownika - true aktywny
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Metoda ustawiająca status użytkownika
	 * 
	 * @param enabled
	 *            status użytkownika - true aktywny
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Metoda zwracająca id klienta, z którym skojarzony jest użytkownik.
	 * 
	 * @return id klienta, z którym skojarzony jest użytkownik.
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Metoda ustawiająca id klienta, z którym skojarzony jest użytkownik.
	 * 
	 * @param customerId
	 *            id klienta, z którym skojarzony jest użytkownik.
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
