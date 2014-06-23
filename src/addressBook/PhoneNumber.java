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
		return num.matches("\\d+");
	}
	
	public String toString() {
		return phoneNum;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + phoneNum.hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof PhoneNumber)) {
			return false;
		}
		PhoneNumber pn = (PhoneNumber) o;
		return pn.phoneNum.equals(phoneNum);
	}
}
