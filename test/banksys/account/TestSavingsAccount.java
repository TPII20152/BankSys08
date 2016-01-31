package banksys.account;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import banksys.account.SavingsAccount;
import banksys.account.exception.NegativeAmountException;


public class TestSavingsAccount {

	SavingsAccount sa;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSavingsAccount() {
		//Code don't have nothing to prevent creating a account that is already created
		sa = new SavingsAccount("01");
	}
	
	@Test
	public void testEarnInterest() throws NegativeAmountException{
		sa = new SavingsAccount("01");
		double credit = 100;
		sa.credit(credit);
		double balance = sa.getBalance();
		balance = balance * 1.001;
		sa.earnInterest();
		
		assertEquals(sa.getBalance(),balance,0);
	}
	
	@Test(expected=NegativeAmountException.class)
	public void testEarnInterestNegative() throws NegativeAmountException{
		sa = new SavingsAccount("01");
		sa.credit(-100);
	}

}

