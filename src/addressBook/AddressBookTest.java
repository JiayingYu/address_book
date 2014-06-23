package addressBook;

public class AddressBookTest {
	public static void main(String[] args) {
		AddressBook addrBook = new AddressBook();
		
		Name name = new Name("Emily", "Zhang");
		PhoneNumber phone = new PhoneNumber("9183408983");
		PostAddress postAddr = new PostAddress.Builder().streetAddr1("1 Golden Street")
				.city("Sandiego").state("CA").zip("09712").build();
		EmailAddress email = new EmailAddress("ez109@hotmail.com");
		Contact contact = new Contact.Builder(name).phoneNum(phone)
				.postAddr(postAddr).emailAddr(email).build();
		addrBook.addContact(contact);
		
		Name name2 = new Name("Tim", "Zhou");
		PhoneNumber phone2 = new PhoneNumber("009542991");
		PostAddress postAddr2 = new PostAddress.Builder().streetAddr1("25 River Court")
				.city("Jersey City").state("NJ").zip("07310").build();
		EmailAddress email2 = new EmailAddress("timzhou@hotmail.com");
		Contact contact2 = new Contact.Builder(name2).phoneNum(phone2)
				.postAddr(postAddr2).emailAddr(email2).note("Cornel").build();
		addrBook.addContact(contact2);
		
		System.out.println(addrBook.toString());
		
		System.out.println(addrBook.searchByEmailAddr("ez109"));
		System.out.println(addrBook.searchByName("Tim"));
		System.out.println(addrBook.searchByNote("Cornel"));
		System.out.println(addrBook.searchByPhoneNum("918"));
		System.out.println(addrBook.searchByPostAddr("Sandiego"));
		
		addrBook.remove(1);
		System.out.println();
		System.out.println(addrBook.toString());
	}
}
