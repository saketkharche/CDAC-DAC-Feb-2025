package Day15;

import java.lang.reflect.Constructor;

class Demo{
    private String message= "Learning Reflection";

    public Demo() {

        System.out.println("Demo::Constructor");

    }

    public void display() {
        System.out.println("display::Method");

    }

}
public class ReflectionDemo {
    public static void main(String[] args) {
        Class<?>d1 = Demo.class;
        Class<?>d2 = ReflectionDemo.class;
        Constructor<?>[]c1=d1.getConstructors();
        System.out.println("Constructors:............. ");
        for (Constructor<?> c : c1) {
            System.out.println(c);
        }
        System.out.println(d1.getName());
        System.out.println(d2);

    }
}
