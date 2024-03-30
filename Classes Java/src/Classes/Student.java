//Author: John Photis
//Purpose: This Java program follows the UML of the Student class.


package Classes;

import java.util.*;

public class Student {
	private String name;
	private String id;
	private String major;
	private Course[] courses;
	private int courseNo = 0;
	private static int student_number = 0;
	private static final int CAPACITY = 50;

	public Student(String name, String id, String major) {
		this.name = name;
		this.id = id;
		this.major = major;
		courses = new Course[CAPACITY];
		courseNo = 0;
		student_number++;
	}

	public String getName() {
		return name;
	}

	public String getID() {
		return id;
	}

	public static int getStudentNo() {
		return student_number;
	}

	public String getCourses() {
		String allcourses = "";
		for (int i = 0; i < courseNo; i++) {
			allcourses += courses[i].getID() + " " + courses[i].getName() + " " + courses[i].getScore(this.getID())
					+ "\n";
		}
		return allcourses;
	}

	public double getGPA() {
		double total = 0;
		for (int i = 0; i < courseNo; i++) {
			total += courses[i].getScore(this.getID());
		}
		return total / courseNo;
	}

	public void addCourse(Course c) {
		if (courseNo >= this.CAPACITY) {
			System.out.println("No more course can be added.");
		} else {
			courses[courseNo++] = c;
		}
	}

	public void dropCourse(Course c) {
		int i = 0;
		for (i = 0; i < courseNo; i++) {
			if (courses[i].getID().equals(c.getID())) {
				break;
			}
		}
		if (i != courseNo) {
			for (int j = i + 1; j < courseNo; j++) {
				courses[j - 1] = courses[j];
			}
			courseNo--;
		}
	}

	public int getCourseNo() {
		return courseNo;
	}

	public boolean isTaking(Course c) {
		for (int i = 0; i < courseNo; i++) {
			if (courses[i].getID().equals(c.getID())) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return this.name + " " + this.id + " " + this.major;
	}
}
