package model;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.junit.Test;

import pl.edu.pw.ii.eshop.model.BillingAddress;
import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.OrderItem;
import pl.edu.pw.ii.eshop.model.ShippingAddress;
import pl.edu.pw.ii.eshop.model.Order;

/**
 * @author Krzysztof Trybus
 * @version 1.0
 *
 */

public class OrderTest extends Order{
	
	private static final long serialVersionUID = -3298918499516179338L;

	@Id
	@GeneratedValue
	private int orderId = 1242432;

	@Column(name = "STATUS")
	private String status = "NOWY";

	@Column(name = "CREATION_DATE")

	private Date creationDate = new Date();

	@Column(name = "STATUS_CHANGE_DATE")
	private Date statusChangeDate = new Date();

	@OneToOne
	@JoinColumn(name = "cartId")
	private Cart cart;

	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	@OneToOne
	@JoinColumn(name = "billingAddressId")
	private BillingAddress billingAddress;

	@OneToOne
	@JoinColumn(name = "shippingingAddressId")
	private ShippingAddress shippingAddress;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderItem> orderItems;

	@Test
	public void testGetStatus() {
		setStatus(status);
		assertEquals(status, getStatus());
		assertFalse("status".equals(getStatus()));
	}


	@Test
	public void testGetCreationDate() {
		setCreationDate(creationDate);
		assertEquals(creationDate,getCreationDate());
		assertFalse("creationDate".equals(getCreationDate()));
	}

	@Test
	public void testGetStatusChangeDate() {
		setStatusChangeDate(statusChangeDate);
		assertEquals(statusChangeDate,getStatusChangeDate());
		assertFalse(creationDate.equals(getStatus()));
	}
}
