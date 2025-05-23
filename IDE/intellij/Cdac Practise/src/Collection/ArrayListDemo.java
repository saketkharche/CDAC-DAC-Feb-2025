package Collection;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();//not type safe
        ArrayList<String>a1l = new ArrayList<String>();//type safe
        a1l.add("Saket");
        a1l.add("Saket1");
        a1l.add("Saket2");
        a1l.add("Saket2");
        a1l.add("Saket3");
        a1l.add("Saket4");
        System.out.println(a1l);
        a1l.remove("Saket3");
        String b= a1l.get(4);
        System.out.println(b);
        System.out.println(a1l);


    }

}
