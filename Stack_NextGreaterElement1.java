import java.util.*;

public class Stack_NextGreaterElement1 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!st.isEmpty() && st.peek() <= num) {
                st.pop();
            }
            if (st.isEmpty()) {
                map.put(num, -1);
            } else {
                map.put(num, st.peek());
            }
            st.push(num);
        }
        int result[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println("Output: " + Arrays.toString(nextGreaterElement(nums1, nums2))); 
        // Expected Output: [-1, 3, -1]

        int[] nums1_2 = {2, 4};
        int[] nums2_2 = {1, 2, 3, 4};
        System.out.println("Output: " + Arrays.toString(nextGreaterElement(nums1_2, nums2_2))); 
        // Expected Output: [3, -1]

        int[] nums1_3 = {5, 3, 6};
        int[] nums2_3 = {3, 5, 1, 6, 2};
        System.out.println("Output: " + Arrays.toString(nextGreaterElement(nums1_3, nums2_3)));
        
    }

}
