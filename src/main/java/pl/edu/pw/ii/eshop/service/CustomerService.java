package pl.edu.pw.ii.eshop.service;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.CustomerInfo;

/**
 * Interfejs warstwy serwisu, definiuj�cy metody zwi�zane z logik� biznesow�
 * zwi�zan� z klientami
 * 
 * @author �ukasz Kruk
 *
 */
public interface CustomerService {
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
	 * Metoda umo�liwiaj�ca utrwalenie zmodyfikowanego klienta
	 * 
	 * @param customer
	 *            klient {@link Customer}
	 */
	void editCustomer(CustomerInfo customer);

	/**
	 * Metoda zwracaj�ca klienta o zadanej nazwie u�ytkownika
	 * 
	 * @param username
	 *            nazwa u�ytkownika
	 * @return klient {@link Customer}
	 */
	Customer getCustomerByUsername(String username);

	/**
	 * Metoda zwracaj�ca obiekt reprezentuj�cy informacje o kliencie.
	 * 
	 * @param customer
	 *            klient {@link Customer}
	 * @return informacje o kliencie {@link CustomerInfo}
	 */
	CustomerInfo getCustomerInfo(Customer customer);
}
