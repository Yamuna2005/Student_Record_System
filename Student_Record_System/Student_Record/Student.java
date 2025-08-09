package Student_Record;
import  java.util.ArrayList;
import java.util.Scanner;



public class Student {
	private int id;
	private String name;
	private double marks;
	

	public Student(int id,String name,double marks) {
		this.id = id;
		this.name = name;
		this.marks=marks;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getMarks() {
		return marks;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setMarks(double marks) {
		this.marks=marks;
	}
	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
	}

}
class StudentManagementSystem{
	private static ArrayList<Student> students = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	private static int idCounter = 1;
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("Student Management System");
			System.out.println("1. Add Student");
			System.out.println("2. View Student");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");
			System.out.print("Choose an option: ");
			int option = scanner.nextInt();
			scanner.nextLine();
			
			switch (option) {
			  case 1:
				addStudent();
				break;
			  case 2:
				  viewStudent();
				  break;
			  case 3:
				  updateStudent();
				  break;
			  case 4:
				  deleteStudent();
				  break;
			  case 5:
				  System.out.println("Exiting...");
				  return;
			  default:
				  System.out.println("Invalid option. please choose a valid option.");
				  
				  }
			}
	}
	private static void addStudent() {
		System.out.println("Enter student name: ");
		String name=scanner.nextLine();
		System.out.println("Enter student Marks: ");
		double marks = scanner.nextDouble();
		scanner.nextLine();
		Student student = new Student(idCounter++, name, marks);
		students.add(student);
		System.out.println("Student addes successfully!");
	}
	private static void viewStudent() {
		if (students.isEmpty()) {
			System.out.println("No students found");
			return;
		}
		for (Student student : students) {
			System.out.println(student);
		}
	}
	private static void updateStudent() {
		if (students.isEmpty()) {
			System.out.println("No students found");
			return;
		}
		System.out.println("Enter student ID to update:");
		int id = scanner.nextInt();
		scanner.nextLine();
		for(Student student : students) {
			if (student.getId() == id) {
				System.out.print("Enter new name: ");
				String name = scanner.nextLine();
				System.out.print("Enter new marks: ");
				double marks = scanner.nextDouble();
				scanner.nextLine();
				student.setName(name);
				student.setMarks(marks);
				System.out.println("Student updated successfully!");
				return;
			}
		}
		System.out.println("Student not found");
	}
	private static void deleteStudent() {
		if (students.isEmpty()) {
			System.out.println("No students found");
			return;
		}
		System.out.print("Enter student ID to delete: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		students.removeIf(student -> student.getId() == id);
		System.out.println("Student deleted successfully!");
	}
}
