package pl.edu.pw.ii.eshop.service;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.CustomerInfo;

public interface CustomerService {
	void addCustomer(Customer customer);

	Customer getCustomerById(int id);
	
	List<Customer> getAllCustomers();
	
	void editCustomer(CustomerInfo customer);

	Customer getCustomerByUsername(String username);
	
	CustomerInfo getCustomerInfo(Customer customer);
}
