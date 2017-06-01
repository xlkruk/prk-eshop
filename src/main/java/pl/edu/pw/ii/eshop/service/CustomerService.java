package pl.edu.pw.ii.eshop.service;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.CustomerInfo;

/**
 * Interfejs warstwy serwisu, definiujący metody związane z logiką biznesową
 * związaną z klientami
 * 
 * @author Łukasz Kruk
 *
 */
public interface CustomerService {
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
	 * Metoda umożliwiająca utrwalenie zmodyfikowanego klienta
	 * 
	 * @param customer
	 *            klient {@link Customer}
	 */
	void editCustomer(CustomerInfo customer);

	/**
	 * Metoda zwracająca klienta o zadanej nazwie użytkownika
	 * 
	 * @param username
	 *            nazwa użytkownika
	 * @return klient {@link Customer}
	 */
	Customer getCustomerByUsername(String username);

	/**
	 * Metoda zwracająca obiekt reprezentujący informacje o kliencie.
	 * 
	 * @param customer
	 *            klient {@link Customer}
	 * @return informacje o kliencie {@link CustomerInfo}
	 */
	CustomerInfo getCustomerInfo(Customer customer);
}
