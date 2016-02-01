package banksys.control;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import banksys.account.OrdinaryAccount;
import banksys.control.exception.BankTransactionException;
import banksys.persistence.AccountVector;
import banksys.persistence.exception.AccountCreationException;
import banksys.persistence.exception.AccountNotFoundException;

public class TestBankController {
	
	BankController bc;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetRepository() throws AccountCreationException {
		AccountVector av = new AccountVector();
		OrdinaryAccount oa = new OrdinaryAccount("123");
		av.create(oa);
		bc = new BankController(av);
		AccountVector av1 = (AccountVector) bc.getRepository();
		assertEquals(av.mumberOfAccounts(), av1.mumberOfAccounts(), 0);
	}

	@Test
	public void testAddAccount() throws BankTransactionException{
		AccountVector av = new AccountVector();
		bc = new BankController(av);
		OrdinaryAccount oa = new OrdinaryAccount("123");
		bc.addAccount(oa);
		AccountVector av1 = (AccountVector) bc.getRepository();
		assertEquals(av.mumberOfAccounts(), av1.mumberOfAccounts());
	}
	
	@Test(expected = BankTransactionException.class)
	public void testAddExistingAccount() throws BankTransactionException{
		AccountVector av = new AccountVector();
		bc = new BankController(av);
		OrdinaryAccount oa = new OrdinaryAccount("123");
		bc.addAccount(oa);
		OrdinaryAccount oa1 = new OrdinaryAccount("123");
		bc.addAccount(oa1);
	}

	@Test
	public void testRemoveAccount() throws BankTransactionException, AccountNotFoundException {
		AccountVector av = new AccountVector();
		bc = new BankController(av);
		OrdinaryAccount oa = new OrdinaryAccount("123");
		bc.addAccount(oa);
		AccountVector av1 = (AccountVector) bc.getRepository();
		assertEquals(av.mumberOfAccounts(), av1.mumberOfAccounts());
		bc.removeAccount("123");
		av1 = (AccountVector) bc.getRepository();
		assertEquals(av.mumberOfAccounts(), av1.mumberOfAccounts());
	}
	
	@Test(expected = BankTransactionException.class)
	public void testRemoveAccountNotFound() throws BankTransactionException, AccountNotFoundException {
		AccountVector av = new AccountVector();
		bc = new BankController(av);
		bc.removeAccount("123");
	}

}
