import java.util.*;

public class HashMap_TwoSum {
    public int[] twoSum(int arr[], int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int ans = target - arr[i];
            if (map.containsKey(ans)) {
                return new int[] { map.get(ans), i };
            }
            map.put(arr[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {

        HashMap_TwoSum sum = new HashMap_TwoSum();
        int[] arr = { 3, 4, 9, 2 };
        int target = 5;
        int result[] = sum.twoSum(arr, target);
        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("Sum not found ");
        }
    }

}
