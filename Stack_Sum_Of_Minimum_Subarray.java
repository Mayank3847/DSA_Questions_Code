import java.util.*;

public class Stack_Sum_Of_Minimum_Subarray {
    public static int minSubArraySum(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int minVal = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    minVal = Math.min(minVal, arr[k]);
                }
                sum += minVal;
            }
        }
        return sum;
    }

    public static int minSubArraySumOptimized(int arr[]) {
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        Stack<Integer> st = new Stack<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                left[i] = i + 1;
            } else {
                left[i] = i - st.peek();
            }
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();

            }
            if (st.isEmpty()) {
                right[i] = n - i;
            } else {
                right[i] = st.peek() - i;
            }
            st.push(i);

        }
        for (int i = 0; i < n; i++) {
            long contribution = (long) arr[i] * left[i] * right[i];
            sum = sum + contribution;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 }; // Example input
        System.out.println("Sum of minimum elements of all subarrays: " + minSubArraySum(arr));
        System.out.println("Sum of minimum elements of all subarrays: " + minSubArraySumOptimized(arr));

    }

}
