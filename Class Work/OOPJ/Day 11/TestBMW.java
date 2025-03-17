// Parent class BMW
class BMW {
    void showDetails() {
        System.out.println("This is a BMW vehicle.");
    }

    void maxSpeed() {
        System.out.println("Speed varies by model.");
    }
}

// Subclass BMWSeries3
class BMWSeries3 extends BMW {
    @Override
    void showDetails() {
        System.out.println("This is a BMW Series 3.");
    }

    @Override
    void maxSpeed() {
        System.out.println("Max Speed: 240 km/h");
    }
}

// Subclass BMWSeries5
class BMWSeries5 extends BMW {
    @Override
    void showDetails() {
        System.out.println("This is a BMW Series 5.");
    }

    @Override
    void maxSpeed() {
        System.out.println("Max Speed: 260 km/h");
    }
}

// Subclass BMWSeries7
class BMWSeries7 extends BMW {
    @Override
    void showDetails() {
        System.out.println("This is a BMW Series 7.");
    }

    @Override
    void maxSpeed() {
        System.out.println("Max Speed: 300 km/h");
    }
}

// Test program
public class TestBMW {
    public static void main(String[] args) {
        // Polymorphism with dynamic method dispatch
        BMW[] cars = {
                new BMWSeries3(),
                new BMWSeries5(),
                new BMWSeries7()
        };

        for (BMW car : cars) {
            car.showDetails();
            car.maxSpeed();
            System.out.println(); // For better output formatting
        }
    }
}
