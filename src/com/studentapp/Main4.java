package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Main4 {

	private static  List<Student> StudentList;
	
	public static void main(String[] args) {


	 System.out.println("*****Student  Management System****");
	 
	 StudentList= new ArrayList<Student>();
	 Scanner scanner = new Scanner(System.in);
	 
	 while(true) {
		 System.out.println("****WELCOME****");
	    System.out.println("Select an option");
		System.out.println("1. Regsiter a student");
		System.out.println("2. Find student with student id");
		System.out.println("3. List All Student information");
		System.out.println("4. List studnet iformation in sorted order");
		System.out.println("5.  EXIT");
		
		int option = scanner.nextInt();
		switch(option) {
		case 1:  
			enrollStudent(scanner);
			break;
			
		case 2:
			findStudentById(scanner);
		 break;
		 
		case 3:
			printAllStudentData();
			break;
			
		case 4:
			
			sortByName();
			break;
			
		case 5:
			exit();
			break;
			
		default: System.out.println("Invalid option Selected, Please Enter the option between 1 to 5");
		
		}
	 }
	 
	}
	 
	 private static void exit() {
		// TODO Auto-generated method stub
		System.out.println("you have exit from the application");
		 System.out.println(0);
	}

	 private static void printAllStudentData() {
	   if(StudentList.size()>0) {
		   
	   
		 System.out.println("----------Print all Student Data-------");
		 for(Student student: StudentList) {
			 
			 student.printStudentInfo();
		 }
		 
	
		System.out.println("**********************************");
}
	   else {
		   
		   System.out.println("student list is empty !! No student Record found");
	   }
	   
	}

	 private static void findStudentById(Scanner scanner2) {
		 Student studentfound= null;
		 System.out.println("Enter the Student id");
		 String studentId = scanner2.next();
			
			try {
				
			
			studentfound = StudentList.stream().filter(student ->student.getStudentId().equalsIgnoreCase(studentId))
			 .findFirst()
			 .orElseThrow(()-> new RuntimeException(" NO Data fond !!!"));
			
			}catch (RuntimeException e) {
				
				System.err.print("Student with id "+studentId+ " not found !!");
			}
			studentfound.printStudentInfo();
		
	}

	 private static void enrollStudent(Scanner scanner2) {
		// TODO Auto-generated method stub
		
		 System.out.println(" Enter the student Name");
		 String studentName=scanner2.next();
		 
		 
		 System.out.println(" Enter the student Age");
		 int studentage=scanner2.nextInt();
		 
		 System.out.println(" Enter the student id");
		 String studentId=scanner2.next();
		 
		
		 
		 Student newStudent = new Student(studentName, studentage,studentId);
		 StudentList.add(newStudent);
		 while(true) {
			 
			 System.out.println("Enter the course to be enrolled !!...Type done to exit");
			 String courseName= scanner2.next();
			 if(courseName.equalsIgnoreCase("done")) {
				 break;
			 }
			 newStudent.enrollCourse(courseName);
			 
		 }
		
		 newStudent.printStudentInfo();
 		 		 
	}

	 private static void sortByName() {
		
		 Comparator<Student> studentNameCompator= new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		 };
			 
		 
		Collections.sort(StudentList,studentNameCompator);
		System.out.println(StudentList);
	}

	 public static Student findStudentById(String studentId) {
		 
		Student result= null;
		
		try {
			
		
		result = StudentList.stream().filter(x ->x.getStudentId().equalsIgnoreCase(studentId))
		 .findFirst()
		 .orElseThrow(()-> new RuntimeException(" NO Data fond !!!"));
		
		}catch (RuntimeException e) {
			
			System.err.print("Student with id "+studentId+ " not found !!");
		}
		
		return result;
	 
	}

}
