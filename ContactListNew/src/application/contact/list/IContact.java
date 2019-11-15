package application.contact.list;

import java.util.List;

public interface IContact {
	void getInformation(); // all variables and methods are abstract and public by default.
	void updateInformation();
	void exploreContacts(String str,Contact ic);   // final thing 
	void deleteContact(Contact c);
	void addNewContact();
	
	List<Contact> getAllContacts();
	List<Contact> getAllBusinessContacts();
	List<Contact> getAllPersnlContacts();
}
