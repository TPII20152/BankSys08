package banksys.control;


import banksys.control.exception.BankTransactionException;
import banksys.account.AbstractAccount;
import banksys.persistence.exception.AccountNotFoundException;
import banksys.account.exception.NegativeAmountException;
import banksys.account.exception.InsufficientFundsException;
import banksys.control.exception.IncompatibleAccountException;
import banksys.account.SavingsAccount;
import banksys.account.SpecialAccount;
import banksys.persistence.IAccountRepository;

public class AccountController {
	
	IAccountRepository repository;
	
	public AccountController(IAccountRepository repository){
		this.repository = repository;
	}
	
	public void doCredit(String number, double amount) throws BankTransactionException {
		AbstractAccount account;
		try {
			account = repository.retrieve(number);
		} catch (AccountNotFoundException anfe) {
			throw new BankTransactionException(anfe);
		}
		try {
			account.credit(amount);
		} catch (NegativeAmountException nae) {
			throw new BankTransactionException(nae);
		}
	}

	public void doTransfer(String fromNumber, String toNumber, double amount)
			throws BankTransactionException {
		AbstractAccount fromAccount;
		try {
			fromAccount = repository.retrieve(fromNumber);
		} catch (AccountNotFoundException anfe) {
			throw new BankTransactionException(anfe);
		}
		AbstractAccount toAccount;
		try {
			toAccount = repository.retrieve(toNumber);
		} catch (AccountNotFoundException anfe) {
			throw new BankTransactionException(anfe);
		}
		try {
			fromAccount.debit(amount);
			toAccount.credit(amount);
		} catch (InsufficientFundsException sie) {
			throw new BankTransactionException(sie);
		} catch (NegativeAmountException nae) {
			throw new BankTransactionException(nae);
		}
	}

	public void doDebit(String number, double amount) throws BankTransactionException {
		AbstractAccount account;
		try {
			account = repository.retrieve(number);
		} catch (AccountNotFoundException anfe) {
			throw new BankTransactionException(anfe);
		}
		try {
			account.debit(amount);
		} catch (InsufficientFundsException ife) {
			throw new BankTransactionException(ife);
		} catch (NegativeAmountException nae) {
			throw new BankTransactionException(nae);
		}
	}

	public double getBalance(String number) throws BankTransactionException {
		AbstractAccount conta;
		try {
			conta = repository.retrieve(number);
			return conta.getBalance();
		} catch (AccountNotFoundException anfe) {
			throw new BankTransactionException(anfe);
		}
	}

	public void doEarnInterest(String number)
			throws BankTransactionException, IncompatibleAccountException {
		AbstractAccount auxAccount;
		try {
			auxAccount = repository.retrieve(number);
		} catch (AccountNotFoundException anfe) {
			throw new BankTransactionException(anfe);
		}
		if (auxAccount instanceof SavingsAccount) {
			((SavingsAccount) auxAccount).earnInterest();
		} else {
			throw new IncompatibleAccountException(number);
		}
	}

	public void doEarnBonus(String number)
			throws BankTransactionException, IncompatibleAccountException {
		AbstractAccount auxAccount;
		try {
			auxAccount = repository.retrieve(number);
		} catch (AccountNotFoundException anfe) {
			throw new BankTransactionException(anfe);
		}
		if (auxAccount instanceof SpecialAccount) {
			((SpecialAccount) auxAccount).earnBonus();
		} else {
			throw new IncompatibleAccountException(number);
		}
	}
}