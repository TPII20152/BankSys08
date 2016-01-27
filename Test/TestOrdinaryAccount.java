import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import banksys.account.OrdinaryAccount;
import banksys.account.exception.InsufficientFundsException;
import banksys.account.exception.NegativeAmountException;


public class TestOrdinaryAccount {

	OrdinaryAccount ac;
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDebit(){
		ac = new OrdinaryAccount("01");
		try {
			ac.credit(100);
		} catch (NegativeAmountException e) {
			e.printStackTrace();
		}
		
		try {
			ac.debit(50);
		} catch (NegativeAmountException e) {
			e.printStackTrace();
		} catch (InsufficientFundsException e) {
			e.printStackTrace();
		}
		
		assertEquals(ac.getBalance(),50,0);
	}
	@Test(expected=NegativeAmountException.class)
	public void testDebitNegative() throws NegativeAmountException, InsufficientFundsException {
		ac = new OrdinaryAccount("01");
		ac.debit(-100);
	}
	
	@Test(expected=InsufficientFundsException.class)
	public void testDebitPositive() throws NegativeAmountException, InsufficientFundsException{
		ac = new OrdinaryAccount("01");
			ac.credit(100);
			ac.debit(120);
	}
	@Test
	public void testOrdinaryAccount() {
		//Code don't have nothing to prevent creating a account that is already created
		ac = new OrdinaryAccount("01");
	}

}
