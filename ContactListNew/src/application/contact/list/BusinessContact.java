package application.contact.list;

public class BusinessContact extends Contact {

	// GST registration numbers ---------> check this
	private String note;
	private String jobTitle;
	private String organization;
	private String type;

	// 
	public BusinessContact()
	{
		
	}
	// firstName, lastName, address, email, phone, jobTitle, organization,type,note
	public BusinessContact(String firstName, String lastName, String address, String email, String phone,
			String jobTitle, String organization, String type, String note) {
		super(firstName, lastName, address, email, phone);
		this.jobTitle = jobTitle;
		this.organization = organization;
		this.note = note;
		this.type = type;
	}

	// toString implementation
	public String toString() {
		return "Bussiness Contact details\n firstName " + getFirstName() + " Last Name " + getLastName() + " address "
				+ getAddress() + " email " + getEmail() + " phone " + getPhone() + "job title" + getJobTitle()
				+ " type " + type + "Organization" + getOrganization() + " note " + getNote();

	}

	// getters and setters
	public String getNote() {
		return note;
	}
	public void editOtherBusinessDeatails() {
		System.out.println("Job Title: ");
		setJobTitle(getInput());
		System.out.println("Organization: ");
		setOrganization(getInput());
		System.out.println("type of relation like Coworker / Individual contacts / serviceProvider: ");
		setType(getInput());
		System.out.println("Make a note");
		setNote(getInput());

	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
