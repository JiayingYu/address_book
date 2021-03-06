package addressBook;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Name {
	public final String fName;
	public final String lName;
	
	public Name(String fName, String lName) {
		if (fName.equals("") && lName.equals("")) {
			throw new IllegalArgumentException("first name and last name can't be both empty");
		}
		this.fName = fName;
		this.lName = lName;
	}
	
	public String toString() {
		return fName + " " + lName;
	}
	
	@Override 
	public int hashCode() {
		int result = 17;
		result = 31 * result + fName.toLowerCase().hashCode();
		result = 31 * result + lName.toLowerCase().hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if (!(o instanceof Name)) {
			return false;
		}
		Name name = (Name) o;
		return name.fName.equalsIgnoreCase(fName) &&
				name.lName.equalsIgnoreCase(lName);
	}
	
	static final String XML_TAG = "Name";
	
	Element toXmlElement(Document doc) {
		Element newElement = doc.createElement(XML_TAG);
		newElement.setAttribute("FirstName", fName);
		newElement.setAttribute("LastName", lName);
		return newElement;
	}
	
	static Name xmlToName(Element element) {
		String fName = element.getAttribute("FirstName");
		String lName = element.getAttribute("LastName");
		return new Name(fName, lName);
	}
}

