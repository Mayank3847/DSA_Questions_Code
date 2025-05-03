import java.util.*;
import java.util.LinkedList;

public class Stack_Sliding_Window_Maximum_k_sizeWindow {
    public static ArrayList<Integer> maxInWindowSizeK(int arr[], int k) {
        int left = 0;
        int right = 0;
        ArrayList<Integer> max = new ArrayList<>();
        while (right < k - 1) {
            right++;
        }
        while (right < arr.length) {
           max.add( getMax(arr, left, right));
            left++;
            right++;

        }
        return max;
    }

    public static int getMax(int arr[], int left, int right) {
        int maxi = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            maxi = Math.max(maxi, arr[i]);
            // max.add(maxi);
        }
        return maxi;
    }
    public static ArrayList<Integer> maxInWindowSizeKOptimized(int arr[], int k) {
        int n = arr.length;
        Deque<Integer> dq = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
    
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }
    
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.removeLast();
            }
    
            dq.addLast(i);
    
            if (i >= k - 1) {
                list.add(arr[dq.peekFirst()]);
            }
        }
    
        return list;
    }
    

    public static void main(String[] args) {
        int arr[] = { 4, 0, -1, 3, 5, 3, 6, 8 };
        int k = 3;
        ArrayList<Integer>result= maxInWindowSizeK(arr, k);
        System.out.println(result);
        ArrayList<Integer>result1= maxInWindowSizeKOptimized(arr, k);
        System.out.println(result1);

    }
}
