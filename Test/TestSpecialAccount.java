import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import banksys.account.SpecialAccount;
import banksys.account.exception.NegativeAmountException;



public class TestSpecialAccount {

	SpecialAccount account;
	
	@Before
	public void setUp() throws Exception {
		account = new SpecialAccount("1");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreditNormal() {
		int value = 100;
		try {
			account.credit(value);
		} catch (Exception e) {
			System.out.println("It was not possible to credit your account.");
		}
		assertEquals(value, account.getBalance(), 0);
	}
	
	@Test(expected=NegativeAmountException.class)
	public void testCreditNegative() throws NegativeAmountException {
		int value = -100;
		account.credit(value);
	}

	@Test
	public void testBonusNormal() {
		int value = 100;
		double bonus;
		
		//Calculing the final bonus value
		bonus = account.getBonus();
		bonus = bonus + (0.01 * value);
		
		try {
			account.credit(value);
		} catch (Exception e1) {
			System.out.println("It was not possible to credit your account.");
		}
		assertEquals(bonus, account.getBonus(), 0);
	}
	
	@Test
	public void testBonusNegative() {
		int value = -100;
		double bonus;
		bonus = account.getBonus();
		
		try {
			account.credit(value);
		} catch (NegativeAmountException e) {}
		assertEquals(bonus, account.getBonus(), 0);
	}

	@Test
	public void testEarnBonus() {
		int value = 100;
		double bonus, total;
		
		
		//Calculing the final bonus value
		bonus = account.getBonus();
		bonus = bonus + (0.01 * value);
		
		total = value + bonus;
		
		try {
			account.credit(value);
		} catch (Exception e1) {
			System.out.println("It was not possible to credit your account.");
		}
		account.earnBonus();
		assertEquals(total, account.getBalance(), 0);
	}

}
