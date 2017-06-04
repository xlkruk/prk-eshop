package model;

import static org.junit.Assert.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import pl.edu.pw.ii.eshop.model.Users;

import org.junit.Test;

/**
 * @author Krzysztof Trybus
 * @version 1.0
 *
 */

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
		assertFalse("4321".equals(getUsersId()));
	}

	@Test
	public void testGetUsername() {
		setUsername(username);
		assertEquals(username,getUsername());
		assertFalse(password.equals(getUsername()));
	}

	@Test
	public void testGetPassword() {
		setPassword(password);
		assertEquals(password,getPassword());
		assertFalse(username.equals(getPassword()));
	}

	@Test
	public void testIsEnabled() {
		setEnabled(enabled);
		assertEquals(enabled,isEnabled());
		assertFalse(!isEnabled());
	}

	@Test
	public void testGetCustomerId() {
		setCustomerId(customerId);
		assertEquals(customerId,getCustomerId());
		assertFalse("5425".equals(getCustomerId()));
	}

}
