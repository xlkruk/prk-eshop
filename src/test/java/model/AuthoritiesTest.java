package model;

import static org.junit.Assert.*;

import org.junit.Test;
import pl.edu.pw.ii.eshop.model.Authorities;

public class AuthoritiesTest extends Authorities {

	@Test
	public void testGetAuthoritiesId() {
		setAuthoritiesId(12345);
		assertEquals(12345,getAuthoritiesId());
	}

	@Test
	public void testGetUsername() {
		setUsername("admin1");
		assertEquals("admin1",getUsername());
	}

	@Test
	public void testGetAuthority() {
		setAuthority("admin");
		assertEquals("admin",getAuthority());
	}
}
