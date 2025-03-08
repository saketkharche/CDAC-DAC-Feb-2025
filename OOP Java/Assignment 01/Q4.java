public class Q4 {
    public static void main(String[] args) {
        Integer intObj = 50;
        Double doubleObj = intObj.doubleValue(); // Convert Integer to Double
        System.out.println("Integer to Double: " + doubleObj);

        Double doubleVal = 75.5;
        Integer intVal = doubleVal.intValue(); // Convert Double to Integer
        System.out.println("Double to Integer: " + intVal);
    }
}
