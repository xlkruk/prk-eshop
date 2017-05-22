package pl.edu.pw.ii.eshop.model;


import org.hibernate.validator.constraints.NotEmpty;

public class CustomerInfo {

	private int customerId;

	@NotEmpty(message = "Imiê nie mo¿e byæ puste.")
	private String customerFirstName;

	@NotEmpty(message = "Nazwisko nie mo¿e byæ puste.")
	private String customerLastName;

	@NotEmpty(message = "Email nie mo¿e byæ pusty.")
	private String customerEmail;

	private String customerPhone;

	@NotEmpty(message = "Nazwa u¿ytkownika nie mo¿e byæ pusta.")
	private String username;

	private String password;

	private boolean enabled;

	@NotEmpty(message = "Pole nie mo¿e byæ puste.")
	private String billingStreet;
	@NotEmpty(message = "Pole nie mo¿e byæ puste.")
	private String billingApartmentNumber;
	@NotEmpty(message = "Pole nie mo¿e byæ puste.")
	private String billingCity;
	@NotEmpty(message = "Pole nie mo¿e byæ puste.")
	private String billingZipCode;

	@NotEmpty(message = "Pole nie mo¿e byæ puste.")
	private String shippingStreet;
	@NotEmpty(message = "Pole nie mo¿e byæ puste.")
	private String shippingApartmentNumber;
	@NotEmpty(message = "Pole nie mo¿e byæ puste.")
	private String shippingCity;
	@NotEmpty(message = "Pole nie mo¿e byæ puste.")
	private String shippingZipCode;
	
	public CustomerInfo() {
	
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getBillingStreet() {
		return billingStreet;
	}

	public void setBillingStreet(String billingStreet) {
		this.billingStreet = billingStreet;
	}

	public String getBillingApartmentNumber() {
		return billingApartmentNumber;
	}

	public void setBillingApartmentNumber(String billingApartmentNumber) {
		this.billingApartmentNumber = billingApartmentNumber;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingZipCode() {
		return billingZipCode;
	}

	public void setBillingZipCode(String billingZipCode) {
		this.billingZipCode = billingZipCode;
	}

	public String getShippingStreet() {
		return shippingStreet;
	}

	public void setShippingStreet(String shippingStreet) {
		this.shippingStreet = shippingStreet;
	}

	public String getShippingApartmentNumber() {
		return shippingApartmentNumber;
	}

	public void setShippingApartmentNumber(String shippingApartmentNumber) {
		this.shippingApartmentNumber = shippingApartmentNumber;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingZipCode() {
		return shippingZipCode;
	}

	public void setShippingZipCode(String shippingZipCode) {
		this.shippingZipCode = shippingZipCode;
	}
	
	public CustomerInfo(Customer customer){
		this.customerId= customer.getCustomerId();
		this.customerEmail=customer.getCustomerEmail();
		this.customerFirstName=customer.getCustomerFirstName();
		this.customerLastName = customer.getCustomerLastName();
		this.customerPhone = customer.getCustomerPhone();
		this.enabled = customer.isEnabled();
		this.username=customer.getUsername();
		this.password=customer.getPassword();
		
		this.billingCity=customer.getBillingAddress().getCity();
		this.billingApartmentNumber=customer.getBillingAddress().getApartmentNumber();
		this.billingStreet=customer.getBillingAddress().getStreet();
		this.billingZipCode=customer.getBillingAddress().getZipCode();
		
		this.shippingApartmentNumber=customer.getShippingAddress().getApartmentNumber();
		this.shippingCity=customer.getShippingAddress().getCity();
		this.shippingStreet=customer.getShippingAddress().getStreet();
		this.shippingZipCode=customer.getShippingAddress().getZipCode();
				
	}
}
