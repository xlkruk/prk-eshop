package pl.edu.pw.ii.eshop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.pw.ii.eshop.dao.CustomerDao;
import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.CustomerInfo;
import pl.edu.pw.ii.eshop.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);

	}

	@Override
	public Customer getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}
	
	@Override
	public Customer getCustomerByUsername(String username) {
		return customerDao.getCustomerByUsername(username);
		
	}

	@Override
	public void editCustomer(CustomerInfo customerInfo) {
		System.out.println("#########################"+customerInfo.getCustomerId());
		Customer customer = customerDao.getCustomerById(customerInfo.getCustomerId());
		customer.setCustomerEmail(customerInfo.getCustomerEmail());
		customer.setCustomerPhone(customerInfo.getCustomerPhone());
		if(customerInfo.getPassword() != null)
			customer.setPassword(customerInfo.getPassword());
		customer.getBillingAddress().setApartmentNumber(customerInfo.getBillingApartmentNumber());
		customer.getBillingAddress().setCity(customerInfo.getBillingCity());
		customer.getBillingAddress().setStreet(customerInfo.getBillingStreet());
		customer.getBillingAddress().setZipCode(customerInfo.getBillingZipCode());
		customer.getShippingAddress().setApartmentNumber(customerInfo.getShippingApartmentNumber());
		customer.getShippingAddress().setCity(customerInfo.getShippingCity());
		customer.getShippingAddress().setStreet(customerInfo.getShippingStreet());
		customer.getShippingAddress().setZipCode(customerInfo.getShippingZipCode());
		customerDao.editCustomer(customer);
		
	}

	@Override
	public CustomerInfo getCustomerInfo(Customer customer) {
		CustomerInfo customerInfo = new CustomerInfo(customer);
		return null;
	}

}
