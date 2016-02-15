package banksys.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

import banksys.account.AbstractAccount;
import banksys.persistence.exception.AccountCreationException;
import banksys.persistence.exception.AccountDeletionException;
import banksys.persistence.exception.AccountNotFoundException;

public class AccountPersistence implements IAccountRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<AbstractAccount> accounts;
	XStream xstream = new XStream();
	
	public AccountPersistence(){
		this.accounts = new ArrayList<AbstractAccount>();
		deserializingAccount("Accounts.xml");
	}

	@Override
	public void create(AbstractAccount account) throws AccountCreationException {
		if (this.findAccount(account.getNumber()) == null) {
			this.accounts.add(account);
		} else {
			throw new AccountCreationException("OrdinaryAccount alredy exist!", account.getNumber());
		}
	}

	@Override
	public void delete(String number) throws AccountDeletionException {
		AbstractAccount account = this.findAccount(number);
		if (account != null) {
			this.accounts.remove(account);
		} else {
			throw new AccountDeletionException("OrdinaryAccount doesn't exist!", number);
		}
	}

	@Override
	public AbstractAccount retrieve(String number) throws AccountNotFoundException {
		AbstractAccount account = findAccount(number);
		if (account != null) {
			return account;
		} else {
			throw new AccountNotFoundException("OrdinaryAccount not found!", number);
		}
	}

	@Override
	public AbstractAccount[] list() {
		AbstractAccount[] list = null;
		if (this.accounts.size() > 0) {
			list = new AbstractAccount[this.accounts.size()];
			for (int i = 0; i < this.accounts.size(); i++) {
				list[i] = (AbstractAccount) this.accounts.get(i);
			}
		}
		return list;
	}

	@Override
	public int mumberOfAccounts() {
		return this.accounts.size();
	}
	
	private AbstractAccount findAccount(String number) {
		if (this.accounts.size() > 0) {
			for (int i = 0; i < this.accounts.size(); i++) {
				AbstractAccount account = (AbstractAccount) this.accounts.get(i);
				if (account.getNumber().equals(number)) {
					return account;
				}
			}
		}
		return null;
	}
	
	public void serializingAccount(String file){
		FileOutputStream record;
		try {
			record = new FileOutputStream(file);
			record.write(xstream.toXML(accounts).getBytes());
			record.close();
		} catch (IOException e) {
           e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void deserializingAccount(String file){
		FileInputStream fileIn;
		try{
			fileIn = new FileInputStream(file);
			accounts = (ArrayList<AbstractAccount>) xstream.fromXML(fileIn);
			fileIn.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

}
