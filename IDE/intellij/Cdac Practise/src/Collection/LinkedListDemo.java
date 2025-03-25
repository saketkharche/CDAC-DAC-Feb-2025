package Collection;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        //LinkedListDemo l11 = new LinkedListDemo();//not type safe
        LinkedList<Integer> l1 = new LinkedList<Integer>();//type safe
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        System.out.println(l1);

        l1.addFirst(5);
        l1.addLast(1);
        System.out.println(l1);


    }
}
