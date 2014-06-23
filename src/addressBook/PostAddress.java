package addressBook;

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
		String s = streetAddr1 + "\n" + streetAddr2 + "\n"
				+ city + " " + state + " " + zip
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
}
