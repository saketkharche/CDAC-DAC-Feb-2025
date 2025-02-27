import java.util.Scanner;

class Q4DiscountCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter total purchase amount: ");
        double totalPurchase = scanner.nextDouble();

        System.out.print("Do you have a membership card? (yes/no): ");
        String hasMembership = scanner.next();

        double discount;
        if (totalPurchase >= 1000) {
            discount = 0.20;
        } else if (totalPurchase >= 500) {
            discount = 0.10;
        } else {
            discount = 0.05;
        }

        if (hasMembership.equalsIgnoreCase("yes")) {
            discount += 0.05;
        }

        double discountedAmount = totalPurchase - (totalPurchase * discount);
        System.out.println("Discounted amount: Rs." + discountedAmount);

        scanner.close();
    }
}
