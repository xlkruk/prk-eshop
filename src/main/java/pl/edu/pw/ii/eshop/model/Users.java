package pl.edu.pw.ii.eshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Klasa reprezentuj�ca encj� USERS, u�ytkownik�w systemu. Na potrzeby Spring
 * Security
 * 
 * @author �ukasz Krukid u�ytkownika
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
	 * Metoda zwracaj�ca id u�ytkownika
	 * 
	 * @return id u�ytkownika
	 */
	public int getUsersId() {
		return usersId;
	}

	/**
	 * Metoda ustawiaj�ca id u�ytkownika
	 * 
	 * @param usersId
	 *            id u�ytkownika
	 */
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	/**
	 * Metoda zwracaj�ca nazw� u�ytkowinika
	 * 
	 * @return nazwa u�ytkowinika
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Metoda ustawiaj�ca nazw� u�ytkowinika
	 * 
	 * @param username
	 *            nazwa u�ytkowinika
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Metoda zwracaj�ca has�o u�ytkownika
	 * 
	 * @return has�o u�ytkownika
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Metoda ustawiaj�ca has�o u�ytkownika
	 * 
	 * @param password
	 *            has�o u�ytkownika
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Metoda testuj�ca status u�ytkownika
	 * 
	 * @return status u�ytkownika - true aktywny
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Metoda ustawiaj�ca status u�ytkownika
	 * 
	 * @param enabled
	 *            status u�ytkownika - true aktywny
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Metoda zwracaj�ca id klienta, z kt�rym skojarzony jest u�ytkownik.
	 * 
	 * @return id klienta, z kt�rym skojarzony jest u�ytkownik.
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Metoda ustawiaj�ca id klienta, z kt�rym skojarzony jest u�ytkownik.
	 * 
	 * @param customerId
	 *            id klienta, z kt�rym skojarzony jest u�ytkownik.
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
