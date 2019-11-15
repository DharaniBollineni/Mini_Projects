package application.contact.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntryPointContactList {

	Contact dharani;
	
	//initialization block
	{
		dharani = new PersonalContact("","","","","","","","");
	}

	public void displayUI() {
		boolean entryFlag = true;
		while (entryFlag) {
			System.out.println("Enter 1 :: load file");
			System.out.println("Enter 2 :: add contact");
			System.out.println("Enter 3 :: view contacts");
			System.out.println("Enter 4 :: Edit details");
			System.out.println("Enter 5 :: Delete details");
			System.out.println("Enter 10 :: Save file");
			System.out.println("Enter 15:: exit");
			int select = sInput.nextInt();
			sInput.nextLine();
			switch (select) {
			case 1:
				// loodFile();
				break;
			case 2:
				addContacts();
				break;
			case 3:
				viewContacts();
				break;
			case 4:
				editContactDetails();
				break;
			case 5:
				deleteContactDetails();
			case 10:
				// saveToFile();
				break;
			case 15:
				entryFlag = false;

			}
		}
	}

	// Delete contact details
	private void deleteContactDetails()
	{
		dharani.deleteContact();
	}
	// Edit a contact detail
	private void editContactDetails() {
		Contact ic = lookUpAContact();
		if (ic != null) {
			System.out.println(ic);
			System.out.println("Enter 1 for general details 2 for other details");
			int select = sInput.nextInt();
			sInput.nextLine();
			switch (select) {
			case 1:
				editGeneralDetails(ic);
				break;

			case 2:

				if (ic instanceof PersonalContact) {
					editOtherPersonalDetails(ic);
				}

				else if (ic instanceof BusinessContact) {
					editOtherBusinessDeatails(ic);

				} else {
					System.out.println("not available");
				}
				break;
			}
		}
	}

	// add contact details
	private void addContacts() {

		System.out.println("Please enter contact type 1:: Personal or 2:: Business: ");
		int contactType = sInput.nextInt();
		sInput.nextLine();
		if (contactType == 1) {
			getGeneralDetails();
			getOtherPersonalDetails();
			PersonalContact pc = new PersonalContact(firstName, lastName, address, email, phone, relation, dateOfBirth,
					note);
			listOfContacts.add(pc);

		} else if (contactType == 2) {
			getGeneralDetails();
			getOtherBusinessDetails();
			BusinessContact bc = new BusinessContact(firstName, lastName, address, email, phone, jobTitle, organization,
					type, note);
			listOfContacts.add(bc);
		}
	}

	// view contact details
	private void viewContacts() {
		System.out.println("Please enter contact type ");
		System.out.println("1:: Personal or 2:: Business: 3:: view all");
		System.out.println("4:: view a contact  ");
		int contactType = sInput.nextInt();
		sInput.nextLine();
		if (contactType == 1) {
			viewAllPersonalContact();
		} else if (contactType == 2) {
			viewAllBusinessContact();
		} else if (contactType == 3) {

			viewAllContacts();
		} else if (contactType == 4) {
			Contact ic = lookUpAContact();
			if (ic != null)
				System.out.println(ic);
			else
				System.out.println("not available");

		}

		// note: view all contacts
		// contactlist.get(index).viewContacts();
		// note2: view only personal contacts
		// get list of personal contacts

	}

	// view all personalInforamtion
	private void viewAllPersonalContact() {
		System.out.println("All personal Information");
		for (Contact ic : listOfContacts) {
			if (ic instanceof PersonalContact) {
				System.out.println(ic);
			}
		}
	}

	// view all business information
	private void viewAllBusinessContact() {
		for (Contact ic : listOfContacts) {
			if (ic instanceof BusinessContact) {
				System.out.println(ic);
			}
		}
	}

	// view all contacts like a personal details/ a general details
	private void viewAllContacts() {
		for (Contact ic : listOfContacts) {
			System.out.println(ic);
		}
	}

	private Contact lookUpAContact() {
		System.out.println("Enter FirstName");
		String name = sInput.nextLine();
		for (Contact ic : listOfContacts) {
			if (ic.getFirstName().equals(name)) {
					return ic;

			}

		}
		return null;
	}

	// get details
	public String getInput() {
		return sInput.nextLine();

	}

	// get basic information55
	private void getGeneralDetails()//
	{
		System.out.println("First Name: ");
		firstName = sInput.nextLine();
		System.out.println("Last Name: ");
		lastName = sInput.nextLine();
		System.out.println("Address: ");
		address = sInput.nextLine();
		System.out.println("E-mail address: ");
		email = sInput.nextLine();
		System.out.println("Phone number: ");
		phone = sInput.nextLine();

		System.out.println("address" + address);

	}

	// get other personal information
	private void getOtherPersonalDetails() {
		System.out.println("Date of Birth (MM/DD/YYYY): ");
		dateOfBirth = sInput.nextLine();
		System.out.println("Enter the relationship");
		relation = sInput.nextLine();
		System.out.println("Make a note");
		note = sInput.nextLine();
	}

	// get other Business information
	private void getOtherBusinessDetails() {
		System.out.println("Job Title: ");
		jobTitle = sInput.nextLine();
		System.out.println("Organization: ");
		organization = sInput.nextLine();
		System.out.println("type of relation like Coworker / Individual contacts / serviceProvider: ");
		type = sInput.nextLine();
		System.out.println("Make a note");
		note = sInput.nextLine();

	}

	// update
	public void editGeneralDetails(Contact ic) {
		System.out.println("First Name: ");
		ic.setFirstName(getInput());
		System.out.println("Last Name: ");
		ic.setLastName(getInput());
		System.out.println("Address: ");
		ic.setLastName(getInput());
		System.out.println("E-mail address: ");
		ic.setEmailID(getInput());
		System.out.println("Phone number: ");
		ic.setPhoneNumber(getInput());
		System.out.println("address" + address);
		ic.setPostalAddress(getInput());
	}

	public void editOtherBusinessDeatails(Contact ic) {

		System.out.println("Job Title: ");
		((BusinessContact) ic).setJobTitle(getInput());
		System.out.println("Organization: ");
		((BusinessContact) ic).setOrganization(getInput());
		System.out.println("type of relation like Coworker / Individual contacts / serviceProvider: ");
		((BusinessContact) ic).setType(getInput());
		System.out.println("Make a note");
		((BusinessContact) ic).setNote(getInput());

	}

	public void editOtherPersonalDetails(Contact ic) {
		System.out.println("Date of Birth (MM/DD/YYYY): ");
		((PersonalContact) ic).setDateOfBirth(getInput());
		System.out.println("Enter the relationship");
		((PersonalContact) ic).setRelation(getInput());
		System.out.println("Make a note");
		((PersonalContact) ic).setNote(getInput());

	}

	// General method to load and save updated details to file
	public void loadFle() {

	}

	public void saveToFile() {

	}

	public List<Contact> getListOfContacts() {
		return listOfContacts;
	}

	public void setListOfContacts(List<Contact> listOfContacts) {
		this.listOfContacts = listOfContacts;
	}

	public static void main(String[] args) {
		new EntryPointContactList();

	}

}
