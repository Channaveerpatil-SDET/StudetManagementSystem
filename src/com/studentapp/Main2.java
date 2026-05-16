package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {

	private static  List<Student> StudentList;
	
	public static void main(String[] args) {


	 System.out.println("*****Student  Management System****");
	 
	 StudentList= new ArrayList<Student>();
	 
	 
	 Student s1;
	 s1= new Student("ROCKS patils", 22 , "S-16");
	 s1.enrollCourse("Java");
	 
	 Student s2 = new Student ("Appu",24, "S-18");
	 s2.enrollCourse("Python");
	 
	 Student s3 = new Student ("patils",26, "S-19");
	 s3.enrollCourse("DEVOPS");
	 
	 
	 Student s4 = new Student ("Ajinkyaatils",19, "S-007");
	 s4.enrollCourse("DEVOPS");
	 
	 StudentList.add(s1);
	 StudentList.add(s2);
	 StudentList.add(s3);
	 StudentList.add(s4);
	 Student result= findStudentById("S-19");
	 System.out.println("Result :"+ result);
	 
	 sortByName();
	 
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
