class Room {
    double height, width, breadth;

    Room(double height, double width, double breadth) {
        this.height = height;
        this.width = width;
        this.breadth = breadth;
    }

    double volume() {
        return height * width * breadth;
    }
}

public class Q1RoomDemo {
    public static void main(String[] args) {
        Room room1 = new Room(10, 12, 15);
        Room room2 = new Room(8, 10, 12);

        System.out.println("Volume of Room 1: " + room1.volume());
        System.out.println("Volume of Room 2: " + room2.volume());
    }
}
