package mapUpdated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {

	private String code;
	private String name;
	private String grade;
	private List<SchoolStudent> enrolledStudent = new ArrayList<>();	
	private Map<SchoolStudent, String> courseGrade = new HashMap<SchoolStudent, String>();
	
	
	//array list of student class
	public Course(String code,String name) {//String grade) {
		this.code= code;
		this.name=name;
		//this.grade = grade;	// confused ????
	}
	public void addStudentInCourses(SchoolStudent s)
	{
		this.enrolledStudent.add(s);		
	}
	public void removeStudent(SchoolStudent s)
	{
		this.enrolledStudent.remove(s);		
	}
	public void updateCourseWithGrade(SchoolStudent s, String grade)
	{
//		c.setGrade(grade);
		setCourseGrade(s, grade);
		enrolledStudent.remove(s);
		
	}
	public void printFinishedCourse()
	{
		 for (Map.Entry<SchoolStudent, String> e : courseGrade.entrySet()) { // get object in hashmap
				System.out.println("The value of letter " + e.getKey() + " is " + e.getValue()); 
	}
	}
//		for (String code : coursesMap.keySet()) { // get key from hashMap list
//			System.out.println(code + "         " + coursesMap.get(code).getName()); // get value at c
//		}
		
//	}
	
	public String toString() {
		return code +" "+ name;
	}
	// getters and setters
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	public List<SchoolStudent> getEnrolledStudent() {
		return enrolledStudent;
	}
	public void setEnrolledStudent(List<SchoolStudent> enrolledStudent) {
		this.enrolledStudent = enrolledStudent;
	}
	
	public Map<SchoolStudent, String> getCourseGrade() {
		return courseGrade;
	}
	public void setCourseGrade(SchoolStudent s, String g) {
		courseGrade.put(s, g);
		this.courseGrade = courseGrade;
	}
}
