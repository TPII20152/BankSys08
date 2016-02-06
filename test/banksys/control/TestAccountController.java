package banksys.control;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import banksys.account.OrdinaryAccount;
import banksys.account.SavingsAccount;
import banksys.account.SpecialAccount;
import banksys.account.exception.InsufficientFundsException;
import banksys.account.exception.NegativeAmountException;
import banksys.control.exception.BankTransactionException;
import banksys.control.exception.IncompatibleAccountException;
import banksys.persistence.AccountVector;
import banksys.persistence.IAccountRepository;
import banksys.persistence.exception.AccountCreationException;

public class TestAccountController {

	@Test(expected=AccountCreationException.class) //trying to create two ordinary accounts with the same name
	public void testAccountController() throws AccountCreationException {
		IAccountRepository repository = new AccountVector();
		OrdinaryAccount account = new OrdinaryAccount("01");
		repository.create(account);
		repository.create(account);
	}

	@Test(expected=BankTransactionException.class)//Account 01 was not created
	public void testDoCreditNoAccount() throws BankTransactionException {
		IAccountRepository repository = new AccountVector();
		AccountController ac = new AccountController (repository);
		ac.doCredit("01",100);
		assertEquals(100,ac.getBalance("01"),0);
	}
	
	@Test //normal doCredit operation
	public void testDoCredit() throws BankTransactionException, AccountCreationException {
		IAccountRepository repository = new AccountVector();
		OrdinaryAccount account = new OrdinaryAccount("01");
		repository.create(account);
		AccountController ac = new AccountController (repository);
		ac.doCredit("01",100);
		assertEquals(100,ac.getBalance("01"),0);
	}

	@Test
	public void testDoTransfer() throws AccountCreationException, NegativeAmountException, BankTransactionException {
		IAccountRepository repository = new AccountVector();
		OrdinaryAccount account = new OrdinaryAccount("01");
		OrdinaryAccount account2 = new OrdinaryAccount("02");
		AccountController ac = new AccountController (repository);
		repository.create(account);
		repository.create(account2);
		account.credit(100);
		ac.doTransfer("01", "02", 100);
		
	}

	@Test// doing a normal doDebit operation
	public void testDoDebit() throws AccountCreationException, BankTransactionException {
		IAccountRepository repository = new AccountVector();
		OrdinaryAccount account = new OrdinaryAccount("01");
		AccountController ac = new AccountController (repository);
		repository.create(account);
		ac.doCredit("01", 100);
		ac.doDebit("01", 50);
		assertEquals(50,account.getBalance(),0);
	}
	
	@Test(expected=BankTransactionException.class)// doing a doDebit operation with insufficient funds
	public void testDoDebitNoFunds() throws AccountCreationException, BankTransactionException {
		IAccountRepository repository = new AccountVector();
		OrdinaryAccount account = new OrdinaryAccount("01");
		AccountController ac = new AccountController (repository);
		repository.create(account);
		ac.doCredit("01", 50);
		ac.doDebit("01", 100);
	}
	
	@Test(expected=BankTransactionException.class)// doing a doDebit operation with negative value
	public void testDoDebitNegativeAmoung() throws AccountCreationException, BankTransactionException {
		IAccountRepository repository = new AccountVector();
		OrdinaryAccount account = new OrdinaryAccount("01");
		AccountController ac = new AccountController (repository);
		repository.create(account);
		ac.doDebit("01",-100);
		
	}

	@Test
	public void testGetBalance() throws BankTransactionException, AccountCreationException {
		IAccountRepository repository = new AccountVector();
		OrdinaryAccount account = new OrdinaryAccount("01");
		AccountController ac = new AccountController (repository);
		repository.create(account);
		ac.doCredit("01", 100);
		ac.doDebit("01", 50);
		assertEquals(50,ac.getBalance("01"),0);
	}

	@Test(expected=IncompatibleAccountException.class)//OrdinaryAccount is not compatible with doEarnInterest operation
	public void testDoEarnInterestIncompatible() throws AccountCreationException, IncompatibleAccountException, BankTransactionException {
		IAccountRepository repository = new AccountVector();
		OrdinaryAccount account = new OrdinaryAccount("01");
		AccountController ac = new AccountController (repository);
		repository.create(account);
		ac.doEarnInterest("01");
	}
	
	@Test
	public void testDoEarnInterestNormal() throws AccountCreationException, IncompatibleAccountException, BankTransactionException {
		IAccountRepository repository = new AccountVector();
		SavingsAccount account = new SavingsAccount("01");
		AccountController ac = new AccountController (repository);
		repository.create(account);
		ac.doEarnInterest("01");
	}

	@Test(expected=IncompatibleAccountException.class)//OrdinaryAccount is not compatible with doEarnBonus Operation
	public void testDoEarnBonusIcompatible() throws AccountCreationException, IncompatibleAccountException, BankTransactionException {
		IAccountRepository repository = new AccountVector();
		OrdinaryAccount account = new OrdinaryAccount("01");
		AccountController ac = new AccountController (repository);
		repository.create(account);
		ac.doEarnBonus("01");
	}
	
	@Test
	public void testDoEarnBonusNormal() throws AccountCreationException, IncompatibleAccountException, BankTransactionException {
		IAccountRepository repository = new AccountVector();
		SpecialAccount account = new SpecialAccount("01");
		AccountController ac = new AccountController (repository);
		repository.create(account);
		ac.doEarnBonus("01");
	}

}
