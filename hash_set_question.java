import java.util.*;

public class hash_set_question {
    public static void main(String[] args) {
        int num[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            System.out.println(set.add(num[i]));

        }
        System.out.println("THE DISTINCT UNIQUE SIZE :" + set.size());
    }

}
