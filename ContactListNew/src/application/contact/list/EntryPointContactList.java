package application.contact.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntryPointContactList {

	private Contact mainContact;
	Scanner sInput = new Scanner(System.in); // Create a Scanner object

	// initialization block --> check this
	{
		mainContact = new PersonalContact("Chinmayi", "Ch", "bangalore", "ch@gmail.com", "0202202", "family",
				"02Dec2014", "Hello chinmayi");
	}

	public void displayUI() {
		boolean entryFlag = true;
		while (entryFlag) {
			System.out.println("Enter 1 :: load file");
			System.out.println("Enter 2 :: add contact");
			System.out.println("Enter 3 :: view contacts");
			System.out.println("Enter 4 :: Edit details");
			System.out.println("Enter 5 :: Delete details");
			System.out.println("Enter 6 :: Explore Contact");
			System.out.println("Enter 10 :: Save file");
			System.out.println("Enter 15:: exit");
			int select = sInput.nextInt();
			sInput.nextLine();
			switch (select) {
			case 1:
				// loodFile();
				break;
			case 2:
				addContact();
				break;
			case 3:
				viewContacts();
				break;
			case 4:
				editContactDetails();
				break;
			case 5:
				deleteContactDetails();
				break;
			case 6: 
				exploreContacts();
			case 10:
				// saveToFile();
				break;
			case 15:
				entryFlag = false;

			}
		}
	}

	// add contact details
	private void addContact() {
		System.out.println("Please enter contact type 1:: Personal or 2:: Business: ");
		int contactType = sInput.nextInt();
		sInput.nextLine();
		if (contactType == 1) {
			addPersonalContact();
		} else if (contactType == 2) {
			addBusinessContact();
		}
	}

	private void addPersonalContact() {
		PersonalContact pc = new PersonalContact();
		getGeneralDetails(pc);
		getOtherPersonalDetails(pc);
		mainContact.addPersonalContact(pc);

	}

	private void addBusinessContact() {
		BusinessContact bc = new BusinessContact();
		getGeneralDetails(bc);
		getOtherBusinessDetails(bc);
		mainContact.addBusinessContact(bc);
	}

	private void getGeneralDetails(Contact contact) {
		System.out.println("First Name: ");
		contact.setFirstName(sInput.nextLine());
		System.out.println("Last Name: ");
		contact.setLastName(sInput.nextLine());
		System.out.println("Address: ");
		contact.setAddress(sInput.nextLine());
		System.out.println("E-mail address: ");
		contact.setEmail(sInput.nextLine());
		System.out.println("Phone number: ");
		contact.setPhone(sInput.nextLine());
		System.out.println("address");
		contact.setAddress(sInput.nextLine());

	}

	private void getOtherPersonalDetails(PersonalContact pc) {
		System.out.println("Date of Birth (MM/DD/YYYY): ");
		pc.setDateOfBirth(sInput.nextLine());
		System.out.println("Enter the relationship");
		pc.setRelation(sInput.nextLine());
		System.out.println("Make a note");
		pc.setNote(sInput.nextLine());
	}

	private void getOtherBusinessDetails(BusinessContact bc) {
		System.out.println("Job Title: ");
		bc.setJobTitle(sInput.nextLine());
		System.out.println("Organization: ");
		bc.setOrganization(sInput.nextLine());
		System.out.println("type of relation like Coworker / Individual contacts / serviceProvider: ");
		bc.setType(sInput.nextLine());
		System.out.println("Make a note");
		bc.setNote(sInput.nextLine());
	}

	// view contact details
	private void viewContacts() {
		System.out.println("Please enter contact type ");
		System.out.println("1:: Personal or 2:: Business: 3:: view all");
		System.out.println("4:: view a contact  ");
		int contactType = sInput.nextInt();
		sInput.nextLine();
		if (contactType == 1) {
			viewContacts(mainContact.getAllPersnlContacts());
		} else if (contactType == 2) {
			viewContacts(mainContact.getAllBusinessContacts());
		} else if (contactType == 3) {
			viewContacts(mainContact.getAllContacts());
		} else if (contactType == 4) {
			System.out.println("Enter Email Id");
			String email = sInput.nextLine();
			Contact ic = mainContact.lookUpAContact(email);
			if (ic != null) {
				System.out.println(ic);
			} else {
				System.out.println("Doesn't exist");
			}

		}
	}

	private void viewContacts(List<Contact> contactList) {
		for (Contact cnt : contactList) {
			System.out.println(cnt);
		}
	}

	// Delete contact details
	private void deleteContactDetails() {
		System.out.println("Enter Email Id");
		String email = sInput.nextLine();
		Contact ic = mainContact.lookUpAContact(email);
		if (ic != null) {
			mainContact.deleteContact(ic);
		} else {
			System.out.println("Doesn't exist");
		}

	}

	private void editContactDetails() {
		System.out.println("Enter Email Id");
		String email = sInput.nextLine();
		Contact ic = mainContact.lookUpAContact(email);
		if (ic != null) {
			System.out.println("Enter type of details to modify 1 for basic details and 2 for other details");
			int i = sInput.nextInt();
			sInput.nextLine();
			mainContact.editContactDetails(i, ic);
		} else {
			System.out.println("Doesn't exist");
		}

	}
	private void exploreContacts()
	{
		System.out.println("Enter Email Id");
		String email = sInput.nextLine();
		Contact ic = mainContact.lookUpAContact(email);
		if (ic != null) {
			System.out.println("Enter the relationship");
			String str = sInput.nextLine();
			mainContact.exploreContacts(str, ic);
		} else {
			System.out.println("Doesn't exist");
		}
		
	}

	// General method to load and save updated details to file
	public void loadFle() {

	}

	public void saveToFile() {

	}

	public static void main(String[] args) {
		EntryPointContactList ep = new EntryPointContactList();
		ep.displayUI();

	}

}
