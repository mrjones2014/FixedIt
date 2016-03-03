package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import Model.Authenticator;
import Model.FakeDatabase;
import Model.PasswordResetPage;

public class PasswordResetPageTest {
	private PasswordResetPage pwReset;
	private Authenticator auth;
	private FakeDatabase db;

	@Before
	public void setUp() throws Exception {
		db=new FakeDatabase();
		auth=new Authenticator(db);
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, -4);
		pwReset=new PasswordResetPage(auth, "cs320fixedit@mailinator.com", cal, db);
	}

	@Test
	public void testResetPassword() {
		assertFalse(pwReset.resetPassword("password"));
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, 4);
		pwReset=new PasswordResetPage(auth, "cs320fixedit@mailinator.com", cal, db);
		assertTrue(pwReset.resetPassword("password"));
	}

}
