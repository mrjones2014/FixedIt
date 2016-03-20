package tests;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import fixedIt.modelComponents.Authenticator;
import fixedIt.modelComponents.FakeDatabase;
import fixedIt.modelComponents.PasswordResetPage;

public class PasswordResetPageTest {
	private PasswordResetPage pwReset;
	private Authenticator auth;

	@Before
	public void setUp() throws Exception {
		auth=new Authenticator();
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, -4);
		pwReset=new PasswordResetPage(auth, "cs320fixedit@mailinator.com", cal);
	}

	@Test
	public void testResetPassword() {
		try {
			assertFalse(pwReset.resetPassword("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, 4);
		pwReset=new PasswordResetPage(auth, "cs320fixedit@mailinator.com", cal);
		try {
			assertTrue(pwReset.resetPassword("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}