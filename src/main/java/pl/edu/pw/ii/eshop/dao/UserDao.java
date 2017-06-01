package pl.edu.pw.ii.eshop.dao;

import pl.edu.pw.ii.eshop.model.Users;

/**
 * Interfejs dostępu do obiektu {@link Users} DAO
 * 
 * @author Agnieszka Świderska
 *
 */
public interface UserDao {

	/**
	 * Metoda zwracająca użytkownika {@link Users} o zadanej nazwie użytkownika
	 * 
	 * @param username
	 *            nazwa użytkownika (login)
	 * @return użytkownik {@link Users}
	 */
	Users getUserByUsername(String username);

	/**
	 * Metoda umożliwiająca utrwalenie zmodyfikowanego użytkownika {@link Users}
	 * 
	 * @param user
	 *            użytkownik {@link Users}
	 */
	void updateUser(Users user);
}
