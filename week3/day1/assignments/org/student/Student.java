package week3.day1.assignments.org.student;

import week3.day1.assignments.org.department.Department;

public class Student extends Department {

	public static void studentName() {
		System.out.println("Student Name:");
	}

	public static void studentDept() {
		System.out.println("Department: Computer Science");
	}

	public static void studentId() {
		System.out.println("Enter Enrollment Id");
	}

	public static void main(String[] args) {

		Department stdnt = new Department();

		stdnt.deptName();
		stdnt.collegeName();
		stdnt.collegeCode();
		stdnt.CollegeRank();

	}

}
