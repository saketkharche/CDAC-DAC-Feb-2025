import java.util.InputMismatchException;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNo;
    private double[] marks;
    private double average;
    private char grade;

    // Constructor with validation
    public Student(String name, int rollNo, double[] marks) {
        for (double mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new IllegalArgumentException("Marks should be between 0 and 100.");
            }
        }
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    // Method to calculate average marks
    public void calculateAverage() {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        average = sum / marks.length;
    }

    // Method to assign grade based on average marks
    public void calculateGrade() {
        if (average >= 90) grade = 'A';
        else if (average >= 80) grade = 'B';
        else if (average >= 70) grade = 'C';
        else if (average >= 60) grade = 'D';
        else grade = 'F';
    }

    // Method to display student details
    public void displayStudentInfo() {
        System.out.printf("\nStudent Name: %s\nRoll No: %d\n", name, rollNo);
        System.out.print("Marks: ");
        for (double mark : marks) {
            System.out.printf("%.2f ", mark);
        }
        System.out.printf("\nAverage: %.2f\nGrade: %c\n", average, grade);
    }
}

public class Q2StudentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Taking input from the user
            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter roll number: ");
            int rollNo = sc.nextInt();

            double[] marks = new double[5];
            System.out.println("Enter marks for 5 subjects:");
            for (int i = 0; i < 5; i++) {
                marks[i] = sc.nextDouble();
            }

            // Creating object and performing operations
            Student student = new Student(name, rollNo, marks);
            student.calculateAverage();
            student.calculateGrade();
            student.displayStudentInfo();

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid numeric values.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
