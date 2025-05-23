package Collection;

import java.util.ArrayList;

public class ArrayListDemo1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();//not type safe
        ArrayList<String>a1l = new ArrayList<String>();//type safe
        a1l.add("Saket");
        a1l.add("utsav");
        a1l.add("ram");
        a1l.add("harsh");
        a1l.add("darshan");
        a1l.add("rohan");
        a1l.add("tejas");
        System.out.println(a1l);
        a1l.remove("lakshit");
        String b= a1l.get(4);
        System.out.println(b);
        System.out.println(a1l);
        //Traversing : method 1
        for (int i = 0; i < a1l.size(); i++) {
            System.out.println(a1l.get(i));
        }
        System.out.println(" ");
        //method 2
        for (String s : a1l) {
            System.out.println(s);
        }

        System.out.println(" ");

        //method 3
        a1l.iterator();
        System.out.println(" ");



    }

}
