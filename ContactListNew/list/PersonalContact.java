package application.contact.list;

public class PersonalContact extends Contact{

	private String relation;
	private String note;
	private String dateOfBirth;
	
	public PersonalContact(String firstName, String lastName, String address, String email, String phone,String relation, String dateOfBirth,String note) {
	    super(firstName, lastName, address, email, phone);
	    this.dateOfBirth=dateOfBirth;
	    this.relation = relation;
	    this.note = note;
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
	
	public String toString()
	{
		return "Personal Contact details\n firstName "+getFirstName()+" Last Name "+getLastName()+" address "+getPostalAddress()+" email "+getEmailID()+" phone "+getPhoneNumber()+" relation "+getRelation()+"dateOfBirth"+getDateOfBirth()+"note "+getNote();
		
	}


	@Override
	public void viewContactDetails() {
		// TODO Auto-generated method stub
		
	}

	
}