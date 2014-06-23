package addressBook;

public class EmailAddress {
	public final String userName;
	public final String server;
	
	private EmailAddress(String userName, String server) {
		if(userName.equals("") || server.equals("")) {
			throw new IllegalArgumentException("user name or service address"
					+ "can't be empty");
		}
		this.userName = userName;
		this.server =  server;
	}
	
	public String toString() {
		return userName + "@" + server;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + userName.hashCode();
		result = 31 * result + server.hashCode();
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
		return email.userName.equals(userName) &&
				email.server.equals(server);
	}
}
