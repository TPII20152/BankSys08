package banksys.control;


import banksys.control.exception.BankTransactionException;
import banksys.account.AbstractAccount;
import banksys.persistence.exception.AccountNotFoundException;
import banksys.account.exception.NegativeAmountException;
import banksys.account.exception.InsufficientFundsException;
import banksys.control.exception.IncompatibleAccountException;
import banksys.account.SavingsAccount;
import banksys.account.SpecialAccount;
import banksys.persistence.AccountLog;
import banksys.persistence.IAccountRepository;

public class AccountController {
	
	IAccountRepository repository;
	
	public AccountController(IAccountRepository repository){
		this.repository = repository;
	}
	
	public void doCredit(String number, double amount) throws BankTransactionException {
		AbstractAccount account = findAccount(number);
		try {
			account.credit(amount);
		} catch (NegativeAmountException nae) {
			throw new BankTransactionException(nae);
		}
		AccountLog.logRecord(number, "credited", amount);
		repository.serializingAccount("Accounts.xml");
	}
	
	public void doTransfer(String fromNumber, String toNumber, double amount)
			throws BankTransactionException {
		AbstractAccount fromAccount = findAccount(fromNumber);
		AbstractAccount toAccount = findAccount(toNumber);
		try {
			fromAccount.debit(amount);
			toAccount.credit(amount);
		} catch (InsufficientFundsException sie) {
			throw new BankTransactionException(sie);
		} catch (NegativeAmountException nae) {
			throw new BankTransactionException(nae);
		}
		AccountLog.logRecord(fromNumber,toNumber, "transfered", amount);
		repository.serializingAccount("Accounts.xml");

	}
	
	public void doDebit(String number, double amount) throws BankTransactionException {
		AbstractAccount account = findAccount(number);
		try {
			account.debit(amount);
		} catch (InsufficientFundsException ife) {
			throw new BankTransactionException(ife);
		} catch (NegativeAmountException nae) {
			throw new BankTransactionException(nae);
		}
		AccountLog.logRecord(number, "debited", amount);
		repository.serializingAccount("Accounts.xml");

	}
	
	public double getBalance(String number) throws BankTransactionException {
		AbstractAccount account = findAccount(number);
		return account.getBalance();
	}
	
	public void doEarnInterest(String number)
			throws BankTransactionException, IncompatibleAccountException {
		AbstractAccount auxAccount = findAccount(number);
		if (auxAccount instanceof SavingsAccount) {
			((SavingsAccount) auxAccount).earnInterest();
		} else {
			throw new IncompatibleAccountException(number);
		}
		AccountLog.logRecord(number, "earned interest");
		repository.serializingAccount("Accounts.xml");

	}
	
	public void doEarnBonus(String number)
			throws BankTransactionException, IncompatibleAccountException {
		AbstractAccount auxAccount = findAccount(number);
		if (auxAccount instanceof SpecialAccount) {
			((SpecialAccount) auxAccount).earnBonus();
		} else {
			throw new IncompatibleAccountException(number);
		}
		AccountLog.logRecord(number, "earned bonus");
		repository.serializingAccount("Accounts.xml");

	}
	
	private AbstractAccount findAccount(String number) throws BankTransactionException {
		AbstractAccount account = null;
		try {
			account = repository.retrieve(number);
		} catch (AccountNotFoundException e) {
			throw new BankTransactionException(e);
		}
		return account;
	}
	
}