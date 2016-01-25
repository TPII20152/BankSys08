package banksys.persistence;

import java.util.Vector;

import banksys.account.AbstractAccount;
import banksys.persistence.exception.AccountCreationException;
import banksys.persistence.exception.AccountDeletionException;
import banksys.persistence.exception.AccountNotFoundException;

public class AccountVector implements IAccountRepository {

	private Vector<AbstractAccount> accounts = null;

	public AccountVector() {
		this.accounts = new Vector<AbstractAccount>();
	}

	public void delete(String number) throws AccountDeletionException {
		AbstractAccount account = this.findAccount(number);
		if (account != null) {
			this.accounts.remove(account);
		} else {
			throw new AccountDeletionException("OrdinaryAccount doesn't exist!", number);
		}
	}

	public void create(AbstractAccount account) throws AccountCreationException {
		if (this.findAccount(account.getNumber()) != null) {
			this.accounts.addElement(account);
		} else {
			throw new AccountCreationException("OrdinaryAccount alredy exist!", account.getNumber());
		}
	}

	public AbstractAccount[] list() {
		AbstractAccount[] list = null;
		if (this.accounts.size() > 0) {
			list = new AbstractAccount[this.accounts.size()];
			for (int i = 0; i < this.accounts.size(); i++) {
				list[i] = (AbstractAccount) this.accounts.elementAt(i);
			}
		}
		return list;
	}

	public int mumberOfAccounts() {
		return this.accounts.size();
	}

	public AbstractAccount retrieve(String number) throws AccountNotFoundException {
		AbstractAccount account = findAccount(number);
		if (account != null) {
			return account;
		} else {
			throw new AccountNotFoundException("OrdinaryAccount not found!", number);
		}
	}

	private AbstractAccount findAccount(String number) {
		if (this.accounts.size() > 0) {
			for (int i = 0; i < this.accounts.size(); i++) {
				AbstractAccount account = (AbstractAccount) this.accounts.elementAt(i);
				if (account.getNumber().equals(number)) {
					return account;
				}
			}
		}
		return null;
	}
}
