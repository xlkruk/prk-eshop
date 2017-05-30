package pl.edu.pw.ii.eshop.dao;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Customer;

/**
 * 
 * Interfejs dost�pu do obiektu {@link Customer} DAO.
 * 
 * @author �ukasz Kruk
 * 
 */
public interface CustomerDao {

	/**
	 * Metoda umo�liwiaj�ca utrwalenie nowego klienta {@link Customer}
	 * 
	 * @param customer
	 *            klient {@link Customer}
	 */
	void addCustomer(Customer customer);

	/**
	 * Metoda zwracaj�ca klienta o zadanym id
	 * 
	 * @param id
	 *            id klienta
	 * @return klient {@link Customer}
	 */
	Customer getCustomerById(int id);

	/**
	 * Metoda zwracaj�ca list� wszystkich klient�w
	 * 
	 * @return lista wszystkich klient�w {@link Customer} sklepu
	 */
	List<Customer> getAllCustomers();

	/**
	 * Metoda zwracaj�ca klienta o zadanej nazwie u�ytkownika
	 * 
	 * @param username
	 *            nazwa u�ytkownika
	 * @return klient {@link Customer}
	 */
	Customer getCustomerByUsername(String username);

	/**
	 * Metoda umo�liwiaj�ca utrwalenie zmodyfikowanego klienta
	 * 
	 * @param customer
	 *            klient {@link Customer}
	 */
	public void editCustomer(Customer customer);

}
