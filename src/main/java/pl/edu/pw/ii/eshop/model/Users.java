package pl.edu.pw.ii.eshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Klasa reprezentuj¹ca encjê USERS, u¿ytkowników systemu. Na potrzeby Spring
 * Security
 * 
 * @author £ukasz Krukid u¿ytkownika
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
	 * Metoda zwracaj¹ca id u¿ytkownika
	 * 
	 * @return id u¿ytkownika
	 */
	public int getUsersId() {
		return usersId;
	}

	/**
	 * Metoda ustawiaj¹ca id u¿ytkownika
	 * 
	 * @param usersId
	 *            id u¿ytkownika
	 */
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	/**
	 * Metoda zwracaj¹ca nazwê u¿ytkowinika
	 * 
	 * @return nazwa u¿ytkowinika
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Metoda ustawiaj¹ca nazwê u¿ytkowinika
	 * 
	 * @param username
	 *            nazwa u¿ytkowinika
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Metoda zwracaj¹ca has³o u¿ytkownika
	 * 
	 * @return has³o u¿ytkownika
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Metoda ustawiaj¹ca has³o u¿ytkownika
	 * 
	 * @param password
	 *            has³o u¿ytkownika
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Metoda testuj¹ca status u¿ytkownika
	 * 
	 * @return status u¿ytkownika - true aktywny
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Metoda ustawiaj¹ca status u¿ytkownika
	 * 
	 * @param enabled
	 *            status u¿ytkownika - true aktywny
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Metoda zwracaj¹ca id klienta, z którym skojarzony jest u¿ytkownik.
	 * 
	 * @return id klienta, z którym skojarzony jest u¿ytkownik.
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Metoda ustawiaj¹ca id klienta, z którym skojarzony jest u¿ytkownik.
	 * 
	 * @param customerId
	 *            id klienta, z którym skojarzony jest u¿ytkownik.
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
