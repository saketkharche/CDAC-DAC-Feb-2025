// Abstract class Vehicle
abstract class Vehicle {
    String brand;
    int speed;

    // Constructor
    Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    // Abstract method (must be implemented by subclasses)
    abstract void start();

    // Concrete method
    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/hr");
    }
}

// Subclass Bike extending Vehicle
class Bike extends Vehicle {

    // Constructor
    Bike(String brand, int speed) {
        super(brand, speed);
    }

    // Implementing abstract method
    @Override
    void start() {
        System.out.println(brand + " bike is starting at a speed of " + speed + " km/hr.");
    }
}

// Driver class
public class VehicleTest {
    public static void main(String[] args) {
        // Create Bike object
        Bike myBike = new Bike("Yamaha", 120);

        // Call methods
        myBike.displayInfo(); // Concrete method from Vehicle
        myBike.start(); // Abstract method implemented in Bike
    }
}
