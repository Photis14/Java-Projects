//Author: John Photis
//Purpose: This Java program follows the UML of the Course class.


package Classes;

import java.util.*;


public class Course {
	private String name;
	private String id;
	private String department;
	private int max_cap;
	private int min_cap;
	private Student[] students;
	private double[] scores;
	private int studentNo;
	private static int course_number = 0;


	public Course(String name, String id, String dept) {
		this.name = name;
		this.id = id;
		this.department = dept;
		this.max_cap = 60;
		this.min_cap = 1;
		students = new Student[max_cap];
		scores = new double[max_cap];
		studentNo = 0;
		course_number++;
	}


	public String getName() {
		return name;
	}

	public String getID() {
		return id;
	}

	public String getDept() {
		return department;
	}

	public int getMinCap() {
		return min_cap;
	}

	public int getMaxCap() {
		return max_cap;
	}

	public static int getCourseNo() {
		return course_number;
	}

	public void addStudent(Student s) {
		if (studentNo >= max_cap) {
			System.out.println("Full. Cannot add more.");
		} else {
			students[studentNo] = s;
			scores[studentNo] = 0;
			studentNo++;
		}
	}

	public void dropStudent(Student s){
	if (studentNo<=min_cap){
	System.out.println("Too few students. The course might be cancelled!");
	} else {
	int i=0;
	for (i=0; i<studentNo; i++){
	if (students[i].getID().equals(s.getID())){
	break;
	}
	}
	if (i!=studentNo){
	for (int j=i+1; j<studentNo; j++){
	students[j-1] = students[j];
	}
	for (int j=i+1; j<studentNo; j++){
	scores[j-1] = scores[j];
	}
	studentNo--;
	}
	}
	}

	public double getAverage() {
		double total = 0;
		for (int i = 0; i < studentNo; i++) {
			total += scores[i];
		}
		return total / studentNo;
	}

	public Student[] getStudents() {
		Student[] studentCopy = Arrays.copyOf(this.students, this.studentNo);
		return studentCopy;
	}

	public void setScore(Student s, double score) {
		for (int i = 0; i < studentNo; i++) {
			if (students[i].getID().equals(s.getID())) {
				scores[i] = score;
			}
		}
	}

	public double getScore(String id) {
		for (int i = 0; i < studentNo; i++) {
			if (students[i].getID().equals(id)) {
				return scores[i];
			}
		}
		return 0;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public String toString() {
		return this.name + " " + this.id + " " + this.department;
	}

		public static void main(String[] args) {
			// Create an array of 5 courses
			Course[] courses = new Course[5];
			String name = "Java programming";
			String id = "CS132";
			String dept = "Computer Science";
			courses[0] = new Course(name, id, dept);
			
			name = "Python programming";
			id = "CS131";
			courses[1] = new Course(name, id, dept);
			
			name = "Data Structure and Algorithm";
			id = "CS265";
			courses[2] = new Course(name, id, dept);
			
			name = "C++ and Qt";
			id = "CS331";
			courses[3] = new Course(name, id, dept);
			
			name = "Data Science";
			id = "CS511";
			courses[4] = new Course(name, id, dept);
			
			// Create an array of 3 students
			Student[] students = new Student[3];
			name = "Isla Chan";
			id = "123456";
			String major = "Computer Science";
			students[0] = new Student(name, id, major);
			
			name = "Emmett Smith";
			id = "654321";
			students[1] = new Student(name, id, major);
			
			name = "Ayaana Anderson";
			id = "543216";
			major = "Math";
			students[2] = new Student(name, id, major);
			
			Random rnd = new Random();
			//Each student will randomly add 4 courses.
			for (int i=0; i<3; i++){
				// generate four distinct courses.
				ArrayList<Integer> intList = new ArrayList<Integer>();
				while (intList.size()<4){
					int courseIndex = rnd.nextInt(5);
					if (!intList.contains(courseIndex)){
						intList.add(courseIndex);
					}
				}
				for (Integer index: intList){
					courses[index].addStudent(students[i]);
					students[i].addCourse(courses[index]);
				}
			}
			
			// Each course sets the score of each of its enrolled students.
			for (int i=0; i<courses.length; i++){
				if (courses[i].getStudentNo()!=0){
					Student[] allStudents = courses[i].getStudents();		
					for (int j=0; j<courses[i].getStudentNo(); j++){
						// a random score within [40, 100]
						int score = rnd.nextInt(100-40+1)+40;
						courses[i].setScore(allStudents[j], score);
					}
				}
			}
			
			// Each student randomly drops one course.
			for (int i=0; i<students.length; i++){
				int courseIndex;
				while (true){
					courseIndex = rnd.nextInt(5);
					if (students[i].isTaking(courses[courseIndex])){
						break;
					}
				}
				students[i].dropCourse(courses[courseIndex]);
				courses[courseIndex].dropStudent(students[i]);
			}
			
			// Each course reports its average score.
			for (int i=0; i<courses.length; i++){
				System.out.printf("%s %s %.2f\n", courses[i].getName(), courses[i].getID(), courses[i].getAverage());
			}
			System.out.println();
			
			// Each student checks the score of each of his/her enrolled courses, and his/her overall GPA.
			for (int i=0; i<students.length; i++){
				System.out.println(students[i].getName() + " " + students[i].getID() + ": ");
				System.out.print(students[i].getCourses());
				System.out.printf("The GPA is: %.2f\n", students[i].getGPA());
				System.out.println();
			}
		}
	}