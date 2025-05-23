package Collection;

import java.util.HashMap;
import java.util.Map;

//hashmap
public class MapDemo {

    public static void main(String[] args) {
        Map<Integer, String> m = new HashMap<Integer, String>();

        m.put(1, "saket");
        m.put(2, "dhanashri");
        m.put(3, "kharche");
        m.put(4, "kharche");
        m.put(6, "Ram");//value will get update
        m.put(5, " ");
        m.put(8, "");

        System.out.println(m.get("saket"));
        System.out.println(m.get(3));
        System.out.println(m);
    }
}
