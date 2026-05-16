package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	private static  List<Student> StudentList;
	
	public static void main(String[] args) {


	 System.out.println("*****Student  Management System****");
	 System.out.println("****WELCOME****");
	 
	 StudentList= new ArrayList<Student>();
	 
	 Scanner scanner = new Scanner(System.in);
	 System.out.print(" Enter the Student Name    ");
	String name =scanner.next(); //if you want to read the input in string format you will use next
	
	System.out.println("you have enter the Name : "+ name);
	
	
	//To read integer values from the console/terminal
	// the readInt();
	
	System.out.print("Enter student Age :   ");
	int age= scanner.nextInt();
	System.out.print("The Student age is: " + age);
	 
	 
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
