import java.util.*;

public class pairSum_ArrayList {
    public static boolean pairSum(ArrayList<Integer> list, int target) {

        // *****************************BRUTE FORCE APPROACH TIME COMPLEXITY
        // O(NSQUARE)*********** */
        // for (int i = 0; i < list.size(); i++) {
        // for (int j = i + 1; j < list.size(); j++) {
        // if (list.get(i) + list.get(j) == target) {
        // return true;
        // }
        // }
        // }

        // *********2 POINTER APPROACH N JUST LINEAR TIME COMPLEXITY O(N)******
        int left_pointer = 0;
        int right_pointer = list.size() - 1;
        while (left_pointer != right_pointer) {
            // case1
            if (list.get(left_pointer) + list.get(right_pointer) == target) {
                return true;
            }
            // case 2

            if (list.get(left_pointer) + list.get(right_pointer) < target) {
                left_pointer++;
            } else {
                right_pointer--;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int target = 5;
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.print(pairSum(list, target));

    }
}
