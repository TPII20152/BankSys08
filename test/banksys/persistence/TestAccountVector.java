package banksys.persistence;
import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import banksys.account.AbstractAccount;
import banksys.account.OrdinaryAccount;
import banksys.persistence.AccountVector;
import banksys.persistence.exception.AccountCreationException;
import banksys.persistence.exception.AccountDeletionException;
import banksys.persistence.exception.AccountNotFoundException;

public class TestAccountVector {

	AccountVector av;
	
	@Before
	public void setUp() throws Exception {
		av = new AccountVector();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDelete() throws AccountDeletionException, AccountCreationException {
		OrdinaryAccount oa = new OrdinaryAccount("123");
		av.create(oa);
		Vector<AbstractAccount> vector = new Vector<AbstractAccount>();
		vector.addElement(oa);
		assertEquals(av.mumberOfAccounts(), vector.size(), 0);
		av.delete("123");
		vector.remove(oa);
		assertEquals(av.mumberOfAccounts(), vector.size(), 0);
	}
	
	@Test(expected = AccountDeletionException.class)
	public void testDeleteAccountNotFound() throws AccountDeletionException{
		av.delete("123");
	}

	@Test
	public void testCreate() throws AccountCreationException{
		OrdinaryAccount oa = new OrdinaryAccount("123");
		av.create(oa);
		Vector<AbstractAccount> vector = new Vector<AbstractAccount>();
		vector.addElement(oa);
		assertEquals(av.mumberOfAccounts(), vector.size(), 0);
	}
	
	@Test(expected = AccountCreationException.class)
	public void testCreateExistingAccount() throws AccountCreationException{
		OrdinaryAccount oa = new OrdinaryAccount("123");
		av.create(oa);
		OrdinaryAccount oa1 = new OrdinaryAccount("123");
		av.create(oa1);
	}

	@Test
	public void testList() throws AccountCreationException{
		OrdinaryAccount oa = new OrdinaryAccount("123");
		av.create(oa);
		AbstractAccount[] aalist = av.list();
		AbstractAccount[] list = new AbstractAccount[av.mumberOfAccounts()];
		for(int i = 0; i < av.mumberOfAccounts(); i++){
			list[i] = (AbstractAccount) oa;
		}
		assertEquals(aalist.length, list.length);
	}

	@Test
	public void testMumberOfAccounts(){
		Vector<AbstractAccount> vector = new Vector<AbstractAccount>();
		assertEquals(vector.size(), av.mumberOfAccounts(), 0);
	}

	@Test
	public void testRetrieve() throws AccountCreationException, AccountNotFoundException{
		OrdinaryAccount oa = new OrdinaryAccount("123");
		av.create(oa);
		OrdinaryAccount oa1 = (OrdinaryAccount) av.retrieve("123");	
		assertEquals(0, oa1.getBalance(), 0);
	}
	
	@Test(expected = AccountNotFoundException.class)
	public void testRetrieveAccountNotFound() throws AccountNotFoundException{
		av.retrieve("123");	
	}

}
