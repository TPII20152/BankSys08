package banksys.persistence.exception;

public class PersistenceException extends Exception {

	private static final long serialVersionUID = 1L;

	private String number;

	private String message;

	public PersistenceException(String message, String number) {
		super("Existing OrdinaryAccount!");
		this.number = number;
		this.message = message;
	}

	public String getMessage() {
		return this.message + " [account number = " + number + "]";
	}

	public String getNumber() {
		return number;
	}
}