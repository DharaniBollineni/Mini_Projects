package application.contact.list;

import java.util.ArrayList;
/*
 * void getInformation(); // all variables and methods are abstract and public by default.
	void updateInformation();
	void exploreContacts();   // final thing 
	void deleteContact(Contact c);
	void addNewContact();
	note can implement all this here by passing the object
 */
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public abstract class Contact implements IContact {
	// variable declaration
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String address;

	private List<PersonalContact> employees;
	private List<PersonalContact> friends;
	private List<PersonalContact> family;
	private List<BusinessContact> businesses;
	private List<BusinessContact> coleagues;
	private List<BusinessContact> indvContacts;

	Scanner sInput = new Scanner(System.in); // Create a Scanner object

	public Contact() {
		employees = new ArrayList<>();
		friends = new ArrayList<>();
		family = new ArrayList<>();
		businesses = new ArrayList<>();
		coleagues = new ArrayList<>();
		indvContacts = new ArrayList<>();
	}

	public Contact(String firstName, String lastName, String address, String email, String phone) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	public void addPersonalContact(PersonalContact pc) {
		switch (pc.getRelation()) {
		case "friend":
			friends.add(pc);
			break;
		case "family":
			family.add(pc);
			break;
		case "employees":
			employees.add(pc);
			break;
		}
	}

	public void addBusinessContact(BusinessContact bc) {
		switch (bc.getType()) {
		case "businesses":
			businesses.add(bc);
			break;
		case "coleagues":
			coleagues.add(bc);
			break;
		case "indvContacts":
			indvContacts.add(bc);
			break;

		}
	}

	public void editContactDetails(int i, Contact c) {
		if (employees.contains(c)) {
			switch (i) {
			case 1:
				c.editGeneralDetails();
				break;
			case 2:
				((PersonalContact) c).editOtherPersonalDetails(); 
				// check this i thing they have to be in contact class rather then in personalContact or BusinessContact
				break;
			}
		} else if (friends.contains(c)) {
			switch (i) {
			case 1:
				c.editGeneralDetails();
				break;
			case 2:
				((PersonalContact) c).editOtherPersonalDetails();
				break;
			}
		} else if (family.contains(c)) {
			switch (i) {
			case 1:
				c.editGeneralDetails();
				break;
			case 2:
				((PersonalContact) c).editOtherPersonalDetails();
				break;
			}
		} else if (businesses.contains(c)) {
			switch (i) {
			case 1:
				c.editGeneralDetails();
				break;
			case 2:
				((BusinessContact) c).editOtherBusinessDeatails();
				break;
			}
		} else if (coleagues.contains(c)) {
			switch (i) {
			case 1:
				c.editGeneralDetails();
				break;
			case 2:
				((BusinessContact) c).editOtherBusinessDeatails();
				break;
			}
		} else if (indvContacts.contains(c)) {
			switch (i) {
			case 1:
				c.editGeneralDetails();
				break;
			case 2:
				((BusinessContact) c).editOtherBusinessDeatails();
				break;
			}
		}

	}

	public void editGeneralDetails() {
		System.out.println("First Name: ");
		setFirstName(getInput());
		System.out.println("Last Name: ");
		setLastName(getInput());
		System.out.println("Address: ");
		setLastName(getInput());
		System.out.println("E-mail address: ");
		setEmail(getInput());
		System.out.println("Phone number: ");
		setPhone(getInput());
		System.out.println("address");
		setAddress(getInput());
	}

	@Override
	public List<Contact> getAllBusinessContacts() {
		List<Contact> allBusContacts = new ArrayList<>();
		allBusContacts.addAll(businesses);
		allBusContacts.addAll(coleagues);
		allBusContacts.addAll(indvContacts);
		return allBusContacts;
	}

	@Override
	public List<Contact> getAllPersnlContacts() {
		List<Contact> allPrsnlContacts = new ArrayList<>();
		allPrsnlContacts.addAll(employees);
		allPrsnlContacts.addAll(friends);
		allPrsnlContacts.addAll(family);
		return allPrsnlContacts;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> allContacts = new ArrayList<>();
		allContacts.addAll(getAllBusinessContacts());
		allContacts.addAll(getAllPersnlContacts());
		return allContacts;
	}

	@Override
	public void deleteContact(Contact c) {
		// get email
		if (employees.contains(c)) {   // to delete in loop then use iterator not  for loop
			employees.remove(c);
		} else if (friends.contains(c)) {
			friends.remove(c);
		} else if (businesses.contains(c)) {
			businesses.remove(c);
		} else if (coleagues.contains(c)) {
			coleagues.remove(c);
		} else if (indvContacts.contains(c)) {
			indvContacts.remove(c);
		}
		// Iterator<Contact> cntItr = getAllContacts().iterator();
		// while (cntItr.hasNext()) {
		// Contact cnt = cntItr.next();
		// if (cnt.getEmail().equals("email")) {
		// cntItr.remove();
		// }
		// }
	}

	public Contact lookUpAContact(String email) {
		List<Contact> allContacts = getAllContacts();
		for (Contact ic : allContacts) {
			if (ic.getEmail().equals(email)) {
				return ic;
			}

		}
		return null; // check this
	}

	@Override
	public void exploreContacts(String str,Contact ic) {

		//They want to be able to explore the contacts: after viewing a contact, they 
		//should be able to move on easily to viewing one of their relatives or employees, or their employer
		if(ic==null)
		{
			return;
		}
		else
		{
			System.out.println("Contact name "+ic.getFirstName());
			System.out.println("Enter Email Id");
			String email = sInput.nextLine();
			ic = lookUpAContact(email); // lookup by relation --> check this
			if (ic != null) {
				System.out.println("Enter the relationship"); // or name --> check this
				String str1 = sInput.nextLine();
				exploreContacts(str1, ic);
				}
			else
			{
				System.out.println("Doesn't exist");
			}
			
		}	
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<PersonalContact> getEmployees() {
		return employees;
	}

	public void setEmployees(List<PersonalContact> employees) {
		this.employees = employees;
	}

	public List<PersonalContact> getFriends() {
		return friends;
	}

	public void setFriends(List<PersonalContact> friends) {
		this.friends = friends;
	}

	public List<PersonalContact> getFamily() {
		return family;
	}

	public void setFamily(List<PersonalContact> family) {
		this.family = family;
	}

	public List<BusinessContact> getBusinesses() {
		return businesses;
	}

	public void setBusinesses(List<BusinessContact> businesses) {
		this.businesses = businesses;
	}

	public List<BusinessContact> getColeagues() {
		return coleagues;
	}

	public void setColeagues(List<BusinessContact> coleagues) {
		this.coleagues = coleagues;
	}

	public List<BusinessContact> getIndvContacts() {
		return indvContacts;
	}

	public void setIndvContacts(List<BusinessContact> indvContacts) {
		this.indvContacts = indvContacts;
	}

	// get details
	public String getInput() {
		return sInput.nextLine();

	}
}
