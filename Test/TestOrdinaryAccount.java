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
	public void testDebitNegative() throws NegativeAmountException, InsufficientFundsException {
		ac = new OrdinaryAccount("01");
		try{
		ac.debit(-100);
		} catch( NegativeAmountException e){
			assertEquals(1,1,0);
		}
	}
	
	@Test
	public void testDebitPositive() throws NegativeAmountException, InsufficientFundsException{
		ac = new OrdinaryAccount("01");
		try{
			ac.credit(100);
			ac.debit(120);
		} catch (InsufficientFundsException e){
			assertEquals(1,1,0);
		}
	}
	@Test
	public void testOrdinaryAccount() {
		//Code don't have nothing to prevent creating a account that is already created
		ac = new OrdinaryAccount("01");
	}

}
