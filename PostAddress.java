package addressBook;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PostAddress {
	private final String streetAddr1;
	private final String streetAddr2;
	private final String city;
	private final String state;
	private final String country;
	private final String zip;
	
	public static class Builder {
		private String streetAddr1 = "";		
		private String streetAddr2 = "";
		private String city = "";
		private String state = "";
		private String country = "";
		private String zip = "";
		
		public Builder () {	}
		
		public Builder streetAddr1(String addr) {
			streetAddr1 = addr; 
			return this;
		}
		
		public Builder streetAddr2(String addr) {
			streetAddr2 = addr; 
			return this;
		}
		
		public Builder city(String city) {
			this.city = city;
			return this;
		}
		
		public Builder state(String state) {
			this.state = state;
			return this;
		}
		
		public Builder country(String country) {
			this.country = country;
			return this;
		}
		
		public Builder zip(String zip) {
			this.zip = zip;
			return this;
		}
		
		public PostAddress build() {
			return new PostAddress(this);
		}
	}
	
	private PostAddress(Builder builder) {
		streetAddr1 = builder.streetAddr1;
		streetAddr2 = builder.streetAddr2;
		city = builder.city;
		state = builder.state;
		country = builder.country;
		zip = builder.zip;
	}

	public String toString() {
		String s = streetAddr1 + " " + streetAddr2 + "\n"
				+ city + ", " + state + " " + zip
				+ " " + country;
		return s;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + streetAddr1.toLowerCase().hashCode();
		result = 31 * result + streetAddr2.toLowerCase().hashCode();
		result = 31 * result + city.toLowerCase().hashCode();
		result = 31 * result + state.toLowerCase().hashCode();
		result = 31 * result + country.toLowerCase().hashCode();
		result = 31 * result + zip.toLowerCase().hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object o){
		if (this == o) {
			return true;
		}
		if (!(o instanceof PostAddress)) {
			return false;
		}
		PostAddress pa = (PostAddress) o;
		return pa.streetAddr1.equalsIgnoreCase(streetAddr1) &&
				pa.streetAddr2.equalsIgnoreCase(streetAddr2) &&
				pa.city.equalsIgnoreCase(city) &&
				pa.state.equalsIgnoreCase(state) &&
				pa.country.equalsIgnoreCase(country)&&
				pa.zip.equalsIgnoreCase(zip);
	}
	
	static final String XML_TAG = "PostAddress";
	
	Element toXmlElement(Document doc) {
		Element newElement = doc.createElement(XML_TAG);
		newElement.setAttribute("StreetAddress1", streetAddr1);
		newElement.setAttribute("StreetAddress2", streetAddr2);
		newElement.setAttribute("City", city);
		newElement.setAttribute("State", state);
		newElement.setAttribute("Country", country);
		newElement.setAttribute("ZipCode", zip);
		return newElement;
	}
	
	static PostAddress xmlToPostAddress(Element element) {
		String streetAddr1 = element.getAttribute("StreetAddress1");
		String streetAddr2 = element.getAttribute("StreetAddress2");
		String city = element.getAttribute("City");
		String state = element.getAttribute("State");
		String country = element.getAttribute("country");
		String zip = element.getAttribute("ZipCode");
		PostAddress postAddr = new PostAddress.Builder()
		.streetAddr1(streetAddr1).streetAddr2(streetAddr2)
		.city(city).state(state).country(country).zip(zip).build();
		return postAddr;
	}
}
