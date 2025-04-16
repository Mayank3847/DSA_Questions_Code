import java.util.*;

public class Array_largest_subarrays_with_sum_as_0_hashset {
    public static int largestSubarray(int arr[]){
        int n = arr.length;
        int max=0;
        for(int i =0;i<n;i++){
            int sum =0;
            for(int j =i;j<n;j++){
                sum+=arr[j];
                if(sum==0){
                    max=Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum==0){
                len=Math.max(len,i+1);
            }
            if (map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum));
            } else {
                map.put(sum, i);

            }
        }
        System.out.println("Largest subarray with sum as O -> " + len);
        System.out.println("Largest subarray with sum as O -> " +  largestSubarray(arr));
    }

}
