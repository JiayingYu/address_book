package addressBook;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
	
	private Contact() {
		
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
	
	@Override
	public String toString() {
		String s = name.toString() + "\n" + emailAddr.toString() + "\n"
				+ phoneNum.toString() + "\n" + postAddr.toString() + "\n" 
				+ note + "\n";
		return s;
	}
	
	static final String XML_TAG = "Contact";
	
	Element toXmlElement(Document doc) {
		Element contactXml = doc.createElement(XML_TAG);
		contactXml.appendChild(name.toXmlElement(doc));
		if (postAddr != null) {
			contactXml.appendChild(postAddr.toXmlElement(doc));
		}
		if (emailAddr != null) {
			contactXml.appendChild(emailAddr.toXmlElement(doc));
		}
		if (phoneNum != null) {
			contactXml.appendChild(phoneNum.toXmlElement(doc));
		}
		if ( note != null) {
			Element noteXml = doc.createElement("Note");
			noteXml.setTextContent(note);
			contactXml.appendChild(noteXml);
		}
		return contactXml;
	}
	
	static Contact fromXml(Element e) {
		Name newName = Name.xmlToName((Element) e
				.getElementsByTagName(Name.XML_TAG).item(0));
		PostAddress newPostAddr = PostAddress.xmlToPostAddress((Element) e
				.getElementsByTagName(PostAddress.XML_TAG).item(0));
		EmailAddress newEmailAddr = EmailAddress.xmlToEmail((Element) e
				.getElementsByTagName(EmailAddress.XML_TAG).item(0));
		PhoneNumber newPhoneNum = PhoneNumber.xmlToPhoneNumber((Element) e
				.getElementsByTagName(PhoneNumber.XML_TAG).item(0));
		String newNote = e.getElementsByTagName("Note").item(0).getTextContent();
		
		Contact newContact = new Contact();
		newContact.setName(newName);
		newContact.setPostAddress(newPostAddr);
		newContact.setEmailAddress(newEmailAddr);
		newContact.setPhoneNumber(newPhoneNum);
		newContact.setNote(newNote);
		return newContact;
	}
		
}
