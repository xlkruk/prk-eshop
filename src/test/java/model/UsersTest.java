package model;

import static org.junit.Assert.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import pl.edu.pw.ii.eshop.model.Users;

import org.junit.Test;

public class UsersTest extends Users{
    @Id
    @GeneratedValue
    private int usersId = 5425;
    private String username = "Krzysztof";
    private String password = "Trybus";
    private boolean enabled = true;
    private int customerId = 1234;

	@Test
	public void testGetUsersId() {
		setUsersId(usersId);
		assertEquals(usersId,getUsersId());
	}

	@Test
	public void testGetUsername() {
		setUsername(username);
		assertEquals(username,getUsername());
	}

	@Test
	public void testGetPassword() {
		setPassword(password);
		assertEquals(password,getPassword());
	}

	@Test
	public void testIsEnabled() {
		setEnabled(enabled);
		assertEquals(enabled,isEnabled());
	}

	@Test
	public void testGetCustomerId() {
		setCustomerId(customerId);
		assertEquals(customerId,getCustomerId());
	}

}
