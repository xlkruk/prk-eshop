package pl.edu.pw.ii.eshop.service;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.CustomerInfo;

/**
 * Interfejs warstwy serwisu, definiuj¹cy metody zwi¹zane z logik¹ biznesow¹
 * zwi¹zan¹ z klientami
 * 
 * @author £ukasz Kruk
 *
 */
public interface CustomerService {
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
	 * Metoda umo¿liwiaj¹ca utrwalenie zmodyfikowanego klienta
	 * 
	 * @param customer
	 *            klient {@link Customer}
	 */
	void editCustomer(CustomerInfo customer);

	/**
	 * Metoda zwracaj¹ca klienta o zadanej nazwie u¿ytkownika
	 * 
	 * @param username
	 *            nazwa u¿ytkownika
	 * @return klient {@link Customer}
	 */
	Customer getCustomerByUsername(String username);

	/**
	 * Metoda zwracaj¹ca obiekt reprezentuj¹cy informacje o kliencie.
	 * 
	 * @param customer
	 *            klient {@link Customer}
	 * @return informacje o kliencie {@link CustomerInfo}
	 */
	CustomerInfo getCustomerInfo(Customer customer);
}
