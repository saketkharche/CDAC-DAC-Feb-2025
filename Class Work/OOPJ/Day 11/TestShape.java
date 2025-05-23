// Abstract class Shape
abstract class Shape {
    protected String shapeName;

    // Constructor
    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    // Getter for shapeName
    public String getShapeName() {
        return shapeName;
    }

    // Abstract method to calculate area
    abstract double calculateArea();
}

// Concrete class Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Concrete class Rectangle
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}

// Test program
public class TestShape {
    public static void main(String[] args) {
        // Polymorphism: Using Shape reference
        Shape circle = new Circle(5.0);
        System.out.println("Shape: " + circle.getShapeName());
        System.out.println("Area: " + circle.calculateArea());

        Shape rectangle = new Rectangle(4.0, 6.0);
        System.out.println("\nShape: " + rectangle.getShapeName());
        System.out.println("Area: " + rectangle.calculateArea());
    }
}
