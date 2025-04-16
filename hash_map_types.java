import java.util.*;

public class hash_map_types {

    public static void main(String[] args) {
        // linked hash map
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("INDIA", 150);
        lhm.put("CHINA", 200);
        lhm.put("INDONNESIA", 50);
        lhm.put("US", 100);
        // hash map
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("INDIA", 150);
        hm.put("CHINA", 200);
        hm.put("INDONNESIA", 50);
        hm.put("US", 100);
        // tree map
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("INDIA", 150);
        tm.put("CHINA", 200);
        tm.put("INDONNESIA", 50);
        tm.put("US", 100);
        System.out.println(hm);
        System.out.println(lhm);
        System.out.println(tm);

    }
}
