package addressBook;

public class PhoneNumber {
	private String phoneNum;
	
	public PhoneNumber(String phoneNum){
		if (isNumeric(phoneNum)) {
			this.phoneNum = phoneNum;
		} else {
			throw new IllegalArgumentException("phone number has to be numeric");
		}
	}
	
	private boolean isNumeric(String num){
		try {
			Integer.parseInt(num);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	public String toString() {
		return phoneNum;
	}
}
