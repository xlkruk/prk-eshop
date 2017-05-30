package pl.edu.pw.ii.eshop.dao;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Customer;

/**
 * 
 * Interfejs dostêpu do obiektu {@link Customer} DAO.
 * 
 * @author £ukasz Kruk
 * 
 */
public interface CustomerDao {

	/**
	 * Metoda umo¿liwiaj¹ca utrwalenie nowego klienta {@link Customer}
	 * 
	 * @param customer
	 *            klient {@link Customer}
	 */
	void addCustomer(Customer customer);

	/**
	 * Metoda zwracaj¹ca klienta o zadanym id
	 * 
	 * @param id
	 *            id klienta
	 * @return klient {@link Customer}
	 */
	Customer getCustomerById(int id);

	/**
	 * Metoda zwracaj¹ca listê wszystkich klientów
	 * 
	 * @return lista wszystkich klientów {@link Customer} sklepu
	 */
	List<Customer> getAllCustomers();

	/**
	 * Metoda zwracaj¹ca klienta o zadanej nazwie u¿ytkownika
	 * 
	 * @param username
	 *            nazwa u¿ytkownika
	 * @return klient {@link Customer}
	 */
	Customer getCustomerByUsername(String username);

	/**
	 * Metoda umo¿liwiaj¹ca utrwalenie zmodyfikowanego klienta
	 * 
	 * @param customer
	 *            klient {@link Customer}
	 */
	public void editCustomer(Customer customer);

}
