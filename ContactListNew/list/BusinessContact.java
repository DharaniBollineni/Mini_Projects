package application.contact.list;

public class BusinessContact extends Contact {

	
	//GST registration numbers   ---------> check this
	private String note;
	private String jobTitle;
	private String organization;
	private String type;
	//firstName, lastName, address, email, phone, jobTitle, organization,type,note
	public BusinessContact(String firstName, String lastName, String address, String email, String phone,
			  String jobTitle, String organization,String type, String note) {
		super(firstName, lastName, address, email, phone);
		this.jobTitle = jobTitle;
		this.organization = organization;
		this.note = note;
		this.type=type;
	}
	public String toString()
	{
		return "Bussiness Contact details\n firstName "+getFirstName()+" Last Name "+getLastName()+" address "+getPostalAddress()+" email "+getEmailID()+" phone "+getPhoneNumber()+"job title"+getJobTitle()+" type "+type+"Organization"+getOrganization()+" note "+getNote();
		
	}
	@Override
	public void viewContactDetails() {
		// TODO Auto-generated method stub
		
	}
   // getters and setters 
	public String getNote() {
		return note;
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
	
}
