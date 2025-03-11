import java.util.Scanner;

public class Q13MarksAggregation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] marks = new int[20][3]; // 20 students, 3 subjects
        int above75 = 0;
        int below40 = 0;

        // Input marks for each student
        for (int i = 0; i < 20; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + " (Physics, Chemistry, Maths):");
            for (int j = 0; j < 3; j++) {
                marks[i][j] = scanner.nextInt();
            }
        }

        // Calculate percentage and count
        for (int i = 0; i < 20; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            float percentage = (total / 300.0f) * 100;

            if (percentage >= 75) {
                above75++;
            } else if (percentage <= 40) {
                below40++;
            }
        }

        // Display results
        System.out.println("Number of students securing 75% and above: " + above75);
        System.out.println("Number of students securing 40% and below: " + below40);

        scanner.close();
    }
}
