import java.util.HashMap;
import java.util.*;

public class hash_map {
    public static void main(String[] args) {
        // creating hash map
        HashMap<String, Integer> hm = new HashMap<>();
        // insert the key value pair in map
        hm.put("INDIA", 100);
        hm.put("CHINA", 150);
        hm.put("US", 200);
        hm.put("EUROPE", 170);
        hm.put("NEPAL", 5);
        hm.put("RUSSIA", 190);
        System.out.println(hm);
        
        // //get the key and value from the map
        // int population = hm.get("INDIA");
        // System.out.println(hm.get("INDONESIA"));

        // System.out.println(population);
        // // containsKey ------- return true or false weather the key is present in the
        // System.out.println(hm.containsKey("INDIA"));
        // System.out.println(hm.containsKey("INDONESIA"));
        // // remove
        // System.out.println(hm.remove("US"));
        // System.out.println(hm);
        // // size
        // System.out.println(hm.size());
        // // isEmpty return true of false for which sets d
        // System.out.println(hm.isEmpty());
        // // clear it make clear sets
        // hm.clear();
        // System.out.println(hm.isEmpty());

        // iterate
        Set<String> keys = hm.keySet();
        System.out.println(keys);
        for (String k : keys) {
            System.out.println("keys = " + k + ", values = " + hm.get(k));

        }

    }

}
