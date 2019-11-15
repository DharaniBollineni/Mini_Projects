package application.contact.list;

public class PersonalContact extends Contact {

	private String relation;
	private String note;
	private String dateOfBirth;

	// constructor
	public PersonalContact(String firstName, String lastName, String address, String email, String phone,
			String relation, String dateOfBirth, String note) {
		super(firstName, lastName, address, email, phone);
		this.dateOfBirth = dateOfBirth;
		this.relation = relation;
		this.note = note;
	}
	
	public PersonalContact() {
		
	}

	// overrides toStaing method
	public String toString() {
		return "Personal Contact details\n firstName " + getFirstName() + " Last Name " + getLastName() + " address "
				+ getAddress() + " email " + getEmail() + " phone " + getPhone() + " relation " + getRelation()
				+ "dateOfBirth" + getDateOfBirth() + "note " + getNote();

	}

	public void editOtherPersonalDetails() {
		System.out.println("Date of Birth (MM/DD/YYYY): ");
		setDateOfBirth(getInput());
		System.out.println("Enter the relationship");
		setRelation(getInput());
		System.out.println("Make a note");
		setNote(getInput());

	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
	public void addNewContact() {
		// TODO Auto-generated method stub
		
	}

}