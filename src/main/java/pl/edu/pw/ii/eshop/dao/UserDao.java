package pl.edu.pw.ii.eshop.dao;

import pl.edu.pw.ii.eshop.model.Users;

/**
 * Interfejs dost�pu do obiektu {@link Users} DAO
 * 
 * @author Agnieszka �widerska
 *
 */
public interface UserDao {

	/**
	 * Metoda zwracaj�ca u�ytkownika {@link Users} o zadanej nazwie u�ytkownika
	 * 
	 * @param username
	 *            nazwa u�ytkownika (login)
	 * @return u�ytkownik {@link Users}
	 */
	Users getUserByUsername(String username);

	/**
	 * Metoda umo�liwiaj�ca utrwalenie zmodyfikowanego u�ytkownika {@link Users}
	 * 
	 * @param user
	 *            u�ytkownik {@link Users}
	 */
	void updateUser(Users user);
}
