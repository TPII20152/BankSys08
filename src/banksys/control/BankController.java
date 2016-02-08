package banksys.control;

import banksys.account.AbstractAccount;
import banksys.control.exception.BankTransactionException;
import banksys.persistence.AccountLog;
import banksys.persistence.IAccountRepository;
import banksys.persistence.exception.AccountCreationException;
import banksys.persistence.exception.AccountDeletionException;

public class BankController {

	private IAccountRepository repository;

	public BankController(IAccountRepository repository) {
		this.repository = repository;
	}
	
	public IAccountRepository getRepository(){
		return this.repository;
	}

	public void addAccount(AbstractAccount account) throws BankTransactionException {
		try {
			this.repository.create(account);
		} catch (AccountCreationException ace) {
			throw new BankTransactionException(ace);
		}
		AccountLog.logRecord(account.getNumber(), "created");
	}

	public void removeAccount(String number) throws BankTransactionException {
		try {
			this.repository.delete(number);
		} catch (AccountDeletionException ade) {
			throw new BankTransactionException(ade);
		}
		AccountLog.logRecord(number, "deleted");
	}
	
}