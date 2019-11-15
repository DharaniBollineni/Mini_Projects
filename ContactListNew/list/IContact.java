package application.contact.list;

import java.util.List;

public interface IContact {
	void getInformation();

	void updateInformation();

	void exploreContacts();

	void deleteContact();

	void addNewContact();

	void viewContactDetails();
	
	List<Contact> getAllContacts();
	
	List<Contact> getAllBusinessContacts();
	
	List<Contact> getAllPersnlContacts();
}
