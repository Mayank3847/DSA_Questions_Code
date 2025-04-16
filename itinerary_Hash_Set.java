import java.util.*;

public class itinerary_Hash_Set {
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);

        }
        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;// starting key

            }
        }
        return null;

    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("CHENNAI", "BENGALURU");
        tickets.put("MUMBAI", "DELHI");
        tickets.put("GOA", "CHENNAI");
        tickets.put("DELHI", "GOA");
        String start = getStart(tickets);
        System.out.print(start);
        
        for (String key : tickets.keySet()) {
            System.out.print("--->" + tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();
    }
}
