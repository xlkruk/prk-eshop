package pl.edu.pw.ii.eshop.service;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Customer;

public interface CustomerService {
	void addCustomer(Customer customer);

	Customer getCustomerById(int id);
	
	List<Customer> getAllCustomers();
	

	Customer getCustomerByUsername(String username);
}
