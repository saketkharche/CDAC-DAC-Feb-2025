class Box {
    double height, width, breadth;

    Box(double height, double width, double breadth) {
        this.height = height;
        this.width = width;
        this.breadth = breadth;
    }

    double getVolume() {
        return height * width * breadth;
    }

    double getArea() {
        return 2 * (width * breadth + breadth * height + height * width);
    }
}

public class Q3BoxDemo {
    public static void main(String[] args) {
        Box box1 = new Box(5, 4, 3);
        Box box2 = new Box(7, 6, 5);

        System.out.println("Box 1 - Volume: " + box1.getVolume() + ", Surface Area: " + box1.getArea());
        System.out.println("Box 2 - Volume: " + box2.getVolume() + ", Surface Area: " + box2.getArea());
    }
}
