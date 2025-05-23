package Collection;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set <String>s1 = new HashSet<>();
        s1.add("apple");
        s1.add("banana");
        s1.add("cherry");
        s1.add("pineapple");
        s1.add("watermelon");
        s1.add("apple");
        s1.add("banana");

        System.out.println(s1);
    }
}
