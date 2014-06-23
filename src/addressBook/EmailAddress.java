package addressBook;

public class EmailAddress {
	public final String userName;
	public final String server;
	
	private EmailAddress(String userName, String server) {
		this.userName = userName;
		this.server =  server;
	}
	
	public String toString() {
		return userName + "@" + server;
	}
}
