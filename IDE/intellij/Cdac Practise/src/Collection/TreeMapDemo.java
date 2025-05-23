package Collection;

import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer,String> tm = new TreeMap<Integer, String>();
        tm.put(51, "Ram");
        tm.put(25, "Sam");
        tm.put(53, "Cam");
        tm.put(36, "Wam");
        System.out.println(tm);
    }
}
