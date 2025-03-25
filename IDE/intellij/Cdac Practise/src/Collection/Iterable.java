package Collection;

import java.util.ArrayList;
import java.util.List;

public class Iterable {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("Iterable.main");
    }
}
