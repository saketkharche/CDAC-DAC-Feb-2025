package Day01;

//class Recursion1 {
//    static void show(){
//        System.out.println("Hi Girls!!!");
//        show(); // No base condition → Infinite recursion
//    }
//    public static void main(String[] args) {
//        show();
//    }
//}

public class Recursion1 {
    static int i=0;
    static void show() {
        i++;
        if (i <= 5) {
            System.out.println("Recursion");
            show();
        }
    }
    public static void main(String[] args) {
        show();

    }
}
