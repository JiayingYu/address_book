package addressBook;

public class Contact {
	private Name name;
	private PostAddress postAddr;
	private PhoneNumber phoneNum;
	private EmailAddress emailAddr;
	private String note;
	
	public static class Builder {
		private final Name name;
		
		private PostAddress postAddr = null;
		private PhoneNumber phoneNum = null;
		private EmailAddress emailAddr = null;
		private String note = "";
		
		public Builder(Name name) {
			this.name = name;
		}
		
		public Builder postAddr(PostAddress postAddr) {
			this.postAddr = postAddr;
			return this;
		}
		
		public Builder phoneNum(PhoneNumber phoneNum) {
			this.phoneNum = phoneNum;
			return this;
		}
		
		public Builder emailAddr(EmailAddress emailAddr) {
			this.emailAddr = emailAddr;
			return this;
		}
		
		public Builder note (String note) {
			this.note = note;
			return this;
		}
		
		public Contact build(){
			return new Contact(this);
		}	
	}
	
	private Contact(Builder builder) {
		name = builder.name;
		postAddr = builder.postAddr;
		phoneNum = builder.phoneNum;
		emailAddr = builder.emailAddr;
		note = builder.note;
	}
	
	//setters
	public void setName(Name name) {
		this.name = name;
	}
	
	public void setPostAddress(PostAddress postAddr) {
		this.postAddr = postAddr;
	}
	
	public void setPhoneNumber(PhoneNumber phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public void setEmailAddress(EmailAddress emailAddr) {
		this.emailAddr = emailAddr;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	//getters
	public String getName(){
		return name.toString();
	}
	
	public String getPostAddr() {
		return postAddr.toString();
	}
	
	public String getPhoneNum() {
		return phoneNum.toString();
	}
	
	public String getEmailAddr() {
		return emailAddr.toString();
	}
	
	public String getNote() {
		return note;
	}
}
