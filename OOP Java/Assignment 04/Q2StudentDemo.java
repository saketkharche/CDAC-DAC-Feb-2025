import java.util.Scanner;

class Student {
    String name;
    int marks1, marks2, marks3;

    void assignValues(String name, int m1, int m2, int m3) {
        this.name = name;
        this.marks1 = m1;
        this.marks2 = m2;
        this.marks3 = m3;
    }

    int totalMarks() {
        return marks1 + marks2 + marks3;
    }

    double averageMarks() {
        return totalMarks() / 3.0;
    }

    void display() {
        System.out.println("Student: " + name);
        System.out.println("Total Marks: " + totalMarks());
        System.out.println("Average Marks: " + averageMarks());
    }
}

public class Q2StudentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter Marks in 3 Subjects: ");
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        
        Student student = new Student();
        student.assignValues(name, m1, m2, m3);
        student.display();
        
        sc.close();
    }
}
