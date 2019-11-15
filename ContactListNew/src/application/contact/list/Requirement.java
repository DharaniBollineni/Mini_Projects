//package application.contact.list;
//
//public class Requirement {
//
//	
//	//1. get contact names, phone numbers, email addresses, postal addresses, birthdays, 
//	//    GST registration numbers, employers, employees, relationships, and notes  ---> check GST
//	
//	//2. pieces of information can change over time, and the user wants to be able to get a 
//	//current report of applicable information for any contact after looking them up
//	
//	//3.They want to be able to explore the contacts: after viewing a contact, they 
//	//should be able to move on easily to viewing one of their relatives or employees, or their employer
//	
//	//4. Contacts should be deletable, modifiable, and addable, and their interconnections should be changeable.
//	
//	//5.The user interface can be either textual or graphical, and you may include saving and loading to file if you wish.
//	
//	
//	
//	// update
//		public void editGeneralDetails(Contact ic) {
//			System.out.println("First Name: ");
//			ic.setFirstName(getInput());
//			System.out.println("Last Name: ");
//			ic.setLastName(getInput());
//			System.out.println("Address: ");
//			ic.setLastName(getInput());
//			System.out.println("E-mail address: ");
//			ic.setEmail(getInput());
//			System.out.println("Phone number: ");
//			ic.setPhone(getInput());
//			System.out.println("address");
//			ic.setAddress(getInput());
//		}
//
//		public void editOtherBusinessDeatails(Contact ic) {
//
//			System.out.println("Job Title: ");
//			((BusinessContact) ic).setJobTitle(getInput());
//			System.out.println("Organization: ");
//			((BusinessContact) ic).setOrganization(getInput());
//			System.out.println("type of relation like Coworker / Individual contacts / serviceProvider: ");
//			((BusinessContact) ic).setType(getInput());
//			System.out.println("Make a note");
//			((BusinessContact) ic).setNote(getInput());
//
//		}
//
//		public void editOtherPersonalDetails(Contact ic) {
//			System.out.println("Date of Birth (MM/DD/YYYY): ");
//			((PersonalContact) ic).setDateOfBirth(getInput());
//			System.out.println("Enter the relationship");
//			((PersonalContact) ic).setRelation(getInput());
//			System.out.println("Make a note");
//			((PersonalContact) ic).setNote(getInput());
//
//		}
//	
//	
//	
//	
//	
//	
//	
//}
