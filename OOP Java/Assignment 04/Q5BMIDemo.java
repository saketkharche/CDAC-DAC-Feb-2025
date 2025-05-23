import java.util.Scanner;

class BMICalculator {
    private double height; // Height in meters
    private double weight; // Weight in kilograms

    // Parameterized constructor
    BMICalculator(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    // Getter and Setter for height
    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    // Getter and Setter for weight
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    // Method to calculate BMI
    public double calculateBMI() {
        return weight / (height * height);
    }
}

public class Q5BMIDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter height in meters: ");
        double height = sc.nextDouble();

        System.out.print("Enter weight in kilograms: ");
        double weight = sc.nextDouble();

        // Creating an object of BMICalculator
        BMICalculator bmiCalculator = new BMICalculator(height, weight);

        // Calculating and displaying BMI
        double bmi = bmiCalculator.calculateBMI();
        System.out.printf("Your BMI is: %.2f\n", bmi);

        // BMI Category Interpretation
        if (bmi < 18.5)
            System.out.println("You are underweight.");
        else if (bmi >= 18.5 && bmi < 24.9)
            System.out.println("You have a normal weight.");
        else if (bmi >= 25 && bmi < 29.9)
            System.out.println("You are overweight.");
        else
            System.out.println("You are obese.");

        sc.close();
    }
}
