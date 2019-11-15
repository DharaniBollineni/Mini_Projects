package mapUpdated;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class SchoolEntryPoint {

	public String fileName = "data.txt";
	SchoolStudent schoolStudent = new SchoolStudent();
	Map<String, SchoolStudent> studentsMap = new HashMap<String, SchoolStudent>();
	Map<String, Course> coursesMap = new HashMap<String, Course>();
	Scanner sInput = new Scanner(System.in); // Create a Scanner object

	public SchoolEntryPoint() throws FileNotFoundException {

		boolean entryFlag = true;
		// User interface
		while (entryFlag) {

			System.out.println("Enter 1 :: load file");
			System.out.println("Enter 2 :: add new student");
			System.out.println("Enter 3 :: add new course");
			System.out.println("Enter 4 :: Enroll a student into a course");
			System.out.println("Enter 5 :: Assign a grade to a student in a course");
			System.out.println("Enter 6 :: Unenroll a student from a course");
			System.out.println("Enter 7 :: Display all current enrolled students");
			System.out.println("Enter 8 :: Display all courses");
			System.out.println("Enter 9 :: The grades the student received in all courses they have completed");
			System.out.println("Enter 10 :: A list of all courses the student is currently - no grade");
			System.out.println("Enter 11 :: How many students are in the course");
			System.out.println("Enter 12 :: All students currently enrolled in the course");
			System.out.println("Enter 13 :: The grades given to all students who have completed the course");
			System.out.println("Enter 14 :: Looking up students by name");
			System.out.println("Enter 15 :: Looking up students by ID");
			System.out.println("Enter 100 to Quit");
			int n = sInput.nextInt();
			sInput.nextLine();
			if (n == 1) {

				loadFile();
				// --> addStudents
				// --> addCourse
				// --> enrolled
				// --> updateGradeOfCourse
			} else if (n == 2) {
				// add new student to studentmap
				System.out.println("Enter the student name");
				String name = sInput.nextLine();
				if (!studentsMap.containsKey(name)) { // unique name and id
					addNewStudents(name);
				} else {
					System.out.println("That student already existed");
				}
			}

			else if (n == 3) {
				// add new course to coursemap
				System.out.println("Enter the Course name");
				String name = sInput.nextLine();
				if (!coursesMap.containsKey(name)) {
					addNewCourse(name);
				} else {
					System.out.println("That Course already existed");
				}
			}
			else if(n==4)
			{
				//Enroll a student into a course			
				System.out.println("Enter the course Code");
				String code = sInput.nextLine();
				if(coursesMap.containsKey(code))
				{
					boolean flag=false;
					Course c=coursesMap.get(code);
					System.out.println("Enter the Student ID");
					int Id = sInput.nextInt();		
					Iterator<SchoolStudent> stdItr = studentsMap.values().iterator(); // note:iterate by value not by key
					while(stdItr.hasNext()) {
						SchoolStudent std = stdItr.next();
						if(std.getsID()==Id) {
							std.addCourse(c); // add course to student
							c.addStudentInCourses(std);	// add student to course	
							System.out.println(std);
							flag=true;
							break;
						}
					}
					if(flag==false)
					{
						System.out.println("No student found for the given id");
					}
					
				}else {
					System.out.println("course is not found");
				}			
			}
			else if(n==5)
			{
				// Assign a grade to a student in a course
				System.out.println("Enter the course Code");
				String code = sInput.nextLine();
				System.out.println("Enter the grade");
				String grade = sInput.nextLine();
				if(coursesMap.containsKey(code))
				{
					boolean flag=false;
					//Course c=coursesMap.get(code);
					System.out.println("Enter the Student ID");
					int Id = sInput.nextInt();		
					Iterator<SchoolStudent> stdItr = studentsMap.values().iterator(); // note:iterate by value not by key
					while(stdItr.hasNext()) {
						SchoolStudent std = stdItr.next();
						if(std.getsID()==Id) {
							for(int i=0;i<=std.getEnrolled().size();i++) {							// check each course of the student enrolled   ???
								Course c = std.getEnrolled().get(i);
								if (c.getCode().equals(code)) {
									std.updateGrade(c, grade);
									c.setCourseGrade(std, grade);//put(s, grade); 
					}
							}
							flag=true;
							break;
						}
					}
					if(flag==false)
					{
						System.out.println("No student found for the given id");
					}
					
				}else {
					System.out.println("course is not found");
				}			
				
			}
			else if(n==6)
			{
				// Unenroll a student from a course
				System.out.println("Enter the course Code");
				String code = sInput.nextLine();
				if(coursesMap.containsKey(code))
				{					
					boolean flag=false;
					Course c=coursesMap.get(code);
					System.out.println("Enter the Student ID");
					int Id = sInput.nextInt();		
					Iterator<SchoolStudent> stdItr = studentsMap.values().iterator(); // note:iterate by value not by key
					while(stdItr.hasNext()) {
						SchoolStudent std = stdItr.next();
						if(std.getsID()==Id) {
							std.removeCourse(c); // remove course to student
							c.removeStudent(std);	// remove student to course						
							flag=true;
							break;
						}
					}
					if(flag==false)
					{
						System.out.println("No student found for the given id");
					}
					
				}else {
					System.out.println("course is not found");
				}			
				
			}
			else if(n==7)
			{
				System.out.println("All current enrolled students the course");
				String  code= sInput.nextLine();
				displayAllenrolledStudents(code);
			}	
			else if(n==8)
			{
				System.out.println("All courses");
				displayAllCourses();
			}	
			else if (n==9)
			{
				System.out.println("completed:The grades the student received in all courses they have completed");
				//hint: lookAtStudentCompletedCourses()
				//-->finishedCourse get course and grade
				//DiaplayStudentCompletedCourses();
				System.out.println("Enter the Student id");
				int Id = sInput.nextInt();
				Iterator<SchoolStudent> stdItr = studentsMap.values().iterator(); // note:iterate by value not by key
				while(stdItr.hasNext()) {
					SchoolStudent std = stdItr.next();
					if(std.getsID()==Id) {
					
						System.out.println(std.getFinishedCourse());
						
					}
//						for(Course c: std.getFinishedCourse().get(key))
//						System.out.println(std.getFinishedCourse().get);
//						 for ())
						
				}
				
			}
			else if (n==10)
			{
				//in progress:A list of all courses the student is currently enrolled in (those which do not yet have grades)
				//hint: lookAtStudentCurrentCourse()
					//--> display enrolled arraylist
				System.out.println("Enter the Student id");
				int id = sInput.nextInt();
				sInput.nextLine();
				Iterator<SchoolStudent> stdItr = studentsMap.values().iterator(); // note:iterate by value not by key
				while(stdItr.hasNext()) {
					SchoolStudent std = stdItr.next();
					if(std.getsID()==id) {
						for (Course c : std.getEnrolled()) {
							System.out.println(c);
					}
					}
				}
				
			}
			else if (n==11)
			{
				//1:How many students are in the course            --> hint: c.enrolledStudent.size();
				System.out.println("Enter the course Code");
				String code = sInput.nextLine();
				Course c= coursesMap.get(code);
				System.out.println(c.getEnrolledStudent().size()); // no of students under a course
				
			}
			else if (n==12)
			{
				// 2: All students currently enrolled in the course 
				//--> hint: display enrolledStudent's arraylist for that course
				System.out.println("Enter the course Code");
				String code = sInput.nextLine();
				Course c= coursesMap.get(code);
				for(SchoolStudent s: c.getEnrolledStudent())
				{
					System.out.println(s);
				}			
			}
			else if (n==13)
			{
				//3: The grades given to all students who have completed the course 
				//--> hint: display courseGrade map for that student and grade
				System.out.println("Enter the course Code");
				String code = sInput.nextLine();
				
				if(coursesMap.containsKey(code))
				{
					Course c= coursesMap.get(code);
					c.printFinishedCourse();
				}
			}
			else if (n==14)
			{
				//Looking up students by name. 
				//This will require getting them from a HashMap.
				//searchStudentsByName()
				System.out.println("Enter the student name");
						String name = sInput.nextLine();
				if(studentsMap.containsKey(name))
				{
					SchoolStudent s= studentsMap.get(name);					
					System.out.println("Student ID"+ s.getsID()+" student name " + name + " is available");
					// print all information??? 
				}
			}
			else if (n==15)
			{
				// Looking up students by ID
				System.out.println("Enter the student id");
				int Id = sInput.nextInt();
				sInput.nextLine();
				SchoolStudent student = null;
				Iterator<SchoolStudent> stdItr = studentsMap.values().iterator();
				while(stdItr.hasNext()) {
					SchoolStudent std = stdItr.next();
					if(std.getsID()==Id)
					{
						System.out.println("Student ID"+ Id+" student name " + std.getsName() + " is available");
						// print all information??? 
					}
						
				}
			}
			
			else if (n == 100) // 30 to Quit
			{
				entryFlag = false;
			} else {
				System.out.println("Invalied input......");
			}
		}
	}

	private static void setCourses(SchoolStudent stnd, Course c, String grade) {
		if ("-".equals(grade)) {
			stnd.addCourse(c);
			c.addStudentInCourses(stnd);
		} else {

			stnd.updateGrade(c, grade);
			c.updateCourseWithGrade(stnd, grade);
		}
	}

	private void loadFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("lib/data.txt"));

		while (sc.hasNextLine()) {
			String course = sc.next().trim();
			String grade = sc.next().trim();
			String name = sc.nextLine().trim();

			// Course c = new Course(course, course);

			// Adding unique course to courses map
			if (!coursesMap.containsKey(course)) {
				coursesMap.put(course, new Course(course, course));
			}

			// add Students to studentsMap
			if (studentsMap.containsKey(name)) {
				SchoolStudent stnd = studentsMap.get(name);
				Course c = coursesMap.get(course);
				setCourses(stnd, c, grade);
			}
			// add elements to map by name as key
			else if (!studentsMap.containsKey(name)) {
				SchoolStudent s = new SchoolStudent(name);
				studentsMap.put(name, s);
				Course c = coursesMap.get(course);

				setCourses(s, c, grade);
			}

		}
	}

	// manually add new students
	private void addNewStudents(String name) {
		SchoolStudent s = new SchoolStudent(name);
		studentsMap.put(name, s);
	}

	// manually add new course
	private void addNewCourse(String cName) {
		Course c = new Course(cName, cName);
		coursesMap.put(cName, c);
	}

	// display all enrolled/ current students
	private void displayAllenrolledStudents(String code) {
		// System.out.println("Student Id Student name" );
		// for (String name : studentsMap.keySet()) { // get key from hashMap list
		// System.out.println(studentsMap.get(name).getsID()+" "+name); // get value at
		// c
		// }

		if (coursesMap.containsKey(code)) {
			Course c = coursesMap.get(code);
			for (int i = 0; i < c.getEnrolledStudent().size(); i++)
				System.out.println(c.getEnrolledStudent().get(i).getsName());
		}

	}

	// display all course with code
	private void displayAllCourses() {
		System.out.println("Course Code       Courase name");
		for (String code : coursesMap.keySet()) { // get key from hashMap list
			System.out.println(code + "         " + coursesMap.get(code).getName()); // get value at c
		}

	}

	public static void main(String[] arg) throws FileNotFoundException {
		new SchoolEntryPoint();

	}

}