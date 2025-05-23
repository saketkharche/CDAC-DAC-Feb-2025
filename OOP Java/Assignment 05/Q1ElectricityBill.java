import java.util.InputMismatchException;
import java.util.Scanner;

public class Q1ElectricityBill {
    String customerName;
    double unitsConsumed;
    double billAmount;

    public Q1ElectricityBill(String customerName, double unitsConsumed) {
        if (unitsConsumed < 0) {
            throw new IllegalArgumentException("Units consumed cannot be negative.");
        }
        this.customerName = customerName;
        this.unitsConsumed = unitsConsumed;
    }

    public void calculateBillAmount() {
        double units = this.unitsConsumed;
        if (units <= 100) {
            billAmount = units * 5;
        } else if (units <= 300) {
            billAmount = 100 * 5 + (units - 100) * 7;
        } else {
            billAmount = 100 * 5 + 200 * 7 + (units - 300) * 10;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter units consumed: ");

        try {
            double units = scanner.nextDouble();
            Q1ElectricityBill bill = new Q1ElectricityBill(name, units);
            bill.calculateBillAmount();

            System.out.println("\nCustomer Name: " + bill.customerName);
            System.out.println("Units Consumed: " + bill.unitsConsumed);
            System.out.println("Total Bill Amount: Rs." + bill.billAmount);

        } catch (InputMismatchException e) {
            System.out.println("Error: Units consumed must be a numeric value.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}