public class Q1 {
    // Declare instance variables with default values
    byte byteVar;
    short shortVar;
    int intVar;
    long longVar;
    float floatVar;
    double doubleVar;
    char charVar;
    boolean booleanVar;

    public void printDefaultValues() {
        // Print default values
        System.out.println("Default byte value: " + byteVar);
        System.out.println("Default short value: " + shortVar);
        System.out.println("Default int value: " + intVar);
        System.out.println("Default long value: " + longVar);
        System.out.println("Default float value: " + floatVar);
        System.out.println("Default double value: " + doubleVar);
        System.out.println("Default char value: " + (int) charVar); // Casting to int to show the Unicode value
        System.out.println("Default boolean value: " + booleanVar);
    }

    public static void main(String[] args) {
        // Create an instance of the class to access instance variables
        PrimitiveDataTypes instance = new PrimitiveDataTypes();

        // Print default values
        instance.printDefaultValues();

        // Declare and initialize local variables with assigned values
        byte byteVar = 10;
        short shortVar = 20;
        int intVar = 30;
        long longVar = 40L;
        float floatVar = 50.5f;
        double doubleVar = 60.5;
        char charVar = 'A';
        boolean booleanVar = true;

        // Print assigned values
        System.out.println("Assigned byte value: " + byteVar);
        System.out.println("Assigned short value: " + shortVar);
        System.out.println("Assigned int value: " + intVar);
        System.out.println("Assigned long value: " + longVar);
        System.out.println("Assigned float value: " + floatVar);
        System.out.println("Assigned double value: " + doubleVar);
        System.out.println("Assigned char value: " + charVar);
        System.out.println("Assigned boolean value: " + booleanVar);
    }
}
