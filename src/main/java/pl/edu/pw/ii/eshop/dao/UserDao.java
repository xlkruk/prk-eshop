package pl.edu.pw.ii.eshop.dao;

import pl.edu.pw.ii.eshop.model.Users;

/**
 * Interfejs dostêpu do obiektu {@link Users} DAO
 * 
 * @author Agnieszka Œwiderska
 *
 */
public interface UserDao {

	/**
	 * Metoda zwracaj¹ca u¿ytkownika {@link Users} o zadanej nazwie u¿ytkownika
	 * 
	 * @param username
	 *            nazwa u¿ytkownika (login)
	 * @return u¿ytkownik {@link Users}
	 */
	Users getUserByUsername(String username);

	/**
	 * Metoda umo¿liwiaj¹ca utrwalenie zmodyfikowanego u¿ytkownika {@link Users}
	 * 
	 * @param user
	 *            u¿ytkownik {@link Users}
	 */
	void updateUser(Users user);
}
