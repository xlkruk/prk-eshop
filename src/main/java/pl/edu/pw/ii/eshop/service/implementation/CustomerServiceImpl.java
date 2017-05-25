package pl.edu.pw.ii.eshop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.pw.ii.eshop.dao.CustomerDao;
import pl.edu.pw.ii.eshop.dao.UserDao;
import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.CustomerInfo;
import pl.edu.pw.ii.eshop.model.Users;
import pl.edu.pw.ii.eshop.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private UserDao userDao;

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
		Customer customer = customerDao.getCustomerById(customerInfo.getCustomerId());
		customer.setCustomerEmail(customerInfo.getCustomerEmail());
		customer.setCustomerPhone(customerInfo.getCustomerPhone());
		System.out.println("@@@@@@@@@@@@@@@@@@@"+customerInfo.getPassword());
		if((customerInfo.getPassword() != null) && !customerInfo.getPassword().equals("")){
			System.out.println("###############"+customerInfo.getPassword());
			customer.setPassword(customerInfo.getPassword());
			Users user = userDao.getUserByUsername(customerInfo.getUsername());
			user.setPassword(customerInfo.getPassword());
			userDao.updateUser(user);
		}
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
