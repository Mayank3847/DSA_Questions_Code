import java.util.*;

public class pairSum1_ArrayList {
    public static boolean pairSum(ArrayList<Integer> list, int target) {
        int breaking_pointer = -1;
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {

                breaking_pointer = i;
                break;

            }
        }
        if (breaking_pointer == -1) {
            breaking_pointer = n - 1;
        }
        int left_pointer = (breaking_pointer + 1) % n;
        int right_pointer = breaking_pointer;

        System.out.println("Breaking Pointer: " + breaking_pointer);
        System.out.println("Initial Left Pointer: " + left_pointer);
        System.out.println("Initial Right Pointer: " + right_pointer);
        while (left_pointer != right_pointer) {
            // case1
            if (list.get(left_pointer) + list.get(right_pointer) == target) {
                return true;

            }
            // case 2
            if (list.get(left_pointer) + list.get(right_pointer) < target) {
                left_pointer = (left_pointer + 1) % n;

            } else {
                // case 3
                right_pointer = (right_pointer - 1 + n) % n;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int target = 16;
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.print(pairSum(list, target));

    }

}
