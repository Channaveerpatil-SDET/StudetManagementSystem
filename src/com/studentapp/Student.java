package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	//instance variable are private for now (below)
	private String name;
	private	int age;
	private String studentId;
	private List<String> courses;
	
	
	
	public Student(String name, int age, String studentId) {
		super();
		if(ValidateAge(age) &&  ValidateName(name)  &&  ValidatestudentId(studentId)) {
		this.name = name;

		this.age = age;
		this.studentId = studentId;
		courses = new ArrayList<String>(); //intialization the Courses.
	}
	}
	
	public void enrollCourse(String course) {
		
		if(ValidateCourseName(course)) {
		if(!courses.contains(course)) {
			courses.add(course);
			System.out.println("Studnet enrolled to "+ course +" Successfully!!! ");
		}else {
		System.err.println("Student is already enrolled to this course : " + course);
		}
		}
		
	}
	
	public void printStudentInfo() {
		System.out.println("**** Student informatio ****");
		System.out.println("Student Name : "+ name);
		System.out.println("Student Age : "+ age);
		System.out.println("Student ID : "+ studentId);
		System.out.println("Student Enrolled : "+ courses);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	
	public boolean ValidateAge(int age) {
		if(age>=19 && age<=35) {
			return true;
			
		}else {
			System.err.println("Invalid age !!  student age did not met Criteria of 19 and 35");
			return false;
		}
	}
	
	
	public boolean ValidateName(String name) {
		
		String  nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern=Pattern.compile(nameRegex);
		Matcher nameMatcher= namePattern.matcher(name);
		
		if(nameMatcher.matches()) {
			
			return true;
			
		}else {
			
			System.err.println("Invalid Name !!  Name did not met Criteria, Please Enter only Alphabets ");
			return false;
		}
	}
	
	
	private boolean ValidatestudentId(String studentId) {
		String StudentIdRegex = "S-\\d+$";
	Pattern StudentIdPattern=Pattern.compile(StudentIdRegex);
	Matcher studentIdMatcher=StudentIdPattern.matcher(studentId);
	if(studentIdMatcher.matches()) {
		
		return true;
	}else {
		System.err.println("Invalid studentid !! ");
	}
		return false;
	}

	public boolean ValidateCourseName(String  course) {
		
		if(course.equals("Java")||course.equalsIgnoreCase("Python")||course.equalsIgnoreCase("DSA)")||course.equalsIgnoreCase("DEVOPS")) {
			
			return true;
		}else {
			
			System.err.println("Invalid Course Name !! Please Select the Courses from LIST !![Java,python,Devops");
			
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

	
	
}
