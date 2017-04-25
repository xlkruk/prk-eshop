package pl.edu.pw.ii.eshop.dao;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.Status;

public interface CustomerDao {

	void addCustomer(Customer customer);

	Customer getCustomerById(int id);

	List<Customer> getAllCustomers();

	Customer getCustomerByUsername(String username);
	

}
