package addressBook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddressBook {
	private List<Contact> addrBook = new ArrayList<Contact>();
	
	public AddressBook() {
		
	}
	
	public Contact addContact(Contact contact) {
		addrBook.add(contact);
		return contact;
	}
	
	public List<Integer> searchByName(String name){
		List<Integer> result = new ArrayList<Integer>();
		Iterator<Contact> it = addrBook.iterator();
		while(it.hasNext()) {
			Contact currCon = it.next();
			if(currCon.getName().matches(".*" + name + ".*")){
				int currConIndex = addrBook.indexOf(currCon);
				result.add(currConIndex);
			}
		}
		return result;
	}
	
	public List<Integer> searchByPostAddr(String postAddr){
		List<Integer> result = new ArrayList<Integer>();
		Iterator<Contact> it = addrBook.iterator();
		while(it.hasNext()) {
			Contact currCon = it.next();
			if(currCon.getPostAddr().matches(".*" + postAddr + ".*")){
				int currConIndex = addrBook.indexOf(currCon);
				result.add(currConIndex);
			}
		}
		return result;
	}
	
	public List<Integer> searchByPhoneNum(String phoneNum){
		List<Integer> result = new ArrayList<Integer>();
		Iterator<Contact> it = addrBook.iterator();
		while(it.hasNext()) {
			Contact currCon = it.next();
			if(currCon.getPhoneNum().matches(".*" + phoneNum + ".*")){
				int currConIndex = addrBook.indexOf(currCon);
				result.add(currConIndex);
			}
		}
		return result;
	}
	
	public List<Integer> searchByEmailAddr(String emailAddr){
		List<Integer> result = new ArrayList<Integer>();
		Iterator<Contact> it = addrBook.iterator();
		while(it.hasNext()) {
			Contact currCon = it.next();
			if(currCon.getEmailAddr().matches(".*" + emailAddr + ".*")){
				int currConIndex = addrBook.indexOf(currCon);
				result.add(currConIndex);
			}
		}
		return result;
	}
	
	public List<Integer> searchByNote(String note){
		List<Integer> result = new ArrayList<Integer>();
		Iterator<Contact> it = addrBook.iterator();
		while(it.hasNext()) {
			Contact currCon = it.next();
			if(currCon.getNote().matches(".*" + note + ".*")){
				int currConIndex = addrBook.indexOf(currCon);
				result.add(currConIndex);
			}
		}
		return result;
	}
	
	public void remove(int index){
		addrBook.remove(index);
	}

}