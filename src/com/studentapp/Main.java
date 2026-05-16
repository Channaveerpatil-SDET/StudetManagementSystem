package com.studentapp;

public class Main {

	public static void main(String[] args) {


	 System.out.println("*****Student  Management System****");
	 
	 Student s1;
	 s1= new Student("ROCKS patils", 22 , "S-16");
	 s1.enrollCourse("Java");
	// s1.enrollCourse("DEVOPS");
	//s1.printStudentInfo();
	// System.out.println(s1);
	 s1.printStudentInfo();
	 
	 
	 Student s2 = new Student ("Appu",24, "S-18");
	 s2.enrollCourse("Python");
	 s2.printStudentInfo();
	 
	 
	 Student s3 = new Student ("patils",26, "S-19");
	 s3.enrollCourse("DEVOPS");
	 s3.printStudentInfo();
	 
	}

}
