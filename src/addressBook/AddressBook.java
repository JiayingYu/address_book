package addressBook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
			if(currCon.getName().contains(name)){
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
			if(currCon.getPostAddr().contains(postAddr)){
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
			if(currCon.getPhoneNum().contains(phoneNum)){
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
			if(currCon.getEmailAddr().contains(emailAddr)){
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
			if(currCon.getNote().contains(note)){
				int currConIndex = addrBook.indexOf(currCon);
				result.add(currConIndex);
			}
		}
		return result;
	}
	
	public void remove(int index){
		addrBook.remove(index);
	}

	@Override
	public String toString(){
		String s = "";
		Iterator<Contact> it = addrBook.iterator();
		while(it.hasNext()) {
			s += it.next().toString();
		}
		return s;
	}
	
	static final String XML_NAME = "AddressBook";
	
	public static AddressBook load(String filePath) 
			throws SAXException, IOException, ParserConfigurationException {
		InputStream input = new FileInputStream(filePath);
		return load(input);
	}
	
	public static AddressBook load(InputStream input) 
			throws SAXException, IOException, ParserConfigurationException {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(input);
		Element root = doc.getDocumentElement();
		AddressBook addrBook = new AddressBook();
		
		NodeList nodes = root.getElementsByTagName(Contact.XML_TAG);
		for (int i = 0; i < nodes.getLength(); i++) {
			Contact newContact = Contact.fromXml((Element) nodes.item(i));
			addrBook.addContact(newContact);
		}
		return addrBook;
	}
	
	public void save(String filePath) throws FileNotFoundException, 
	ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		OutputStream output =  new FileOutputStream(filePath);
		save(output);
	}
	
	public void save(OutputStream output) throws ParserConfigurationException, 
	TransformerFactoryConfigurationError, TransformerException {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.newDocument();
		Element root = doc.createElement(XML_NAME);
		doc.appendChild(root);
		for (Contact c: addrBook) {
			Element contactXml = c.toXmlElement(doc);
			root.appendChild(contactXml);
		}
		
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.transform(new DOMSource(doc), new StreamResult(output));
	}
}
