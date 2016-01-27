import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import banksys.account.TaxAccount;
import banksys.account.exception.InsufficientFundsException;
import banksys.account.exception.NegativeAmountException;


public class TestTaxAccountTest {
	
	TaxAccount ta;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDebit() throws NegativeAmountException, InsufficientFundsException{
		ta = new TaxAccount("01");
		double credit = 200;
		double debit = 50;
		ta.credit(credit);
		ta.debit(debit);
		double balance = credit - (debit + (debit *0.001));
		assertEquals(ta.getBalance(),balance,0);
	}
	@Test(expected=NegativeAmountException.class)
	public void testDebitNegative() throws NegativeAmountException, InsufficientFundsException {
		ta = new TaxAccount("01");
		ta.debit(-100);
	}
	
	@Test(expected=InsufficientFundsException.class)
	public void testDebitPositive() throws NegativeAmountException, InsufficientFundsException {
		ta = new TaxAccount("01");
		try {
			ta.credit(100);
		} catch (NegativeAmountException e) {
			e.printStackTrace();
		}
		ta.debit(150);
	}

	@Test
	public void testTaxAccount() {
		//Code don't have nothing to prevent creating a account that is already created
		ta = new TaxAccount("01");
	}

}
