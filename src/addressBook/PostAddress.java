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
				+ " " + state;
		return s;
	}
}
