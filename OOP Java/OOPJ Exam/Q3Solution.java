import java.util.Scanner;

class BMW {
    void showDetails() {
        System.out.println("BMW Vehicle");
    }

    void maxSpeed() {
        try {
            int speed = 300 / 0; // Intentional ArithmeticException
            System.out.println("Max speed is " + speed + " km/h");
        } catch (ArithmeticException e) {
            System.out.println("Exception Caught: " + e);
        }
    }
}

class BMWSeries3 extends BMW {
    @Override
    void showDetails() {
        System.out.println("BMW Series 3");
    }

    @Override
    void maxSpeed() {
        try {
            System.out.println("Max speed is 240 km/h");
            int speed = 240 / 0; // Intentional ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Exception Caught: " + e);
        }
    }
}

class BMWSeries5 extends BMW {
    @Override
    void showDetails() {
        System.out.println("BMW Series 5");
    }

    @Override
    void maxSpeed() {
        try {
            System.out.println("Max speed is 260 km/h");
            int speed = 260 / 0; // Intentional ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Exception Caught: " + e);
        }
    }
}

class BMWSeries7 extends BMW {
    @Override
    void showDetails() {
        System.out.println("BMW Series 7");
    }

    @Override
    void maxSpeed() {
        try {
            System.out.println("Max speed is 300 km/h");
            int speed = 300 / 0; // Intentional ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Exception Caught: " + e);
        }
    }
}

public class Q3Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline

        BMW[] vehicles = new BMW[n];

        try {
            for (int i = 0; i < n; i++) { // Fixed loop range
                String model = sc.nextLine();

                if (model.equals("BMWSeries3")) {
                    vehicles[i] = new BMWSeries3();
                } else if (model.equals("BMWSeries5")) {
                    vehicles[i] = new BMWSeries5();
                } else if (model.equals("BMWSeries7")) {
                    vehicles[i] = new BMWSeries7();
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception Caught: " + e);
        }

        for (int i = 0; i < n; i++) {
            try {
                if (vehicles[i] == null)
                    throw new NullPointerException();
                vehicles[i].showDetails();
                vehicles[i].maxSpeed();
            } catch (NullPointerException e) {
                System.out.println("Exception Caught: " + e);
            }
        }

        sc.close();
    }
}
