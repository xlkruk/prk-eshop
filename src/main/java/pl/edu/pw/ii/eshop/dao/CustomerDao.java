package pl.edu.pw.ii.eshop.dao;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Customer;

/**
 * 
 * Interfejs dostępu do obiektu {@link Customer} DAO.
 * 
 * @author Łukasz Kruk
 * 
 */
public interface CustomerDao {

	/**
	 * Metoda umożliwiająca utrwalenie nowego klienta {@link Customer}
	 * 
	 * @param customer
	 *            klient {@link Customer}
	 */
	void addCustomer(Customer customer);

	/**
	 * Metoda zwracająca klienta o zadanym id
	 * 
	 * @param id
	 *            id klienta
	 * @return klient {@link Customer}
	 */
	Customer getCustomerById(int id);

	/**
	 * Metoda zwracająca listę wszystkich klientów
	 * 
	 * @return lista wszystkich klientów {@link Customer} sklepu
	 */
	List<Customer> getAllCustomers();

	/**
	 * Metoda zwracająca klienta o zadanej nazwie użytkownika
	 * 
	 * @param username
	 *            nazwa użytkownika
	 * @return klient {@link Customer}
	 */
	Customer getCustomerByUsername(String username);

	/**
	 * Metoda umożliwiająca utrwalenie zmodyfikowanego klienta
	 * 
	 * @param customer
	 *            klient {@link Customer}
	 */
	public void editCustomer(Customer customer);

}
