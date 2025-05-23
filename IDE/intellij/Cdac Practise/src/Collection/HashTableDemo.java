package Collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTableDemo {
    public static void main(String[] args) {
        Map<Integer,String> m=new Hashtable<Integer, String>();
        m.put(1, "Sam");
        m.put(2, "Cam");
        m.put(3, "Wam");
        m.put(4, "");
        m.put(5, "");
        m.put(6, "");
        System.out.println(m);
    }
}
