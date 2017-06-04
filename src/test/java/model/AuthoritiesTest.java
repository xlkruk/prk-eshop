package model;

import static org.junit.Assert.*;

import org.junit.Test;
import pl.edu.pw.ii.eshop.model.Authorities;

/**
 * @author Krzysztof Trybus
 * @version 1.0
 *
 */

public class AuthoritiesTest extends Authorities {

	@Test
	public void testGetAuthoritiesId() {
		setAuthoritiesId(12345);
		assertEquals(12345,getAuthoritiesId());
		assertFalse("20093".equals(getAuthoritiesId()));
	}

	@Test
	public void testGetUsername() {
		setUsername("admin1");
		assertEquals("admin1",getUsername());
		assertFalse("tester1".equals(getUsername()));
	}

	@Test
	public void testGetAuthority() {
		setAuthority("admin");
		assertEquals("admin",getAuthority());
		assertFalse("tester".equals(getAuthority()));
	}
}
