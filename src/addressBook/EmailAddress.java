package addressBook;

public class EmailAddress {
	public final String emailAddr;
	
	public EmailAddress(String emailAddr) {
		if (validateEmail(emailAddr)) {
			this.emailAddr = emailAddr;
		}
		else {
			throw new IllegalArgumentException("invalid emailAddress");
		}
	}
	
	private boolean validateEmail(String emailAddr) {
		return emailAddr.matches("\\w+@\\w+\\.[a-zA-z]+");
	}
	
	@Override
	public String toString() {
		return emailAddr;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + emailAddr.hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(!(o instanceof EmailAddress)) {
			return false;
		}
		EmailAddress email = (EmailAddress) o;
		return email.emailAddr.equals(emailAddr);
	}
}
