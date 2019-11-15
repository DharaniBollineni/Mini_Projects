package application.contact.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Contact implements IContact{
// variable declaration
	private String firstName;
	
	private String lastName;
	private String phone;
	private String email;
	private String address;
	
	List<PersonalContact> employees;
	List<PersonalContact> friends;
	List<PersonalContact> family;
	List<BusinessContact> businesses;
	List<BusinessContact> coleagues;
	List<BusinessContact> indvContacts;
		
	public Contact(String firstName, String lastName, String address, String email, String phone){
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.address = address;
	    this.email = email;
	    this.phone = phone;
	}

	@Override
	public void getInformation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInformation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exploreContacts() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContact() {
		//get email 
		Iterator<Contact> cntItr = getAllContacts().iterator();
		while(cntItr.hasNext()) {
			Contact cnt = cntItr.next();
			if(cnt.getEmail().equals("")) {
				cntItr.remove();
			}
		}
	}

	@Override
	public void addNewContact() {
		// get type
		
		
	}
	
	public void addbusinessContact() {
		
	}
	
	public void addPersonalContact() {
		
	}

	@Override
	public void viewContactDetails() {
		// TODO Auto-generated method stub
		
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
	
}
