import java.util.*;

public class hash_map_iteration {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        // insert the key value pair in map
        hm.put("INDIA", 100);
        hm.put("CHINA", 150);
        hm.put("US", 200);
        hm.put("EUROPE", 170);
        hm.put("NEPAL", 5);
        hm.put("RUSSIA", 190);
        System.out.println(hm);
        Set<String> keys = hm.keySet();
        System.out.println(keys);
        for (String xyz : keys) {
            System.out.println("KEYS = " + xyz + " , values = " + hm.get(xyz));

        }

    }

}
