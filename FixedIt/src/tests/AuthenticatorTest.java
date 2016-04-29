package tests;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import fixedIt.modelComponents.Authenticator;
import fixedIt.modelComponents.User;

public class AuthenticatorTest {
	private Authenticator a;
	private String validPass;
	private String validPass2;
	private String invalidPass;
	//private String search1;
	//private String search2;
	
	
	
	@Before
	public void setUp(){
		validPass="ThisIsAPassword!-._";
		invalidPass="ThisIsAnInvalidPass/?@#";
		validPass2="ThisIsAlsoAPassword!!!---...___";
		a=new Authenticator();
	}
	
	@Test
	public void testRequestPasswordReset(){
		a.requestPasswordReset("cs320fixedit@mailinator.com", "localhost:8081/FixedIt/passwordReset/", UUID.randomUUID());
	}

	@Test
	public void testIsValidPassword() {
		
		assertTrue(a.isValidPassword(validPass));
		assertFalse(a.isValidPassword(invalidPass));
	}

	@Test
	public void testIsValidEmailAddress() {
		String validEmail1="email@domain.com";
		String validEmail2="johnny.appleseed@dadjokes.net";
		String invalidEmail1="superFakeEmailAddress";
		String invalidEmail2="Screw email conventions!";
		
		assertTrue(a.isValidEmailAddress(validEmail1));
		assertTrue(a.isValidEmailAddress(validEmail2));
		assertFalse(a.isValidEmailAddress(invalidEmail1));
		assertFalse(a.isValidEmailAddress(invalidEmail2));
	}

	@Test
	public void testSaltHashPassword() {
		String hash1=a.saltHashPassword(validPass);
		String hash2=a.saltHashPassword(validPass2);
		
		assertFalse(validPass.equals(hash1));
		assertFalse(validPass.length()==hash1.length());
		assertFalse(validPass2.equals(hash2));
		assertFalse(validPass2.length()==hash2.length());
		assertFalse(hash1.equals(hash2));
	}
	
	@Test
	public void testValidatePassword(){
		String hash1=a.saltHashPassword(validPass);
		
		User Fake1 = new User ("email@domain.com",hash1,0,0,a);
		a.addNewUserToDB(Fake1);
		
		//System.out.println(a.saltHashPassword(validPass));
		

		assertTrue(a.credentialsMatch("email@domain.com", "ThisIsAPassword!-._"));

		a.deleteUser(Fake1);
		
	}
	

	
}