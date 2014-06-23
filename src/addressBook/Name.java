package addressBook;

public class Name {
	public final String fName;
	public final String lName;
	
	public Name(String fName, String lName) {
		if (fName == "" && lName == "") {
			throw new IllegalArgumentException("first name and last name can't be both empty");
		}
		this.fName = fName;
		this.lName = lName;
	}
	
	public String toString() {
		return "First name: " + fName 
				+ "\nLast name: " + lName;
	}
}
