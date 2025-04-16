import java.util.*;

/**
 * Set_CountUniqueElement
 */
public class Set_CountUniqueElement {

    public static void main(String[] args) {
        int num[] = { 4, 3, 2, 5, 6, 7, 4, 3, 9, 0, 1, 2, 3, 4 };
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < num.length; i++) {

            hs.add(num[i]);
        }
        System.err.println(hs.size());
    }

}